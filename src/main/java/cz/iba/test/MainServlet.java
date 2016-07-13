package cz.iba.test;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class MainServlet {

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
    public ModelAndView postForm(@Valid @ModelAttribute Student student, BindingResult bindingResult, Model model){
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
}