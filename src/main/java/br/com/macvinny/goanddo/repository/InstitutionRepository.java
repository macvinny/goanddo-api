package br.com.macvinny.goanddo.repository;

import br.com.macvinny.goanddo.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    List<Institution> findByActiveTrue();
    Institution findByCnpj(String cnpj);
    Institution findByEmail(String email);
}
