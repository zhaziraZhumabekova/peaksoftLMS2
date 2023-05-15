package peaksoft.service;

import peaksoft.entities.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();
    void addGroup(Long courseId, Group group);
    Group getGroupById(Long GroupId);
    void updateGroup(Long id, Group group);
    void deleteGroup(Group group);
    List<Group> getGroupByCourse(Long courseId);
    List<Group> getGroupByName(String name);
}
