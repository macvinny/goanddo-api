package br.com.macvinny.goanddo.service;

import br.com.macvinny.goanddo.exception.UserNotFoundException;
import br.com.macvinny.goanddo.model.Person;
import br.com.macvinny.goanddo.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public Person addPerson(Person person) {
        person.setPersonCode(UUID.randomUUID().toString());
        return personRepo.save(person);
    }

    public Person findPersonById(Long id) {
        return personRepo.findById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id " + id + " was not found!"));
    }

    public List<Person> findAllPersons() {
        return personRepo.findAll();
    }

    public Person updatePerson(Person person) {
        return personRepo.save(person);
    }

    public void deletePerson(Long id) {
        personRepo.deleteById(id);
    }
}
