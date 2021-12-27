package br.com.macvinny.goanddo.controller;

import br.com.macvinny.goanddo.model.Person;
import br.com.macvinny.goanddo.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPerson() {
        List<Person> persons = personService.findAllPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/active")
    public ResponseEntity<List<Person>> getActivePerson() {
        List<Person> persons = personService.findActivePersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id) {
        Person person = personService.findPersonById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("/find/cpf/{cpf}")
    public ResponseEntity<Person> getPersonByCpf(@PathVariable("cpf") String cpf) {
        Person person = personService.findByCpf(cpf);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("/find/email/{email}")
    public ResponseEntity<Person> getPersonByEmail(@PathVariable("email") String email) {
        Person person = personService.findByEmail(email);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        Person newPerson = personService.addPerson(person);
        return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        Person updatePerson = personService.updatePerson(person);
        return new ResponseEntity<>(updatePerson, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable("id") Long id) {
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}