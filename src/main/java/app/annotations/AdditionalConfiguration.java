package app.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdditionalConfiguration {

    @Bean(initMethod = "init")
    public Foo foo() {
        return new Foo();
    }

    @Bean(destroyMethod = "cleanup")
    public Bar bar() {
        return new Bar();
    }

}

class Foo {

    public void init() {
        // initialization logic
        System.out.println("Object Foo was created.");
    }

    public void sayHello() {
        System.out.println("Hello from Foo");
    }

}

class Bar {

    public void cleanup() {
        // destruction logic
        System.out.println("Bean Bar was destroyed");
    }

    public void sayHello() {
        System.out.println("Hello from Bar");
    }

}
