package hibernate.mtm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class App {
	
	private final Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	 @Bean
	    CommandLineRunner initDatabase(final DataInitializer initializer) {
	        return new CommandLineRunner() {
	            @Override
	            public void run(String... arg0) throws Exception {
	                logger.info(
	                        "\n ******** Initializing Data ***********");
	                initializer.initData();
	                
	                logger.info(
	                        "\n ******** Data initialized ***********");
	            }
	        };
	    }
}
