package com.lalo104lucky.CVDEJF.rest;

import com.lalo104lucky.CVDEJF.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CVAPiController {

    @GetMapping("/person")
    public Person getPerson() {
        return new Person("Diego", "Jaimez", "Desarrollador Full Stack");
    }
}
