package com.myjava.hello.company;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/companies")

public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    };

    @GetMapping
    public ResponseEntity<List <Company>> getAllCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> companyGetById(@PathVariable Long id) {
         Company company= companyService.getCompanyById(id);
        if(company != null){
            return ResponseEntity.ok(company);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> saveCompany(@RequestBody Company company) {
         companyService.createCompany(company);
         return ResponseEntity.ok("Company added succefully");
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        boolean updateCompany = companyService.updateCompany(id, company);
        if(updateCompany){
            return ResponseEntity.ok("Company updated succfully");
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id){
        boolean delete= companyService.deletCompanyById(id);
        if(delete){
            return  ResponseEntity.ok("Deleted succesfully");
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
