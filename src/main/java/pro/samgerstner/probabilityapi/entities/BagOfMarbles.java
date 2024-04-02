package pro.samgerstner.probabilityapi.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BagOfMarbles
{
   @Id
   private String guid;

   @JsonProperty("num_red")
   private int numRed;

   @JsonProperty("num_green")
   private int numGreen;

   @JsonProperty("num_blue")
   private int numBlue;

   @JsonProperty("num_yellow")
   private int numYellow;

   @JsonProperty("created_at")
   private String createdAt;

   @JsonProperty("secret_key")
   private String secretKey;

   public BagOfMarbles() {}

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

   public String drawReplace()
   {
      int drawIndex = (int) ((Math.random() * (5 - 1)) + 1);
      String color = "";
      switch(drawIndex)
      {
         case 1:
            color = "red";
            break;

         case 2:
            color = "green";
            break;

         case 3:
            color = "blue";
            break;

         case 4:
            color = "yellow";
            break;
      }

      return color;
   }

   public String drawNoReplace()
   {
      int drawIndex = (int) ((Math.random() * (5 - 1)) + 1);
      String color = "";
      switch(drawIndex)
      {
         case 1:
            this.numRed--;
            color = "red";
            break;

         case 2:
            this.numGreen--;
            color = "green";
            break;

         case 3:
            this.numBlue--;
            color = "blue";
            break;

         case 4:
            this.numYellow--;
            color = "yellow";
            break;
      }

      return color;
   }

   public String getGuid()
   {
      return guid;
   }

   public void setGuid(String guid)
   {
      this.guid = guid;
   }

   public int getNumRed()
   {
      return numRed;
   }

   public void setNumRed(int numRed)
   {
      this.numRed = numRed;
   }

   public int getNumGreen()
   {
      return numGreen;
   }

   public void setNumGreen(int numGreen)
   {
      this.numGreen = numGreen;
   }

   public int getNumBlue()
   {
      return numBlue;
   }

   public void setNumBlue(int numBlue)
   {
      this.numBlue = numBlue;
   }

   public int getNumYellow()
   {
      return numYellow;
   }

   public void setNumYellow(int numYellow)
   {
      this.numYellow = numYellow;
   }

   public String getCreatedAt()
   {
      return createdAt;
   }

   public void setCreatedAt(String createdAt)
   {
      this.createdAt = createdAt;
   }

   public String getSecretKey()
   {
      return secretKey;
   }

   public void setSecretKey(String secretKey)
   {
      this.secretKey = secretKey;
   }
}