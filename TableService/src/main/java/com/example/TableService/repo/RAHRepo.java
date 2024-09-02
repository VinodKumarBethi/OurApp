package com.example.TableService.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.TableService.model.ServiceStatus;
import com.example.TableService.model.TableRAH;

import feign.Param;

@Repository
public interface RAHRepo extends JpaRepository<TableRAH,String> {
    @Modifying
    @Query("select tr from TableRAH tr where tr.retId=:retId and tr.serviceOngoing=0")
    public List<TableRAH> findAllByRetIdAndServiceOngoing(@Param("retId") String retId);
    public List<TableRAH> findAllByCustId(String custId);
}
