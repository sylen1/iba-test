package cz.iba.test;

import java.util.Collection;
import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student getById(int id);
    void add(Student student);
    void addAll(Collection<Student> students);
    void remove(Student student);
    void remove(int id);
    void removeAll(Collection<Student> students);
    void update(Student student);
    void clear();
}
