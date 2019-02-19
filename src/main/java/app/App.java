package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private EventLogger logger;
    @Autowired
    private Client client;

    public App(EventLogger logger) {
        this.logger = logger;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(client.getId() + "", client.getName());
        logger.logEvent(message);
        logger.logEvent("Client's friends :" + String.join(" and ", client.getFriends()));
    }

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");

        HelloWorld obj = (HelloWorld) context.getBean("helloBean");
        obj.printHello();

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ApplicationConfiguration.class);
        ctx.register(AdditionalConfiguration.class);
        ctx.refresh();

        App app = ctx.getBean(App.class);
        app.logEvent("event called for user 1");

        //Annotation application context


        Account account = ctx.getBean(Account.class);
        System.out.println(account.getInfo());

        Foo foo = ctx.getBean(Foo.class);
        Bar bar = ctx.getBean(Bar.class);

        foo.sayHello();
        bar.sayHello();

    }

}
