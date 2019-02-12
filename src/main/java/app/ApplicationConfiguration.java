package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:SpringBean.xml")
public class ApplicationConfiguration {

    @Autowired
    private Client client;

    @Bean
    public Account clientAccount() {
        return new Account(client);
    }

}
