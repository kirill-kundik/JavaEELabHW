package app.jdbcEntry.data.dao.impl;

import app.jdbcEntry.data.dao.TeachersDAO;
import app.jdbcEntry.data.entities.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateTeacherDAO implements TeachersDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        currentSession().save(teacher);
    }

    @Override
    public Teacher getTeacherById(int id) {
        return (Teacher) currentSession().get(Teacher.class, id);
    }

    @Override
    public void saveTacher(Teacher teacher) {
        currentSession().update(teacher);
    }

}
