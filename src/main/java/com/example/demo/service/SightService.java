package com.example.demo.service;

import com.example.demo.Sight.Sight;
import com.example.demo.repository.SightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class SightService {
    @Autowired
    private SightRepository repository;

    public  Sight[] getSight(String zone)
    {
        return repository.findByZoneLike(zone);
    }

}
