package cz.iba.test;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView postForm(@ModelAttribute Student student){
        ModelAndView modelAndView = new ModelAndView("student.jsp");
        modelAndView.addObject("student", student);

        System.out.println(student);

        return modelAndView;
    }
}