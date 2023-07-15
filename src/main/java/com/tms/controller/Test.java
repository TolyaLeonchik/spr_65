package com.tms.controller;

import com.tms.Testing.Person;
import com.tms.Testing.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/test")
public class Test {
    public PersonDAO personDAO;

    @Autowired
    public Test(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping("people")
    public String index(Model model) {
        List<Person> people = personDAO.index();
        model.addAttribute("people", people);
//        model.addAttribute("people", personDAO.index());
        return "people/index";
    }
}
