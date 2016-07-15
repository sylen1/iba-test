package cz.iba.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-application-context.xml")
public class StudentServiceTest {
    @Autowired
    @Qualifier("studentDbService")
    private StudentService studentService;

    @Before
    public void before(){
        studentService.clear();
    }

    private Student generateStudent(){
        Student student = new Student();
        Random random = new Random();

        String[] names = {"John", "Michal", "Jessie"};
        student.setFirstName(names[random.nextInt(names.length)]);

        String[] lastNames = {"Smith", "Hills", "Johnson"};
        student.setLastName(lastNames[random.nextInt(lastNames.length)]);

        student.setDateOfBirth(new Date());
        student.setSex(random.nextBoolean() ? Sex.MALE : Sex.FEMALE);

        return student;
    }

    private List<Student> generateStudents(int count){
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < count; i++){
            students.add(generateStudent());
        }
        return students;
    }

    @Test
    public void addAndFindAll(){
        List<Student> students = generateStudents(5);
        studentService.addAll(students);
        List<Student> fromDb = studentService.findAll();

        assertEquals(students, fromDb);
    }

    @Test
    public void addAndGet(){
        int countBefore = studentService.findAll().size();
        Student student = generateStudent();
        studentService.add(student);
        int countAfter = studentService.findAll().size();
        assertEquals(countBefore + 1, countAfter);

        Student fromDb = studentService.getById(student.getId());
        assertEquals(student, fromDb);
    }

    @Test
    public void remove(){
        Student student = generateStudent();
        studentService.add(student);

        studentService.remove(student);

        boolean contains = studentService.findAll().contains(student);
        assertFalse(contains);
    }

    @Test
    public void removeById(){
        Student student = generateStudent();
        studentService.add(student);

        studentService.remove(student.getId());

        boolean contains = studentService.findAll().contains(student);
        assertFalse(contains);
    }

    @Test
    public void removeAll(){
        List<Student> students = generateStudents(5);
        studentService.addAll(students);
        studentService.removeAll(students);
        int count = studentService.findAll().size();

        assertEquals(0, count);
    }

    @Test
    public void update(){
        Student student = generateStudent();
        studentService.add(student);

        student.setFirstName(student.getFirstName() + "first name modification");
        student.setLastName(student.getLastName() + "last name modification");
        student.setSex(student.getSex() == Sex.MALE ? Sex.FEMALE : Sex.MALE);
        student.setDateOfBirth(new Date());

        studentService.update(student);
        Student fromDb = studentService.getById(student.getId());

        assertEquals(student, fromDb);
    }

    @Test
    public void clear(){
        studentService.addAll(generateStudents(5));
        studentService.clear();
        boolean isEmpty = studentService.findAll().isEmpty();
        assertTrue(isEmpty);
    }
}
