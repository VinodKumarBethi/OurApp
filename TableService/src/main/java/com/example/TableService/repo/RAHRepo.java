package com.example.TableService.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TableService.model.TableRAH;

@Repository
public interface RAHRepo extends JpaRepository<TableRAH,String> {
    public List<TableRAH> findAllByRetId(String retId);
    public List<TableRAH> findAllByCustId(String custId);
}
