package guru.springframework.sfgdi;

import guru.springframework.sfgdi.config.PropConfig;
import guru.springframework.sfgdi.config.PropConstructorConfig;
import guru.springframework.sfgdi.controllers.*;
import guru.springframework.sfgdi.datasource.TempDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
// ComponentScan as the name specifies scans for component from the base packages.
// ComponentScan is slower as it uses java reflection to scan classes and methods.
// You can switch to java configuration.
//@ComponentScan(basePackages={"guru.springframework.sfgdi", "guru.springframework.pets"})
// Commented above line as we use java configuration
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");

		TempDatabase tempDatabase = (TempDatabase) ctx.getBean("tempDatabase");
		System.out.println(tempDatabase.getPassword());
		System.out.println(tempDatabase.getUsername());
		System.out.println(tempDatabase.getDbUrl());

		PropConfig propConfig = (PropConfig) ctx.getBean("propConfig");
		System.out.println(propConfig.getUrl());
		System.out.println(propConfig.getPassword());
		System.out.println(propConfig.getUsername());

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		MyController myController = (MyController) ctx.getBean("myController");

		System.out.println("------- Primary Bean");
		System.out.println(myController.sayHello());

		System.out.println("------ Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("--------- Setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("-------- Constructor" );
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		JokeController jokeController = (JokeController) ctx.getBean("jokeController");
		System.out.println(jokeController.returnRandomJoke());

//		PropConstructorConfig propConstructorConfig = (PropConstructorConfig) ctx.getBean("propConstructorConfig");
		// Syntax change here to load property constructor class
		PropConstructorConfig propConstructorConfig = ctx.getBean(PropConstructorConfig.class);
		System.out.println(propConstructorConfig.getUrl());
		System.out.println(propConstructorConfig.getPassword());
		System.out.println(propConstructorConfig.getUsername());

	}

}
