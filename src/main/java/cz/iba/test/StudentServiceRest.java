package cz.iba.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class StudentServiceRest {

    @Autowired
    @Qualifier("studentDbService")
    private StudentService studentService;

    @RequestMapping("/all")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @RequestMapping("/findById")
    public Student getById(@RequestParam int id) {
        return studentService.getById(id);
    }

    @RequestMapping("/add")
    public void add(@RequestBody Student student) {
        studentService.add(student);
    }

    @RequestMapping("/addAll")
    public void addAll(@RequestBody Collection<Student> students) {
        studentService.addAll(students);
    }

    @RequestMapping("/removeByExample")
    public void remove(@RequestBody Student student) {
        studentService.remove(student);
    }

    @RequestMapping("/removeById")
    public void remove(@RequestParam int id) {
        studentService.remove(id);
    }

    @RequestMapping("/removeAll")
    public void removeAll(@RequestBody Collection<Student> students) {
        studentService.removeAll(students);
    }

    @RequestMapping("/update")
    public void update(@RequestBody Student student) {
        studentService.update(student);
    }
}
