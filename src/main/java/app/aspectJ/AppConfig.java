package app.aspectJ;

import app.aspectJ.annotations.ContestantIntroducer;
import app.aspectJ.annotations.Performer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "app.aspectJ")
public class AppConfig {

    @Bean
    public Performer duke() {
        return new Performer();
    }

    @Bean
    public ContestantIntroducer contestant() {
        return new ContestantIntroducer();
    }

}
