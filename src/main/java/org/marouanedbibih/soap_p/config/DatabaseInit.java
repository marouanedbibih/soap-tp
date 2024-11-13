package org.marouanedbibih.soap_p.config;

import org.marouanedbibih.soap_p.compte.Compte;
import org.marouanedbibih.soap_p.compte.CompteRepository;
import org.marouanedbibih.soap_p.compte.TypeCompte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class DatabaseInit {

    Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Bean
    public CommandLineRunner initData(CompteRepository compteRepository) {
        return args -> {
            // Creating some sample Compte data
            Compte compte1 = new Compte();
            compte1.setAmount(1000.0);
            compte1.setCreatedDate(new Date());
            compte1.setType(TypeCompte.COURANT);

            Compte compte2 = new Compte();
            compte2.setAmount(2000.0);
            compte2.setCreatedDate(new Date());
            compte2.setType(TypeCompte.EPARGNE);

            // Saving the data to the database
            compteRepository.save(compte1);
            compteRepository.save(compte2);

            logger.info("Sample data inserted into 'comptes' table");
        };
    }
}