package com.example.demo.repository;

import com.example.demo.Sight.Sight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface SightRepository  extends MongoRepository<Sight, String> {
    public Sight[] findByZoneLike(String zone);

}