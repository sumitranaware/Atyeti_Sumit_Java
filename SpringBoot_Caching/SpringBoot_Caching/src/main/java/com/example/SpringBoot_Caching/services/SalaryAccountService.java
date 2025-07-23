package com.example.SpringBoot_Caching.services;


import com.example.SpringBoot_Caching.entities.Employee;
import com.example.SpringBoot_Caching.entities.SalaryAccount;

public interface SalaryAccountService {
    void createAccount(Employee employee);

    SalaryAccount incrementBalance(Long accountId);
}
