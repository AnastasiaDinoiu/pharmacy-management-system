package com.bdproject.pharmacy.config.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.flyway")
public class FlywayProps {

    private List<String> locations;
    private String schemas;
}
