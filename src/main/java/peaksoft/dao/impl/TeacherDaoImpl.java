package peaksoft.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.TeacherDao;
import peaksoft.entities.Student;
import peaksoft.entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Transactional
public class TeacherDaoImpl implements TeacherDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = entityManager.createQuery("From Teacher", Teacher.class).getResultList();
        return teachers;
    }

    @Override
    public Teacher getTeacherById(Long teacherId) {
        Teacher teacher = entityManager.find(Teacher.class, teacherId);
        return teacher;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        entityManager.persist(teacher);
    }

    @Override
    public void updateTeacher(Long teacherId, Teacher teacher) {
        Teacher teacher1 = entityManager.find(Teacher.class, teacherId);
        teacher1.setId(teacher.getId());
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setEmail(teacher.getEmail());
        entityManager.merge(teacher1);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        entityManager.remove(teacher);
    }
}
