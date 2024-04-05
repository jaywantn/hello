package com.myjava.hello.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    String createCompany(Company company);
    Company getCompanyById(Long id);
    boolean deletCompanyById(Long id);
    boolean updateCompany(Long id, Company company);
}
