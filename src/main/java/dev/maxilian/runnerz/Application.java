package dev.maxilian.runnerz;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import dev.maxilian.runnerz.run.Location;
import dev.maxilian.runnerz.run.Run;
import dev.maxilian.runnerz.run.JdbcRunRepository;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		log.info("Application started successfully! wrong");
	}
	
	// @Bean
	// CommandLineRunner runner(RunRepository runRepository){
	// 	return args -> {
	// 		Run run = new Run(
	// 			2, "First Run", LocalDateTime.now(), 
	// 			LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, 
	// 			Location.OUTDOOR
	// 		);
	// 		// log.info("Run: " + run);
	// 		runRepository.create(run);
	// 	};
	// }
}
