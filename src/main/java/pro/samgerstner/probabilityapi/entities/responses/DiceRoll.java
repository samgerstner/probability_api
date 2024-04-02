package pro.samgerstner.probabilityapi.entities.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DiceRoll
{
   @JsonProperty("dice_number")
   private int diceNumber;

   @JsonProperty("roll_value")
   private int rollValue;

   public DiceRoll(int diceNumber, int rollValue)
   {
      this.diceNumber = diceNumber;
      this.rollValue = rollValue;
   }

   public int getDiceNumber()
   {
      return diceNumber;
   }

   public int getRollValue()
   {
      return rollValue;
   }
}