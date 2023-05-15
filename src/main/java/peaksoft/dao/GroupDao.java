package peaksoft.dao;

import peaksoft.entities.Course;
import peaksoft.entities.Group;

import java.util.List;

public interface GroupDao {
    List<Group> getAllGroups();
    void addGroup(Long courseId, Group group);
    Group getGroupById(Long GroupId);
    void updateGroup(Long id, Group group);
    void deleteGroup(Group group);
    List<Group> getGroupByCourse(Long courseId);
    List<Group> getGroupByName(String name);
}
