package ru.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.springcourse.dao.PersonDAO;
import ru.springcourse.models.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping
    public String getList(Model model) {
        model.addAttribute("people", personDAO.getList());
        return "people/list";
    }

    @GetMapping("/{id}")
    public String getPerson(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.getPerson(id));
        return "people/person";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person") Person person) {
        personDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.getPerson(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person,
                         @PathVariable("id") int id) {
        personDAO.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }
}
