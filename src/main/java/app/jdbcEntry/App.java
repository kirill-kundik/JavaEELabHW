package app.jdbcEntry;

import app.jdbcEntry.data.entities.Student;
import app.jdbcEntry.data.entities.Teacher;
import app.jdbcEntry.worker.WorkWithStudent;
import app.jdbcEntry.worker.WorkWithTeacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeansDB.xml");
        WorkWithStudent worker =
                (WorkWithStudent) context.getBean("worker");
//new WorkWithStudent();
        Student testStudent = new Student("Vlad Valt", 5);
        worker.saveStudentToDb(testStudent);

        //Testing hibernate for teacher entity

        WorkWithTeacher workWithTeacher =
                (WorkWithTeacher) context.getBean("teachersWorker");
        Teacher teacher = new Teacher();
        teacher.setFirstname("Andrii");
        teacher.setLastname("Glybovets");
        teacher.setCellphone("+380675097865");
        teacher = workWithTeacher.addTeacher(teacher);
        teacher.setBirthDate(new Date());
        workWithTeacher.saveTacher(teacher);

    }

}
