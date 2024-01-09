package com.example.marco.file;


import java.io.File;
import java.nio.file.Files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

@Configuration
public class FileConfig {

    private Logger logger = LoggerFactory.getLogger(FileConfig.class);
    private ResourceLoader resourceLoader = new DefaultResourceLoader();
    
    @Bean
    public CommandLineRunner fileCommandLineRunner(FileService fileService){
        return args -> {
            logger.info("hello from file config using slf4j simple logging facade for java");
            File jesseFile = resourceLoader.getResource("classpath:jesse-pinkman.png").getFile();
            fileService.upsertFileEntity(1L, jesseFile);

            File spyFile = resourceLoader.getResource("classpath:static/spy.png").getFile();
            fileService.upsertFileEntity(2L, spyFile);
        };
    }
}
