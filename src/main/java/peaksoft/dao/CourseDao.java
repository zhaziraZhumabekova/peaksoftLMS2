package peaksoft.dao;

import peaksoft.entities.Course;

import java.util.List;

public interface CourseDao {
    List<Course> getAllCourses();
    void addCourse(Long companyId, Course course);
    Course getCourseById(Long courseId);
    void updateCourse(Long id, Course course);
    void deleteCourse(Course course);
    List<Course> getCourseByCompany(Long companyId);
    List<Course> getCourseByName(String name);
}
