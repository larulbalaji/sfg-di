package guru.springframework.sfgdi.config;


import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JokeConfig {

    @Bean
    ChuckNorrisQuotes chuckNorrisQuotes () {
        return new ChuckNorrisQuotes();
    }
}
