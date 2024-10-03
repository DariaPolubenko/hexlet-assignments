package exercise.controller;

import exercise.model.Person;
import exercise.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

public class PeopleController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/people")
    public List<Person> index() {
        return personRepository.findAll();
    }

    @PostMapping("/people")
    public Person create(@RequestBody Person person) {
        personRepository.save(person);
        return person;
    }

    @DeleteMapping("/people/{id}")
    public void delete(@PathVariable Long id) {
        personRepository.deleteById(id);
    }
}
