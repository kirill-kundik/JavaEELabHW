package app.jdbcEntry.worker;

import app.jdbcEntry.data.entities.Student;
import app.jdbcEntry.data.dao.StudentsDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class WorkWithStudent {

    @Autowired
    private StudentsDAO studentsDao;

    public void saveStudentToDb(Student student) {
        if ((student != null) && (student.getPib() != null) && (!"".equals(student.getPib())) && (student.getCourse() > 0)) {
            studentsDao.addStudent(student);
            System.out.println("Student have been saved " + student);
        }
    }
}
