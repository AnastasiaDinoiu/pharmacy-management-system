package com.bdproject.pharmacy.config.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.jpa.properties.hibernate")
public class HibernateProps {

    private String dialect;

    private String ddlAuto;

    private String showSql;
}
