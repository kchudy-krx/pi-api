package pl.com.krx.piapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"pl.com.krx.piapi.repository"})
@EnableTransactionManagement
public class DataConfig {
}
