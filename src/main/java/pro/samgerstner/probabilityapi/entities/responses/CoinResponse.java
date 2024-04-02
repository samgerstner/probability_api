package pro.samgerstner.probabilityapi.entities.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import pro.samgerstner.probabilityapi.entities.Coin;

public class CoinResponse
{
   @JsonProperty("status_code")
   private String statusCode;

   @JsonProperty("status_message")
   private String statusMessage;

   @JsonProperty("coin")
   private Coin coin;

   public CoinResponse(String statusCode, String statusMessage, Coin coin)
   {
      this.statusCode = statusCode;
      this.statusMessage = statusMessage;
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

   public Coin getCoin()
   {
      return coin;
   }

   public void setCoin(Coin coin)
   {
      this.coin = coin;
   }
}