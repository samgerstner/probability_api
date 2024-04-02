package pro.samgerstner.probabilityapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pro.samgerstner.probabilityapi.SecurityHelper;
import pro.samgerstner.probabilityapi.entities.Dice;
import pro.samgerstner.probabilityapi.entities.requests.CreateDiceRequest;
import pro.samgerstner.probabilityapi.entities.requests.EditDiceRequest;
import pro.samgerstner.probabilityapi.entities.requests.GenericRequest;
import pro.samgerstner.probabilityapi.entities.responses.DiceResponse;
import pro.samgerstner.probabilityapi.entities.responses.DiceRollResponse;
import pro.samgerstner.probabilityapi.entities.repositories.DiceRepository;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/dice", produces = MediaType.APPLICATION_JSON_VALUE)
public class DiceController
{
   @Autowired
   private DiceRepository diceRepo;

   @Value("${application.global-api-key}")
   private String apiKey;

   @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
   @Tag(name = "Dice", description = "Methods related to rolling a set of dice.")
   public DiceResponse create(@RequestBody CreateDiceRequest req)
   {
      Dice dice = new Dice();
      dice.setNumDice(req.getNumDice());
      dice.setNumSides(req.getNumSides());
      dice.setGuid(UUID.randomUUID().toString());
      dice.setCreatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
      dice.generateSecretKey();
      diceRepo.save(dice);
      return new DiceResponse("success", "Successfully created a new set of dice.", dice);
   }

   @GetMapping(path = "/details", consumes = MediaType.APPLICATION_JSON_VALUE)
   @Tag(name = "Dice", description = "Methods related to rolling a set of dice.")
   public DiceResponse details(@RequestBody GenericRequest req, @RequestHeader Map<String, String> headers)
   {
      Optional<Dice> diceOptional = diceRepo.findById(req.getGuid());
      Dice dice;

      if(diceOptional.isEmpty())
      {
         return new DiceResponse("error", "Could not find a dice set with the provided GUID.", null);
      }

      dice = diceOptional.get();
      if(!req.getSecretKey().equals(dice.getSecretKey()) && !SecurityHelper.checkForApiKey(headers, apiKey))
      {
         return new DiceResponse("error", "Incorrect secret key.", null);
      }

      return new DiceResponse("success", "Successfully located the dice set with the provided GUID.", dice);
   }

   @PostMapping(path = "/edit", consumes = MediaType.APPLICATION_JSON_VALUE)
   @Tag(name = "Dice", description = "Methods related to rolling a set of dice.")
   public DiceResponse edit(@RequestBody EditDiceRequest req, @RequestHeader Map<String, String> headers)
   {
      Optional<Dice> diceOptional = diceRepo.findById(req.getGuid());
      Dice dice;

      if(diceOptional.isEmpty())
      {
         return new DiceResponse("error", "Could not find a dice set with the provided GUID.", null);
      }

      dice = diceOptional.get();
      if(!req.getSecretKey().equals(dice.getSecretKey()) && !SecurityHelper.checkForApiKey(headers, apiKey))
      {
         return new DiceResponse("error", "Incorrect secret key.", null);
      }

      dice.setNumDice(req.getNumDice());
      dice.setNumSides(req.getNumSides());
      diceRepo.save(dice);
      return new DiceResponse("success", "Successfully modified the dice set with the provided GUID.", dice);
   }

   @PostMapping(path = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
   @Tag(name = "Dice", description = "Methods related to rolling a set of dice.")
   public DiceResponse delete(@RequestBody GenericRequest req, @RequestHeader Map<String, String> headers)
   {
      Optional<Dice> diceOptional = diceRepo.findById(req.getGuid());
      Dice dice;

      if(diceOptional.isEmpty())
      {
         return new DiceResponse("error", "Could not find a dice set with the provided GUID.", null);
      }

      dice = diceOptional.get();
      if(!req.getSecretKey().equals(dice.getSecretKey()) && !SecurityHelper.checkForApiKey(headers, apiKey))
      {
         return new DiceResponse("error", "Incorrect secret key.", null);
      }

      diceRepo.delete(dice);
      return new DiceResponse("success", "Successfully deleted the dice set with the provided GUID.", dice);
   }

   @PostMapping(path = "/roll", consumes = MediaType.APPLICATION_JSON_VALUE)
   @Tag(name = "Dice", description = "Methods related to rolling a set of dice.")
   public DiceRollResponse roll(@RequestBody GenericRequest req, @RequestHeader Map<String, String> headers)
   {
      Optional<Dice> diceOptional = diceRepo.findById(req.getGuid());
      Dice dice;

      if(diceOptional.isEmpty())
      {
         return new DiceRollResponse("error", "Could not find a dice set with the provided GUID.", null, null);
      }

      dice = diceOptional.get();
      if(!req.getSecretKey().equals(dice.getSecretKey()) && !SecurityHelper.checkForApiKey(headers, apiKey))
      {
         return new DiceRollResponse("error", "Incorrect secret key.", null, null);
      }

      return new DiceRollResponse("success", "Successfully rolled the dice set with the provided GUID.", dice, dice.rollDice());
   }
}