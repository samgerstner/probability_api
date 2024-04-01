package pro.samgerstner.probabilityapi.entities.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PurgeRequest
{
   @JsonProperty(value = "value", required = true)
   private int value;

   @JsonProperty(value = "unit", required = true)
   private String unit;

   public int getValue()
   {
      return value;
   }

   public void setValue(int value)
   {
      this.value = value;
   }

   public String getUnit()
   {
      return unit;
   }

   public void setUnit(String unit)
   {
      this.unit = unit;
   }
}