package pro.samgerstner.probabilityapi.entities.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import pro.samgerstner.probabilityapi.entities.Dice;

public class DiceRollResponse
{
   @JsonProperty("status_code")
   private String statusCode;

   @JsonProperty("status_message")
   private String statusMessage;

   private Dice dice;

   private DiceRoll[] rolls;

   public DiceRollResponse(String statusCode, String statusMessage, Dice dice, DiceRoll[] rolls)
   {
      this.statusCode = statusCode;
      this.statusMessage = statusMessage;
      this.dice = dice;
      this.rolls = rolls;
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

   public DiceRoll[] getRolls()
   {
      return rolls;
   }
}