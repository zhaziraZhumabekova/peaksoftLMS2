package peaksoft.dao;

import peaksoft.entities.Student;
import peaksoft.entities.User;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudents();
    Student getStudentById(Long studentId);
    void addStudent(Student student);
    void updateStudent(Long studentId,Student student);
    void deleteStudent(Student student);
}
