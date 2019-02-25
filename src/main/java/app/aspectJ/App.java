package app.aspectJ;

import app.aspectJ.annotations.Contestant;
import app.aspectJ.annotations.IPerformer;
import app.aspectJ.xml.Magician;
import app.aspectJ.xml.Thinker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("aspectJ.xml");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        Contestant contestant = (Contestant) ctx.getBean("duke");
        contestant.receiveAward();

        IPerformer performer = (IPerformer) ctx.getBean("duke");
        performer.perform();

        Thinker volunteer = (Thinker) context.getBean("volunteer");
        Magician magician = (Magician) context.getBean("magician");
        volunteer.thinkOfSomething("I am THINKING ...");
        System.out.println(magician.getThoughts());

    }
}
