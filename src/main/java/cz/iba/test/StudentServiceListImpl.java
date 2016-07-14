package cz.iba.test;

import org.springframework.stereotype.Service;

import java.util.*;

@Service("studentService")
public class StudentServiceListImpl implements StudentService {
    private List<Student> database;

    public StudentServiceListImpl() {
        database = new LinkedList<>();
    }

    @Override
    public List<Student> findAll() {
        return Collections.unmodifiableList(database);
    }

    @Override
    public Student getById(int id) {
        return database.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void add(Student student) {
        database.add(student);
    }

    @Override
    public void addAll(Collection<Student> students) {
        database.addAll(students);
    }

    @Override
    public void remove(Student student) {
        database.remove(student);
    }

    @Override
    public void remove(int id) {
        database.removeIf(x -> x.getId() == id);
    }

    @Override
    public void removeAll(Collection<Student> students) {
        database.removeAll(students);
    }

    @Override
    public void update(Student student) {
        database.removeIf(x -> x.getId() == student.getId());
        database.add(student);
    }

    @Override
    public void clear() {
        database.clear();
    }
}
