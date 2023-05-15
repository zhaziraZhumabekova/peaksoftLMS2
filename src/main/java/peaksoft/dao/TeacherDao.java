package peaksoft.dao;

import peaksoft.entities.Student;
import peaksoft.entities.Teacher;

import java.util.List;

public interface TeacherDao {
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(Long teacherId);
    void addTeacher(Teacher teacher);
    void updateTeacher(Long teacherId,Teacher teacher);
    void deleteTeacher(Teacher teacher);
}
