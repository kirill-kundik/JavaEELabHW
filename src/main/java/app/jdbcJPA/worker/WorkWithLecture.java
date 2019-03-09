package app.jdbcJPA.worker;

import app.jdbcJPA.data.dao.LecturesDAO;
import app.jdbcJPA.data.entities.Lecture;
import org.springframework.beans.factory.annotation.Autowired;

public class WorkWithLecture {

    @Autowired
    LecturesDAO lecturesDAO;

    public Lecture addLecture(Lecture lecture) {
        lecture = lecturesDAO.addLecture(lecture);
        System.out.println(lecture);
        return lecture;
    }

}
