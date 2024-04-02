package pro.samgerstner.probabilityapi.entities.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenericRequest
{
   @JsonProperty(value = "guid", required = true)
   private String guid;

   @JsonProperty(value = "secret_key", required = true)
   private String secretKey;

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
}