package com.guimi.estacionamento.config;

import com.guimi.estacionamento.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
public class TestConfig {
    @Autowired
    private DBService dbService;
    @Bean
    public boolean instantiateDataBase() throws ParseException {
        dbService.instantiateTestDatabase();

        return true;
    }

}
