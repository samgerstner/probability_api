package pro.samgerstner.probabilityapi.entities.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import pro.samgerstner.probabilityapi.entities.BagOfMarbles;

public class BagOfMarblesDrawResponse
{
   @JsonProperty("status_code")
   private String statusCode;

   @JsonProperty("status_message")
   private String statusMessage;

   @JsonProperty("marble_color")
   private String marbleColor;

   @JsonProperty("bag_of_marbles")
   private BagOfMarbles bagOfMarbles;

   public BagOfMarblesDrawResponse(String statusCode, String statusMessage, String marbleColor, BagOfMarbles bagOfMarbles)
   {
      this.statusCode = statusCode;
      this.statusMessage = statusMessage;
      this.marbleColor = marbleColor;
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

   public String getMarbleColor()
   {
      return marbleColor;
   }
}