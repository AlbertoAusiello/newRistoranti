package it.sysman.progettoristoranti;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories("it.sysman.progettoristoranti.Repository")
@SpringBootApplication
public class ProgettoRistorantiApplication {

	//private  final static Log logger = LogFactory.getLog(ProgettoRistorantiApplication.class);
	private static final Logger LOGGER = LogManager.getLogger(ProgettoRistorantiApplication.class);
	
	public static void main(String[] args) {
		
		SpringApplication.run(ProgettoRistorantiApplication.class, args);
		
		LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
        File file = new File("C:\\Users\\sarex\\Documents\\GitHub\\progetto-ristorani\\progetto-ristoranti\\src\\main\\resources\\log4j2.xml");
        context.setConfigLocation(file.toURI());
		
        LOGGER.debug("Debug message");
        LOGGER.info("Isnfo message");
        LOGGER.warn("Warning message");
        LOGGER.error("Error message");
        LOGGER.fatal("Fatal message");
		
	}

}
