package com.myjava.hello.company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRespository extends JpaRepository <Company, Long> {
}
