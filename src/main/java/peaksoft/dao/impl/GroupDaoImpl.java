package peaksoft.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.GroupDao;
import peaksoft.entities.Course;
import peaksoft.entities.Group;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class GroupDaoImpl implements GroupDao {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Group> getAllGroups() {
        List<Group> groups = manager.createQuery("From Group", Group.class).getResultList();
        return groups;
    }

    @Override
    public void addGroup(Long courseId, Group group) {
        Course course = manager.find(Course.class, courseId);
        List<Course> courses = new ArrayList<>();
        courses.add(course);
        List<Group> groups = new ArrayList<>();
        groups.add(group);
        course.setGroups(groups);
        group.setCourses(courses);
        manager.persist(group);
    }

    @Override
    public Group getGroupById(Long groupId) {
        Group group = manager.find(Group.class, groupId);
        return group;
    }

    @Override
    public void updateGroup(Long id, Group group) {
        Group group1 = getGroupById(id);
        group1.setGroupName(group.getGroupName());
        group1.setDateOfStart(group.getDateOfStart());
        group1.setDateOfFinish(group.getDateOfFinish());
        manager.merge(group1);
    }

    @Override
    public void deleteGroup(Group group) {
        manager.remove(manager.contains(group) ? group : manager.merge(group));
    }

    @Override
    public List<Group> getGroupByCourse(Long courseId) {
        List<Group> groups = manager.createQuery("select c from Group c join c.courses cour where cour.id=?1")
                .setParameter(1, courseId).getResultList();
        return groups;    }

    @Override
    public List<Group> getGroupByName(String name) {
        List<Group> groups = manager.createQuery("select c from Course c where c.groupName=?1")
                .setParameter(1, name).getResultList();
        return groups;
    }
}
