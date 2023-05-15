package peaksoft.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.StudentDao;
import peaksoft.entities.Student;
import peaksoft.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = entityManager.createQuery("From Student", Student.class).getResultList();
        return students;
    }

    @Override
    public Student getStudentById(Long studentId) {
        Student student = entityManager.find(Student.class, studentId);
        return student;
    }

    @Override
    public void addStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void updateStudent(Long studentId, Student student) {
        Student student1 = entityManager.find(Student.class, studentId);
        student1.setId(student.getId());
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        student1.setStudyFormat(student.getStudyFormat()); //enum bolush kerek
        entityManager.merge(student1);
    }

    @Override
    public void deleteStudent(Student student) {
        entityManager.remove(student);    }
}
