package pro.samgerstner.probabilityapi.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Coin
{
   @Id
   private String guid;

   @JsonProperty("secret_key")
   private String secretKey;

   @JsonProperty("created_at")
   private String createdAt;

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

   public String flipCoin()
   {
      int flip = (int)(Math.random() * 2 + 1);
      return flip == 1 ? "heads" : "tails";
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

   public String getCreatedAt()
   {
      return createdAt;
   }

   public void setCreatedAt(String createdAt)
   {
      this.createdAt = createdAt;
   }
}