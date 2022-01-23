package guru.springframework.sfgdi.services;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class JokeService {
    private final ChuckNorrisQuotes chuckNorrisQuotes;

//    public JokeService() {
//        this.chuckNorrisQuotes = new ChuckNorrisQuotes(); // Note that we are hard coding object creation.
//        // We need to know how to handle/manage external libraries as managed components in spring.
//    }

    // The argument chuck norris quotes comes from the config package class JokeConfig which returns a bean name
    // chuckNorrisQuotes that is loaded in spring context during configuration and used here for dependency injection.
    // Dependency injection with ChuckNorrisQuotes from JokeConfig in config package.
    public JokeService(ChuckNorrisQuotes chuckNorrisQuotes) {
        this.chuckNorrisQuotes = chuckNorrisQuotes; //
    }

    public String getRandomJokes() {
        return this.chuckNorrisQuotes.getRandomQuote();
    }
}
