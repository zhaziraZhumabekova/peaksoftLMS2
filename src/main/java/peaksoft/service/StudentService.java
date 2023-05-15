package peaksoft.service;

import peaksoft.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long studentId);
    void addStudent(Long groupId, Student student);
    void updateStudent(Long studentId,Student student);
    void deleteStudent(Student student);
}
