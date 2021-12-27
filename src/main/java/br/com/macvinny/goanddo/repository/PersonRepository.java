package br.com.macvinny.goanddo.repository;

import br.com.macvinny.goanddo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByActiveTrue();
    Person findByCpf(String cpf);
    Person findByEmail(String email);
}
