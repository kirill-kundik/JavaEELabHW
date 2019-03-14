package app.jdbcJPA.worker;

import app.jdbcJPA.data.dao.LecturesDAO;
import app.jdbcJPA.data.entities.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class WorkWithLecture {

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    LecturesDAO lecturesDAO;

    public Lecture addLecture(final Lecture lecture) {
        transactionTemplate.execute((TransactionCallback<Void>) transactionStatus -> {
            try {
                lecturesDAO.addLecture(lecture);
                System.out.println("Lecture has been added: " + lecture);
            } catch (RuntimeException e) {
                transactionStatus.setRollbackOnly();
                throw e;
            }
            return null;
        });
        return lecture;
    }

}
