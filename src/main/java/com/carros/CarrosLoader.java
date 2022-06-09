package com.carros;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(CarrosRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Carros(null, "2012", "Focus 2.0 Automático", "DEW-9000", "300.000")));
      
    };
  }
}