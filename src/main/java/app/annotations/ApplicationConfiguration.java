package app.annotations;

import app.firstStart.Client;
import app.firstStart.logger.ConsoleEventLogger;
import app.firstStart.logger.EventLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ApplicationConfiguration {

    @Autowired
    private Client client;

    @Autowired
    private EventLogger eventLogger;

    @Bean
    public Account clientAccount() {
        return new Account(client);
    }

    @Bean
    public Client client() {
        Client client = new Client(1, "Kyrylo");
        client.setFriends(Arrays.asList("Nick,Sanya,Maks".split(",")));
        return client;
    }

    @Bean
    public EventLogger eventLogger() {
        return new ConsoleEventLogger();
    }

    @Bean
    public App app() {
        return new App(eventLogger);
    }
}
