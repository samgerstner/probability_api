package pro.samgerstner.probabilityapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pro.samgerstner.probabilityapi.ForbiddenException;
import pro.samgerstner.probabilityapi.SecurityHelper;
import pro.samgerstner.probabilityapi.entities.BagOfMarbles;
import pro.samgerstner.probabilityapi.entities.Coin;
import pro.samgerstner.probabilityapi.entities.Dice;
import pro.samgerstner.probabilityapi.entities.repositories.BagOfMarblesRepository;
import pro.samgerstner.probabilityapi.entities.repositories.CoinRepository;
import pro.samgerstner.probabilityapi.entities.repositories.DiceRepository;
import pro.samgerstner.probabilityapi.entities.requests.PurgeRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/purge")
public class PurgeController
{
   @Autowired
   private BagOfMarblesRepository marblesRepo;

   @Autowired
   private DiceRepository diceRepo;

   @Autowired
   private CoinRepository coinRepo;

   @Value("${application.global-api-key}")
   private String apiKey;

   private boolean validateUnit(String unit)
   {
      if(!unit.equals("min") && !unit.equals("hour") && !unit.equals("day") && !unit.equals("week") && !unit.equals("month"))
      {
         return false;
      }

      return true;
   }

   @GetMapping(path = "/marbles", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   @Tag(name = "Purge", description = "Methods related to purging old objects from the database.")
   public String marbles(@RequestBody PurgeRequest req, @RequestHeader Map<String, String> headers)
   {
      if(!SecurityHelper.checkForApiKey(headers, apiKey))
      {
         throw new ForbiddenException();
      }

      if(!validateUnit(req.getUnit()))
      {
         return "{\"status\": \"error\",\"message\": \"Invalid unit.\"}";
      }

      List<BagOfMarbles> bags = marblesRepo.findAll();
      LocalDateTime maxCreatedDate = LocalDateTime.now();
      int decreaseBy = req.getValue() * -1;

      switch(req.getUnit())
      {
         case "min":
            maxCreatedDate.plusMinutes(decreaseBy);
            break;

         case "hour":
            maxCreatedDate.plusHours(decreaseBy);
            break;

         case "day":
            maxCreatedDate.plusDays(decreaseBy);
            break;

         case "week":
            maxCreatedDate.plusWeeks(decreaseBy);
            break;

         case "month":
            maxCreatedDate.plusMonths(decreaseBy);
            break;
      }

      for(BagOfMarbles bag : bags)
      {
         LocalDateTime createdAt = LocalDateTime.parse(bag.getCreatedAt());
         if(createdAt.isBefore(maxCreatedDate))
         {
            marblesRepo.delete(bag);
         }
      }

      return "{\"status\": \"success\",\"message\": \"Bags of marbles purged successfully.\"}";
   }

   @GetMapping(path = "/dice", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   @Tag(name = "Purge", description = "Methods related to purging old objects from the database.")
   public String dice(@RequestBody PurgeRequest req, @RequestHeader Map<String, String> headers)
   {
      if(!SecurityHelper.checkForApiKey(headers, apiKey))
      {
         throw new ForbiddenException();
      }

      if(!validateUnit(req.getUnit()))
      {
         return "{\"status\": \"error\",\"message\": \"Invalid unit.\"}";
      }

      List<Dice> diceList = diceRepo.findAll();
      LocalDateTime maxCreatedDate = LocalDateTime.now();
      int decreaseBy = req.getValue() * -1;

      switch(req.getUnit())
      {
         case "min":
            maxCreatedDate.plusMinutes(decreaseBy);
            break;

         case "hour":
            maxCreatedDate.plusHours(decreaseBy);
            break;

         case "day":
            maxCreatedDate.plusDays(decreaseBy);
            break;

         case "week":
            maxCreatedDate.plusWeeks(decreaseBy);
            break;

         case "month":
            maxCreatedDate.plusMonths(decreaseBy);
            break;
      }

      for(Dice dice : diceList)
      {
         LocalDateTime createdAt = LocalDateTime.parse(dice.getCreatedAt());
         if(createdAt.isBefore(maxCreatedDate))
         {
            diceRepo.delete(dice);
         }
      }

      return "{\"status\": \"success\",\"message\": \"Dice purged successfully.\"}";
   }

   @GetMapping(path = "/coins", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   @Tag(name = "Purge", description = "Methods related to purging old objects from the database.")
   public String coins(@RequestBody PurgeRequest req, @RequestHeader Map<String, String> headers)
   {
      if(!SecurityHelper.checkForApiKey(headers, apiKey))
      {
         throw new ForbiddenException();
      }

      if(!validateUnit(req.getUnit()))
      {
         return "{\"status\": \"error\",\"message\": \"Invalid unit.\"}";
      }

      List<Coin> coinList = coinRepo.findAll();
      LocalDateTime maxCreatedDate = LocalDateTime.now();
      int decreaseBy = req.getValue() * -1;

      switch(req.getUnit())
      {
         case "min":
            maxCreatedDate.plusMinutes(decreaseBy);
            break;

         case "hour":
            maxCreatedDate.plusHours(decreaseBy);
            break;

         case "day":
            maxCreatedDate.plusDays(decreaseBy);
            break;

         case "week":
            maxCreatedDate.plusWeeks(decreaseBy);
            break;

         case "month":
            maxCreatedDate.plusMonths(decreaseBy);
            break;
      }

      for(Coin coin : coinList)
      {
         LocalDateTime createdAt = LocalDateTime.parse(coin.getCreatedAt());
         if(createdAt.isBefore(maxCreatedDate))
         {
            coinRepo.delete(coin);
         }
      }

      return "{\"status\": \"success\",\"message\": \"Dice purged successfully.\"}";
   }
}