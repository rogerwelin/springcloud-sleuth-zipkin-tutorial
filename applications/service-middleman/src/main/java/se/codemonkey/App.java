package se.codemonkey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class App {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/getquote", method = RequestMethod.GET)
    public String transfer() {
        String apa = restTemplate.getForObject("http://localhost:9000/quote", String.class);
        log.info("Request on getquote endpoint");
        return apa;
    }

    public static void main(String[] args) throws Exception {
      SpringApplication.run(App.class, args);
    }
}
