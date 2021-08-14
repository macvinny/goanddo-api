package br.com.macvinny.goanddo.repo;

import br.com.macvinny.goanddo.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionRepo extends JpaRepository<Institution, Long> {}
