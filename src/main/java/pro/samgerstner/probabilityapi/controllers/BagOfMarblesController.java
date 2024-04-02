package pro.samgerstner.probabilityapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pro.samgerstner.probabilityapi.SecurityHelper;
import pro.samgerstner.probabilityapi.entities.BagOfMarbles;
import pro.samgerstner.probabilityapi.entities.requests.CreateBagOfMarblesRequest;
import pro.samgerstner.probabilityapi.entities.requests.EditBagOfMarblesRequest;
import pro.samgerstner.probabilityapi.entities.requests.GenericRequest;
import pro.samgerstner.probabilityapi.entities.responses.BagOfMarblesDrawResponse;
import pro.samgerstner.probabilityapi.entities.responses.BagOfMarblesResponse;
import pro.samgerstner.probabilityapi.entities.repositories.BagOfMarblesRepository;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/marbles", produces = MediaType.APPLICATION_JSON_VALUE)
public class BagOfMarblesController
{
   @Autowired
   private BagOfMarblesRepository marblesRepo;

   @Value("${application.global-api-key}")
   private String apiKey;

   @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
   @Tag(name = "Marbles", description = "Methods related to drawing marbles from a bag.")
   public BagOfMarblesResponse create(@RequestBody CreateBagOfMarblesRequest req)
   {
      BagOfMarbles bag = new BagOfMarbles();
      bag.setNumRed(req.getNumRed());
      bag.setNumGreen(req.getNumGreen());
      bag.setNumBlue(req.getNumBlue());
      bag.setNumYellow(req.getNumYellow());
      bag.setGuid(UUID.randomUUID().toString());
      bag.setCreatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
      bag.generateSecretKey();
      marblesRepo.save(bag);
      return new BagOfMarblesResponse("success", "Successfully created a new bag of marbles.", bag);
   }

   @GetMapping(path = "/details", consumes = MediaType.APPLICATION_JSON_VALUE)
   @Tag(name = "Marbles", description = "Methods related to drawing marbles from a bag.")
   public BagOfMarblesResponse details(@RequestBody GenericRequest req, @RequestHeader Map<String, String> headers)
   {
      Optional<BagOfMarbles> bagOptional = marblesRepo.findById(req.getGuid());
      BagOfMarbles bag;

      if(bagOptional.isEmpty())
      {
         return new BagOfMarblesResponse("error", "Could not find a bag of marbles with the provided GUID.", null);
      }

      bag = bagOptional.get();
      if(!bag.getSecretKey().equals(req.getSecretKey()) && !SecurityHelper.checkForApiKey(headers, apiKey))
      {
         return new BagOfMarblesResponse("error", "Incorrect secret key.", null);
      }

      return new BagOfMarblesResponse("success", "Successfully located the bag of marbles with the provided GUID.", bag);
   }

   @PostMapping(path = "/edit", consumes = MediaType.APPLICATION_JSON_VALUE)
   @Tag(name = "Marbles", description = "Methods related to drawing marbles from a bag.")
   public BagOfMarblesResponse edit(@RequestBody EditBagOfMarblesRequest req, @RequestHeader Map<String, String> headers)
   {
      Optional<BagOfMarbles> bagOptional = marblesRepo.findById(req.getGuid());
      BagOfMarbles bag;

      if(bagOptional.isEmpty())
      {
         return new BagOfMarblesResponse("error", "Could not find a bag of marbles with the provided GUID.", null);
      }

      bag = bagOptional.get();
      if(!bag.getSecretKey().equals(req.getSecretKey()) && !SecurityHelper.checkForApiKey(headers, apiKey))
      {
         return new BagOfMarblesResponse("error", "Incorrect secret key.", null);
      }

      bag.setNumRed(req.getNumRed());
      bag.setNumGreen(req.getNumGreen());
      bag.setNumBlue(req.getNumBlue());
      bag.setNumYellow(req.getNumYellow());
      marblesRepo.save(bag);

      return new BagOfMarblesResponse("success", "Successfully modified the bag of marbles with the provided GUID.", bag);
   }

   @PostMapping(path = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
   @Tag(name = "Marbles", description = "Methods related to drawing marbles from a bag.")
   public BagOfMarblesResponse delete(@RequestBody GenericRequest req, @RequestHeader Map<String, String> headers)
   {
      Optional<BagOfMarbles> bagOptional = marblesRepo.findById(req.getGuid());
      BagOfMarbles bag;

      if(bagOptional.isEmpty())
      {
         return new BagOfMarblesResponse("error", "Could not find a bag of marbles with the provided GUID.", null);
      }

      bag = bagOptional.get();
      if(!bag.getSecretKey().equals(req.getSecretKey()) && !SecurityHelper.checkForApiKey(headers, apiKey))
      {
         return new BagOfMarblesResponse("error", "Incorrect secret key.", null);
      }

      marblesRepo.delete(bag);
      return new BagOfMarblesResponse("success", "Successfully deleted the bag of marbles with the provided GUID.", bag);
   }

   @PostMapping(path = "/draw-replace", consumes = MediaType.APPLICATION_JSON_VALUE)
   @Tag(name = "Marbles", description = "Methods related to drawing marbles from a bag.")
   public BagOfMarblesDrawResponse drawReplace(@RequestBody GenericRequest req, @RequestHeader Map<String, String> headers)
   {
      Optional<BagOfMarbles> bagOptional = marblesRepo.findById(req.getGuid());
      BagOfMarbles bag;

      if(bagOptional.isEmpty())
      {
         return new BagOfMarblesDrawResponse("error", "Could not find a bag of marbles with the provided GUID.", null, null);
      }

      bag = bagOptional.get();
      if(!bag.getSecretKey().equals(req.getSecretKey()) && !SecurityHelper.checkForApiKey(headers, apiKey))
      {
         return new BagOfMarblesDrawResponse("error", "Incorrect secret key.", null, null);
      }

      return new BagOfMarblesDrawResponse("success", "Successfully drew a marble from the bag and replaced it.", bag.drawReplace(), bag);
   }

   @PostMapping(path = "/draw-no-replace", consumes = MediaType.APPLICATION_JSON_VALUE)
   @Tag(name = "Marbles", description = "Methods related to drawing marbles from a bag.")
   public BagOfMarblesDrawResponse drawNoReplace(@RequestBody GenericRequest req, @RequestHeader Map<String, String> headers)
   {
      Optional<BagOfMarbles> bagOptional = marblesRepo.findById(req.getGuid());
      BagOfMarbles bag;

      if(bagOptional.isEmpty())
      {
         return new BagOfMarblesDrawResponse("error", "Could not find a bag of marbles with the provided GUID.", null, null);
      }

      bag = bagOptional.get();
      if(!bag.getSecretKey().equals(req.getSecretKey()) && !SecurityHelper.checkForApiKey(headers, apiKey))
      {
         return new BagOfMarblesDrawResponse("error", "Incorrect secret key.", null, null);
      }

      String color = bag.drawNoReplace();
      marblesRepo.save(bag);
      return new BagOfMarblesDrawResponse("success", "Successfully drew a marble from the bag and replaced it.", color, bag);
   }
}