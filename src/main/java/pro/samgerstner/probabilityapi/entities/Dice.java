package pro.samgerstner.probabilityapi.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import pro.samgerstner.probabilityapi.entities.responses.DiceRoll;

@Entity
public class Dice
{
   @Id
   private String guid;

   @JsonProperty("secret_key")
   private String secretKey;

   @JsonProperty("num_sides")
   private int numSides;

   @JsonProperty("num_dice")
   private int numDice;

   @JsonProperty("created_at")
   private String createdAt;

   public Dice() {}

   public void generateSecretKey()
   {
      String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
      StringBuilder builder = new StringBuilder();

      for(int index = 0; index < 32; index++)
      {
         int charIndex = (int)(chars.length() * Math.random());
         builder.append(chars.charAt(charIndex));
      }

      this.secretKey = builder.toString();
   }

   public DiceRoll[] rollDice()
   {
      DiceRoll[] rolls = new DiceRoll[this.numDice];

      for(int index = 0; index < this.numDice; index++)
      {
         int rollValue = (int) (Math.random() * this.numSides + 1);
         rolls[index] = new DiceRoll(index + 1, rollValue);
      }

      return rolls;
   }

   public String getGuid()
   {
      return guid;
   }

   public void setGuid(String guid)
   {
      this.guid = guid;
   }

   public String getSecretKey()
   {
      return secretKey;
   }

   public void setSecretKey(String secretKey)
   {
      this.secretKey = secretKey;
   }

   public int getNumSides()
   {
      return numSides;
   }

   public void setNumSides(int numSides)
   {
      this.numSides = numSides;
   }

   public int getNumDice()
   {
      return numDice;
   }

   public void setNumDice(int numDice)
   {
      this.numDice = numDice;
   }

   public String getCreatedAt()
   {
      return createdAt;
   }

   public void setCreatedAt(String createdAt)
   {
      this.createdAt = createdAt;
   }
}