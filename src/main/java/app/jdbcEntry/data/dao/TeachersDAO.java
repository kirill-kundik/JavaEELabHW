package app.jdbcEntry.data.dao;

import app.jdbcEntry.data.entities.Teacher;

public interface TeachersDAO {

    public void addTeacher(Teacher teacher);
    public Teacher getTeacherById(int id);
    public void saveTacher(Teacher teacher);

}
