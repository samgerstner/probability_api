package pro.samgerstner.probabilityapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfiguration
{
   @Value("${application.info.url}")
   private String url;

   @Value("${application.info.contact-name}")
   private String contactName;

   @Value("${application.info.contact-email}")
   private String contactEmail;

   @Value("${application.info.server-description}")
   private String description;

   @Bean
   public OpenAPI defineOpenApi()
   {
      Server server = new Server();
      server.setUrl(url);
      server.setDescription(description);

      Contact contact = new Contact();
      contact.setName(contactName);
      contact.setEmail(contactEmail);

      Info info = new Info()
              .title("Probability API")
              .version("1.0.0")
              .description("This API allows for simulation of common objects used in probability calculations such as marbles and dice.")
              .contact(contact);

      return new OpenAPI().info(info).servers(List.of(server));
   }
}