package com.example.demo.repository;

import com.example.demo.entities.Convertdata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvertRepository extends JpaRepository<Convertdata, Integer> {
    @Query(value = "select p.outputdata from Convertdata p where p.inputdata = ?1", nativeQuery = true)
    String findAllByName(String text);
}
