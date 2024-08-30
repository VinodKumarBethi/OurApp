package com.location.location.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.location.location.model.Location;

@Repository
public interface LocationRepo extends JpaRepository<Location,String>{


}
