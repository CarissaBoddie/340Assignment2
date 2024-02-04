package com.example.Assignement2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
                getJoke();
                System.exit(0);
	}

        public static void getJoke() {
        try {
            String url = "https://official-joke-api.appspot.com/random_joke";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonJoke = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonJoke);

            String setup = root.findValue("setup").asText();
            String punchline = root.findValue("punchline").asText();

            System.out.println("**********Funny Joke********");
            System.out.println("Setup: " + setup);
            System.out.println("Punchline: "  + punchline);

        } catch (JsonProcessingException ex) {
            Logger.getLogger(Application.class.getName()).log(
                    Level.SEVERE,
                    null, ex);
            System.out.println("error in getJoke");

        }
    }
        
        
}
