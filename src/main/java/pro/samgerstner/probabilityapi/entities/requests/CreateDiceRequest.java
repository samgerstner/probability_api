package pro.samgerstner.probabilityapi.entities.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;

public class CreateDiceRequest
{
   @JsonProperty(value = "num_dice", required = true)
   @Min(value = 1)
   private int numDice;

   @JsonProperty(value = "num_sides", required = true)
   @Min(value = 4)
   private int numSides;

   public int getNumDice()
   {
      return numDice;
   }

   public void setNumDice(int numDice)
   {
      this.numDice = numDice;
   }

   public int getNumSides()
   {
      return numSides;
   }

   public void setNumSides(int numSides)
   {
      this.numSides = numSides;
   }
}