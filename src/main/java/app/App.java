package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private EventLogger logger;
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
    }

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");

        HelloWorld obj = (HelloWorld) context.getBean("helloBean");
        obj.printHello();

        App app = (App) context.getBean("app");
        app.logEvent("event called for user 1");

    }

}
