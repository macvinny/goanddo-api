package br.com.macvinny.goanddo.service;

import br.com.macvinny.goanddo.exception.NotFoundException;
import br.com.macvinny.goanddo.model.Person;
import br.com.macvinny.goanddo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public Person findPersonById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(
                        ()-> new NotFoundException("Person by id " + id + " was not found!")
                );
    }

    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    public List<Person> findActivePersons() {
        return personRepository.findByActiveTrue();
    }

    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
