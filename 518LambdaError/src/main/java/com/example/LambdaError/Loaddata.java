package com.example.LambdaError;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class Loaddata {


    @Bean
    CommandLineRunner initData(MacDao md){
        return args -> {

            log.info("preloading"+ md.save(new Mac(1L,"java","1000")));
            log.info("preloading"+ md.save(new Mac(2L,"php","1000")));
            log.info("preloading"+ md.save(new Mac(3L,"dot","1000")));

        };
    }
}
