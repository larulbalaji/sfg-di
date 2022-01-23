package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.datasource.TempDatabase;
import guru.springframework.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;


//@PropertySource("classpath:db.properties") // External property loading annotation. Commented when the properties are
// moved to application.properties
@ImportResource("classpath:beans-config.xml") // Commented out the constructorGreetingService in the bottom so it can be
// picked up from the config xml file. This file will be in resources folder.
@Configuration  // If this is commented then this will result in spring not finding the beans for the services mentioned.
@EnableConfigurationProperties(PropConstructorConfig.class)
public class GreetingConfig {

//    I18nEnglishGreetingService i18nEnglishGreetingService() { // This was given a name "i18nService" so change it to "i18nService"
//        return new I18nEnglishGreetingService();
//    }

//    @Bean
//    TempDatabase tempDatabase(@Value("${db.username}") String username, @Value("${db.password}")String password,
//                              @Value("${db.url}")String url) { // here @Value annotation loads properties from
//        // db.properties. which in turn is loaded from the @PropertySource above in class annotation.
//        TempDatabase tempDatabase = new TempDatabase();
//        tempDatabase.setPassword(password);
//        tempDatabase.setUsername(username);
//        tempDatabase.setDbUrl(url);
//
//        return tempDatabase;
//    }

    // Replacing the above @Bean tempDatabase to the one below where properties are loaded from property configuration java file.
    @Bean
    TempDatabase tempDatabase (PropConstructorConfig propConstructorConfig) { //Notice that in the top of this class we
        // have declared the @EnableConfigurationProperties(PropConstructorConfig.class) in order to use this.
        TempDatabase tempDatabase = new TempDatabase();
        tempDatabase.setDbUrl(propConstructorConfig.getUrl());
        tempDatabase.setUsername(propConstructorConfig.getUsername());
        tempDatabase.setPassword(propConstructorConfig.getPassword());
        return tempDatabase;
    }

    @Profile({"ES","default"})
    @Bean("i18nService")
    I18NSpanishService i18NSpanishService() {
        return new I18NSpanishService();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService() { // This was given a name "i18nService" so change it to "i18nService"
        return new I18nEnglishGreetingService();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

//    @Bean // This is useful in making the external libraries as beans.
//    ConstructorGreetingService constructorGreetingService() {
//        return new ConstructorGreetingService();
//    }

    @Bean // Spring will create bean name as the method name created here - if this method is different bean name will change.
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }
}
