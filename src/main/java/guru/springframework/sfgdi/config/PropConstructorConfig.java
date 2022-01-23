package guru.springframework.sfgdi.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("db") // Using this annotation also needs the use of @EnableConfigurationProperties in the
// @Configuraiton class GreetingConfig where we inject this. Else will show not registered via @EnableConfiguration
public class PropConstructorConfig {
    private final String username;
    private final String password;
    private final String url;

    public PropConstructorConfig(String username, String password, String url) {
        this.username = username;
        this.password = password;
        this.url = url;
    }

    // Cannot use setters for final properties of the classes
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }
}
