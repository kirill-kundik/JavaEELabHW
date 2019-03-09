package app.jdbcJPA;

import app.jdbcJPA.data.entities.Lecture;
import app.jdbcJPA.worker.WorkWithLecture;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("db/jpa/SpringBeansJPA.xml");
        Lecture lecture = new Lecture();
        lecture.setName("Introduction to Spring");
        lecture.setCredits(2.5);
        WorkWithLecture worker = (WorkWithLecture)context.getBean("worker");
        worker.addLecture(lecture);


    }

}
