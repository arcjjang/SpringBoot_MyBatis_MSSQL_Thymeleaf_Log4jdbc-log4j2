package com.example.controller;

import com.example.model.Person;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/")
    public String list(Model model) {
        model.addAttribute("persons", personService.getPersonList());
        return "list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "add";
    }

    @RequestMapping("add")
    public String add(Person person) {
        personService.insertPerson(person);
        return "redirect:/";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model, String id) {
        Person person = personService.findPersonById(id);
        model.addAttribute("person", person);
        return "edit";
    }

    @RequestMapping("/edit")
    public String edit(Person person) {
        personService.updatePerson(person);
        return "redirect:/";
    }

    @RequestMapping("/del")
    public String delete(String id) {
        personService.deletePerson(id);
        return "redirect:/";
    }
}
