package edu.school21.configuration;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource({"classpath:hikari.properties", "classpath:db.properties"})
public class Config {
    @Value("${hikari.username}")
    private String hikariUsername;

    @Value("${hikari.password}")
    private String hikariPassword;

    @Value("${hikari.jdbcUrl}")
    private String hikariJdbcUrl;

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.user}")
    private String dbUser;

    @Value("${db.password}")
    private String dbPassword;

    @Value("${db.driver.name}")
    private String dbDriverName;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public HikariConfig hikariConfig() {
        HikariConfig hikariConfig =  new HikariConfig();
        hikariConfig.setUsername(hikariUsername);
        hikariConfig.setPassword(hikariPassword);
        hikariConfig.setJdbcUrl(hikariJdbcUrl);
        return hikariConfig;
    }

    @Bean
    public DriverManagerDataSource driverManagerDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(dbUrl);
        driverManagerDataSource.setUsername(dbUser);
        driverManagerDataSource.setPassword(dbPassword);
        driverManagerDataSource.setDriverClassName(dbDriverName);
        return driverManagerDataSource;
    }

    @Bean
    public HikariDataSource dataSourceHikari() {
        return new HikariDataSource(hikariConfig());
    }
}
