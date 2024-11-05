package com.example.TableService.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TableService.model.CustomerServices;

@Repository
public interface CustomerServicesRepo extends JpaRepository<CustomerServices,String> {

    public List<CustomerServices>  getAllCustomerServicesByCustomerId(String custId);

    
}
