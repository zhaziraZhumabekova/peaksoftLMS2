package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.StudentDao;
import peaksoft.entities.Student;
import peaksoft.service.StudentService;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;
@Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentDao.getStudentById(studentId);
    }

    @Override
    public void addStudent(Long groupId, Student student) {
    studentDao.addStudent(student);
    }

    @Override
    public void updateStudent(Long studentId, Student student) {
    studentDao.updateStudent(studentId, student);
    }

    @Override
    public void deleteStudent(Student student) {
    studentDao.deleteStudent(student);
    }
}
