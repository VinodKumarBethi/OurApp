package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Retailer;

@Repository
public interface RetailerRepo extends JpaRepository<Retailer,Integer> {


    public Optional<Retailer> getByRetailerId(String id);
    public List<Retailer> getByRetailerLocationId(String locId);
    public List<Retailer> getByRetailerName(String retName);
}
