package cz.iba.test;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}