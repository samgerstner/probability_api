package pro.samgerstner.probabilityapi.entities.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import pro.samgerstner.probabilityapi.entities.Coin;

public class CoinFlipResponse
{
   @JsonProperty("status_code")
   private String statusCode;

   @JsonProperty("status_message")
   private String statusMessage;

   @JsonProperty("coin_flip")
   private String coinFlip;

   @JsonProperty("coin")
   private Coin coin;

   public CoinFlipResponse(String statusCode, String statusMessage, String coinFlip, Coin coin)
   {
      this.statusCode = statusCode;
      this.statusMessage = statusMessage;
      this.coinFlip = coinFlip;
      this.coin = coin;
   }

   public String getStatusCode()
   {
      return statusCode;
   }

   public void setStatusCode(String statusCode)
   {
      this.statusCode = statusCode;
   }

   public String getStatusMessage()
   {
      return statusMessage;
   }

   public void setStatusMessage(String statusMessage)
   {
      this.statusMessage = statusMessage;
   }

   public String getCoinFlip()
   {
      return coinFlip;
   }

   public void setCoinFlip(String coinFlip)
   {
      this.coinFlip = coinFlip;
   }

   public Coin getCoin()
   {
      return coin;
   }

   public void setCoin(Coin coin)
   {
      this.coin = coin;
   }
}