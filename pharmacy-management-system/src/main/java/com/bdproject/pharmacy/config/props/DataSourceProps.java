package com.bdproject.pharmacy.config.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceProps {

    private String url;
    private String username;
    private String password;
    private String driverClassName;
}
