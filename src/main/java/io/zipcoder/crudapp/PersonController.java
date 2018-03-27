package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/people/create", method = RequestMethod.POST)
    public long createPerson(@RequestBody Person person){
        Person savedPerson = personRepository.save(person);
        return savedPerson.getId();
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable long id) {
        return personRepository.findOne(id);
    }


    @RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable long id) {
        personRepository.delete(id);
    }


    @RequestMapping(value = "/people", method = RequestMethod.PUT)
    public Person updatePerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @RequestMapping(value = "/people", method = RequestMethod.GET)
    public List<Person> getPersonList() {
        List<Person> people = new ArrayList<>();
        personRepository.findAll().forEach(person -> people.add(person));
        return people;
    }


}
