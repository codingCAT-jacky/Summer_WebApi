package com.example.demo.controller;

import com.example.demo.crawler.KeelungSightsCrawler;
import com.example.demo.Sight.Sight;
import com.example.demo.repository.SightRepository;
import com.example.demo.service.SightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class controller {
    @Autowired
    private SightService sightService;

    @GetMapping ("Search")
    public ResponseEntity<Sight[]> search(@RequestParam( value="keyword") String zone)
    {

//        KeelungSightsCrawler crawler = new KeelungSightsCrawler();
//        Sight [] sights = crawler.getItems(zone);
        Sight[] sights = sightService.getSight(zone);
        if(sights==null)
        {
            return ResponseEntity.notFound().build();
        }
        else
        {
            return ResponseEntity.ok().body(sights);

        }
    }
}
