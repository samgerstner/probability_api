package pro.samgerstner.probabilityapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TestSecurityHelper
{
   @Test
   void testCheckForApiKey()
   {
      Map<String, String> headers1 = new HashMap<String, String>();
      Map<String, String> headers2 = new HashMap<String, String>();

      headers1.put("x-api-key", "test");
      headers2.put("x-bad-header", "test");

      assertTrue(SecurityHelper.checkForApiKey(headers1, "test"));
      assertFalse(SecurityHelper.checkForApiKey(headers2, "test"));
   }
}
