package app.jdbcEntry.data.dao.impl;

import app.jdbcEntry.data.entities.Student;
import app.jdbcEntry.data.dao.StudentsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcStudentDAO implements StudentsDAO {

    private static final String SQL_INSERT_STUDENT = "INSERT INTO students (pib,course) VALUES (?,?)";
    private static final String SQL_SELECT_STUDENT_BY_ID = "SELECT id, pib, course FROM students WHERE id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addStudent(Student student) {
        jdbcTemplate.update(SQL_INSERT_STUDENT,
                student.getPib(),
                student.getCourse());

    }

    @Override
    public Student getStudentById(int id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_STUDENT_BY_ID,
                (rs, rowNum) -> {
                    Student student = new Student();
                    student.setStudentId(rs.getInt(1));
                    student.setPib(rs.getString(2));
                    student.setCourse(rs.getInt(3));
                    return student;
                }, id);

    }
}
