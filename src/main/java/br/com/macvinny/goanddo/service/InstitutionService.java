package br.com.macvinny.goanddo.service;

import br.com.macvinny.goanddo.exception.NotFoundException;
import br.com.macvinny.goanddo.model.Institution;
import br.com.macvinny.goanddo.repo.InstitutionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class InstitutionService {
    private final InstitutionRepo institutionRepo;

    @Autowired
    public InstitutionService(InstitutionRepo institutionRepo) {
        this.institutionRepo = institutionRepo;
    }

    public Institution addInstitution(Institution institution) {
        institution.setInstitutionCode(UUID.randomUUID().toString());
        return institutionRepo.save(institution);
    }

    public Institution findInstitutionById(Long id) {
        return institutionRepo.findById(id)
                .orElseThrow(()-> new NotFoundException("Institution by id " + id + " was not found!"));
    }

    public List<Institution> findAllInstitution() {
        return institutionRepo.findAll();
    }

    public Institution updateInstitution(Institution institution) {
        return institutionRepo.save(institution);
    }

    public void deleteInstitution(Long id) {
        institutionRepo.deleteById(id);
    }
}
