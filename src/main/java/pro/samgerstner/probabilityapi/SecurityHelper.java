package pro.samgerstner.probabilityapi;

import java.util.Map;

public class SecurityHelper
{
   public static boolean checkForApiKey(Map<String, String> headers, String apiKey)
   {
      return headers.containsKey("x-api-key") && headers.get("x-api-key").equals(apiKey);
   }
}