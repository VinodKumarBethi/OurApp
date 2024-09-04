package com.example.retailer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.retailer.model.Location;

@Repository
public interface LocationRepo extends JpaRepository<Location,String>{


}
