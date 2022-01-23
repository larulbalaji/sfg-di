package guru.springframework.sfgdi.config;

import guru.springframework.pets.CatPetService;
import guru.springframework.pets.DogPetService;
import guru.springframework.pets.PetService;
import guru.springframework.pets.PetServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class PetFactoryConfig {

    //This configuration uses a demonstration of pet service factory.
    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Bean
    @Profile({"dog", "default"})
    PetService dogPetService() {
        return  petServiceFactory().getPetService("dog");
    }

    @Bean
    @Profile({"cat"})
    PetService catPetService() {
        return  petServiceFactory().getPetService("cat");
    }
}
