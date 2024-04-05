package com.myjava.hello.company.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.myjava.hello.company.Company;
import com.myjava.hello.company.CompanyRespository;

import com.myjava.hello.company.CompanyService;
 

@Service
public class CompanyServiceImpl implements CompanyService{

    CompanyRespository companyRespository;

    public CompanyServiceImpl(CompanyRespository companyRespository) {
        this.companyRespository = companyRespository;
    }  

    @Override
    public List<Company> getAllCompanies(){
        return companyRespository.findAll();
    }
    
    @Override
    public String createCompany(@RequestBody Company company){
         companyRespository.save(company);
         return "Company Added succesufully";
    }

    @Override
    public Company getCompanyById(Long id){
        return companyRespository.findById(id).orElse(null);
    }

    @Override
    public boolean deletCompanyById(Long id){
        try{
            companyRespository.deleteById(id);
            return true;

        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean updateCompany(Long id, Company updatedCompany) {
        Optional<Company> companyOptional = companyRespository.findById(id);
            if(companyOptional.isPresent()){
                Company company = companyOptional.get();
                company.setName(updatedCompany.getName());
                company.setAddress(updatedCompany.getAddress());
                company.setLocation(updatedCompany.getLocation());
                company.setPhoneNumber(updatedCompany.getPhoneNumber()); 
                companyRespository.save(company);
                return true;
        } 
        return false;
    }

}
