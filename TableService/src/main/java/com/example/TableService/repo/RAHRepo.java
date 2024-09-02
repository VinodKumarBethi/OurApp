package com.example.TableService.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.TableService.model.TableRAH;



@Repository
public interface RAHRepo extends JpaRepository<TableRAH,String> {

    @Modifying
    @Query("update TableRAH rah set rah.serviceOngoing=:service where rah.requestId=:reqId ")
     public int updateOngoingStatus(@Param("reqId") String requestId,@Param("service") String newStatus);

     public int deleteByRequestId(String id);

     public TableRAH findByRequestId(String id);

     public List<TableRAH>  findByRetIdAndIsAccepted(String retailerId,boolean isAccepted);

     public  TableRAH findByRetId(String id);



}
