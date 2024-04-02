package pro.samgerstner.probabilityapi.entities.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import pro.samgerstner.probabilityapi.entities.BagOfMarbles;

public class BagOfMarblesResponse
{
   @JsonProperty("status_code")
   private String statusCode;

   @JsonProperty("status_message")
   private String statusMessage;

   @JsonProperty("bag_of_marbles")
   private BagOfMarbles bagOfMarbles;

   public BagOfMarblesResponse(String statusCode, String statusMessage, BagOfMarbles bagOfMarbles)
   {
      this.statusCode = statusCode;
      this.statusMessage = statusMessage;
      this.bagOfMarbles = bagOfMarbles;
   }

   public String getStatusCode()
   {
      return statusCode;
   }

   public String getStatusMessage()
   {
      return statusMessage;
   }

   public BagOfMarbles getBagOfMarbles()
   {
      return bagOfMarbles;
   }
}