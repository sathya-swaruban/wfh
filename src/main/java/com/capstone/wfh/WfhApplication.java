package com.capstone.wfh;

import com.capstone.wfh.config.CorsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@SuppressWarnings(value = "all")
public class WfhApplication {

    public static void main(String[] args) {
        SpringApplication.run(WfhApplication.class, args);
    }

    @Bean
    public CorsFilter corsFilter() {
        return CorsConfig.corsConfig();
    }

}
