package app.jdbcEntry.data.dao;

import app.jdbcEntry.data.entities.Student;

public interface StudentsDAO {

    public void addStudent(Student student);

    public Student getStudentById(int id);

}
