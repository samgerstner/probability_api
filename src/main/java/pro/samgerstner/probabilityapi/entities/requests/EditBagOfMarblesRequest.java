package pro.samgerstner.probabilityapi.entities.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EditBagOfMarblesRequest
{
   @JsonProperty(value = "guid", required = true)
   private String guid;

   @JsonProperty(value = "secret_key", required = true)
   private String secretKey;

   @JsonProperty(value = "num_red", required = true)
   private int numRed;

   @JsonProperty(value = "num_green", required = true)
   private int numGreen;

   @JsonProperty(value = "num_blue", required = true)
   private int numBlue;

   @JsonProperty(value = "num_yellow", required = true)
   private int numYellow;

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
}