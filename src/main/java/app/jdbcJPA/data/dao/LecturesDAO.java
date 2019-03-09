package app.jdbcJPA.data.dao;

import app.jdbcJPA.data.entities.Lecture;

public interface LecturesDAO {

    public Lecture addLecture(Lecture lecture);

    public Lecture getLecture(int id);

    public void saveLecture(Lecture lecture);

}
