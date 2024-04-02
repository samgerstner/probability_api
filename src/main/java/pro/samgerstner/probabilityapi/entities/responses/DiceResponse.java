package pro.samgerstner.probabilityapi.entities.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import pro.samgerstner.probabilityapi.entities.Dice;

public class DiceResponse
{
   @JsonProperty("status_code")
   private String statusCode;

   @JsonProperty("status_message")
   private String statusMessage;

   @JsonProperty("dice")
   private Dice dice;

   public DiceResponse(String statusCode, String statusMessage, Dice dice)
   {
      this.statusCode = statusCode;
      this.statusMessage = statusMessage;
      this.dice = dice;
   }

   public String getStatusCode()
   {
      return statusCode;
   }

   public String getStatusMessage()
   {
      return statusMessage;
   }

   public Dice getDice()
   {
      return dice;
   }
}