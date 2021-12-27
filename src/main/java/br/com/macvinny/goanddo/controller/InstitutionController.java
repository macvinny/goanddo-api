package br.com.macvinny.goanddo.controller;

import br.com.macvinny.goanddo.model.Institution;
import br.com.macvinny.goanddo.service.InstitutionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/institution")
public class InstitutionController {
    private final InstitutionService institutionService;

    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Institution>> getAllInstitution() {
        List<Institution> institutions = institutionService.findAllInstitution();
        return new ResponseEntity<>(institutions, HttpStatus.OK);
    }

    @GetMapping("/active")
    public ResponseEntity<List<Institution>> getActiveInstitution() {
        List<Institution> institutions = institutionService.findActiveInstitution();
        return new ResponseEntity<>(institutions, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Institution> getInstitutionById(@PathVariable("id") Long id) {
        Institution institution = institutionService.findInstitutionById(id);
        return new ResponseEntity<>(institution, HttpStatus.OK);
    }

    @GetMapping("/find/cnpj/{cnpj}")
    public ResponseEntity<Institution> getInstitutionByCnpj(@PathVariable("cnpj") String cnpj) {
        Institution institution = institutionService.findByCnpj(cnpj);
        return new ResponseEntity<>(institution, HttpStatus.OK);
    }

    @GetMapping("/find/email/{email}")
    public ResponseEntity<Institution> getInstitutionByEmail(@PathVariable("email") String email) {
        Institution institution = institutionService.findByEmail(email);
        return new ResponseEntity<>(institution, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Institution> addInstitution(@RequestBody Institution institution) {
        Institution newInstitution = institutionService.addInstitution(institution);
        return new ResponseEntity<>(newInstitution, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Institution> updateInstitution(@RequestBody Institution institution) {
        Institution updateInstitution = institutionService.updateInstitution(institution);
        return new ResponseEntity<>(updateInstitution, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteInstitution(@PathVariable("id") Long id) {
        institutionService.deleteInstitution(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}