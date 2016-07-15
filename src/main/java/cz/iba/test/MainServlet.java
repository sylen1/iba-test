package cz.iba.test;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class MainServlet {
    @Autowired
    @Qualifier("studentDbService")
    private StudentService studentService;

    @RequestMapping("/")
    public ModelAndView helloIba(@RequestParam(defaultValue = "1") String x){
        ModelAndView modelAndView = new ModelAndView("hello.jsp");

        int number = NumberUtils.toInt(x, 1);
        number = number < 0 ? 1 : number;

        modelAndView.addObject("number", number);

        return modelAndView;
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView getForm(){
        ModelAndView modelAndView = new ModelAndView("form.jsp");
        modelAndView.addObject("student", new Student());
        modelAndView.addObject("sexes", Sex.values());

        return modelAndView;
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public ModelAndView postForm(@Valid @ModelAttribute Student student, BindingResult bindingResult){
        ModelAndView modelAndView;

        if (bindingResult.hasErrors()){
            modelAndView = new ModelAndView("form.jsp");
            modelAndView.addObject("errors", bindingResult.getFieldErrors());
            modelAndView.addObject("student", student);
            modelAndView.addObject("sexes", Sex.values());
        } else {
            modelAndView = new ModelAndView("student.jsp");
            modelAndView.addObject("student", student);
        }

        System.out.println("bindingResult.hasErrors()) == " + bindingResult.hasErrors());
        System.out.println(student);

        return modelAndView;
    }

    @RequestMapping("/all")
    public ModelAndView all(){
        ModelAndView modelAndView = new ModelAndView("/studentList.jsp");

        modelAndView.addObject("students", studentService.findAll());

        return modelAndView;
    }

    @RequestMapping("/student/{id}")
    public ModelAndView studentDetail(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/student.jsp");

        Student student = studentService.getById(id);
        modelAndView.addObject("student", student);

        return modelAndView;
    }

    @RequestMapping("/remove")
    public ModelAndView remove(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("/remove.jsp");

        Student student = studentService.getById(id);
        studentService.remove(id);
        modelAndView.addObject("student", student);

        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getEdit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/updateStudent.jsp");

        Student student = studentService.getById(id);
        modelAndView.addObject("student", student);
        modelAndView.addObject("sexes", Sex.values());

        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView postEdit(@PathVariable int id,@Valid @ModelAttribute Student student, BindingResult bindingResult){
        ModelAndView modelAndView;
        student.setId(id);
        System.out.println(student);

        if (bindingResult.hasErrors()){
            modelAndView = new ModelAndView("/updateStudent.jsp");
            modelAndView.addObject("student", student);
            modelAndView.addObject("sexes", Sex.values());
            modelAndView.addObject("errors", bindingResult.getFieldErrors());
        } else {
            studentService.update(student);
            modelAndView = all();
        }
        return modelAndView;
    }

    @RequestMapping("/create")
    public ModelAndView createStudent(){
        ModelAndView modelAndView = new ModelAndView("/updateStudent.jsp");

        modelAndView.addObject("student", new Student());
        modelAndView.addObject("sexes", Sex.values());

        return modelAndView;
    }
}