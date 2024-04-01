package pro.samgerstner.probabilityapi.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pro.samgerstner.probabilityapi.SecurityHelper;
import pro.samgerstner.probabilityapi.entities.Coin;
import pro.samgerstner.probabilityapi.entities.repositories.CoinRepository;
import pro.samgerstner.probabilityapi.entities.requests.GenericRequest;
import pro.samgerstner.probabilityapi.entities.responses.CoinFlipResponse;
import pro.samgerstner.probabilityapi.entities.responses.CoinResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/coins")
public class CoinController
{
   @Autowired
   private CoinRepository coinRepo;

   @Value("${application.global-api-key}")
   private String apiKey;

   @PostMapping(path = "/create")
   @Tag(name = "Coin", description = "Methods related to flipping a coin.")
   public CoinResponse create()
   {
      Coin coin = new Coin();
      coin.setGuid(UUID.randomUUID().toString());
      coin.generateSecretKey();
      coin.setCreatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
      coinRepo.save(coin);
      return new CoinResponse("success", "Successfully created a new coin.", coin);
   }

   @GetMapping(path = "/details", consumes = MediaType.APPLICATION_JSON_VALUE)
   @Tag(name = "Coin", description = "Methods related to flipping a coin.")
   public CoinResponse details(@RequestBody GenericRequest req, @RequestHeader Map<String, String> headers)
   {
      Optional<Coin> coinOptional = coinRepo.findById(req.getGuid());
      Coin coin;

      if(coinOptional.isEmpty())
      {
         return new CoinResponse("error", "Unable to locate a coin with the provided GUID.", null);
      }

      coin = coinOptional.get();
      if(!coin.getSecretKey().equals(req.getSecretKey()) && !SecurityHelper.checkForApiKey(headers, apiKey))
      {
         return new CoinResponse("error", "Incorrect secret key.", null);
      }

      return new CoinResponse("success", "Successfully located the coin with the provided GUID.", coin);
   }

   @PostMapping(path = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
   @Tag(name = "Coin", description = "Methods related to flipping a coin.")
   public CoinResponse delete(@RequestBody GenericRequest req, @RequestHeader Map<String, String> headers)
   {
      Optional<Coin> coinOptional = coinRepo.findById(req.getGuid());
      Coin coin;

      if(coinOptional.isEmpty())
      {
         return new CoinResponse("error", "Unable to locate a coin with the provided GUID.", null);
      }

      coin = coinOptional.get();
      if(!coin.getSecretKey().equals(req.getSecretKey()) && !SecurityHelper.checkForApiKey(headers, apiKey))
      {
         return new CoinResponse("error", "Incorrect secret key.", null);
      }

      coinRepo.delete(coin);
      return new CoinResponse("success", "Successfully deleted the coin with the provided GUID.", coin);
   }

   @GetMapping(path = "/flip", consumes = MediaType.APPLICATION_JSON_VALUE)
   @Tag(name = "Coin", description = "Methods related to flipping a coin.")
   public CoinFlipResponse flip(@RequestBody GenericRequest req, @RequestHeader Map<String, String> headers)
   {
      Optional<Coin> coinOptional = coinRepo.findById(req.getGuid());
      Coin coin;

      if(coinOptional.isEmpty())
      {
         return new CoinFlipResponse("error", "Unable to locate a coin with the provided GUID.", null, null);
      }

      coin = coinOptional.get();
      if(!coin.getSecretKey().equals(req.getSecretKey()) && !SecurityHelper.checkForApiKey(headers, apiKey))
      {
         return new CoinFlipResponse("error", "Incorrect secret key.", null, null);
      }

      return new CoinFlipResponse("success", "Successfully flipped the coin with the provided GUID.", coin.flipCoin(), coin);
   }
}