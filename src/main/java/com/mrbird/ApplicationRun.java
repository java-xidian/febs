package com.mrbird;

import com.mrbird.common.config.FebsProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDate;
import java.time.LocalTime;


@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.mrbird.*.dao")
@EnableConfigurationProperties({FebsProperties.class})
@EnableCaching
@EnableAsync
public class ApplicationRun extends SpringBootServletInitializer {

    private static Logger log = LoggerFactory.getLogger(ApplicationRun.class);

    /**
     * Spring apache方法启动
     *
     * @param application
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApplicationRun.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun.class, args);
        log.info("FEBS started up successfully at {} {}", LocalDate.now(), LocalTime.now());
    }
}

