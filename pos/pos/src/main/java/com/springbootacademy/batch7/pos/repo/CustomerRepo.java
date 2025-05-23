package com.springbootacademy.batch7.pos.repo;

import com.springbootacademy.batch7.pos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer>{
    @Query("SELECT c FROM Customer c WHERE c.active_status = ?1")
    List<Customer> findAllByActiveEquals(boolean active);

}


