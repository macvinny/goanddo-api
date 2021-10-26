package br.com.macvinny.goanddo.service;

import br.com.macvinny.goanddo.exception.NotFoundException;
import br.com.macvinny.goanddo.model.Institution;
import br.com.macvinny.goanddo.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InstitutionService {
    private final InstitutionRepository institutionRepository;

    @Autowired
    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public Institution addInstitution(Institution institution) {
        return institutionRepository.save(institution);
    }

    public Institution findInstitutionById(Long id) {
        return institutionRepository.findById(id)
                .orElseThrow(
                        ()-> new NotFoundException("Institution by id " + id + " was not found!")
                );
    }

    public List<Institution> findAllInstitution() {
        return institutionRepository.findAll();
    }

    public List<Institution> findActiveInstitution() {
        return institutionRepository.findByActiveTrue();
    }

    public Institution updateInstitution(Institution institution) {
        return institutionRepository.save(institution);
    }

    public void deleteInstitution(Long id) {
        institutionRepository.deleteById(id);
    }
}
