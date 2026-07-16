package com.lalo104lucky.CVDEJF.controller;

import com.lalo104lucky.CVDEJF.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/cv")
public class CVController {

    @GetMapping({"/", "", "/index"})
    public String index(Model model) {
        Person person = new Person("Diego", "Jaimez", "Desarrollador");
        model.addAttribute("name", "Die");
        model.addAttribute("person", person);
        return "index";
    }

    //@GetMapping("/lalo")
    @RequestMapping(value = "/lalo", method = RequestMethod.GET)
    public String lalo() {
        return "lalo";
    }
}
