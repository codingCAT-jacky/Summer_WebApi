package com.example.demo.service;

import com.example.demo.Sight.Sight;
import com.example.demo.crawler.KeelungSightsCrawler;

import com.example.demo.repository.SightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Initialize implements CommandLineRunner {

    @Autowired
    private SightRepository repository;

    @Override
    public void run(String... args) throws Exception
    {
        if(repository.count()==0)
        {
            //repository.deleteAll();
            // 中山 中正 仁愛 安樂 信義 暖暖
            KeelungSightsCrawler crawler = new KeelungSightsCrawler();
            List<Sight> tmp = crawler.getItems("七堵");
            repository.saveAll(tmp);
            tmp.clear();

            tmp = crawler.getItems("暖暖");
            repository.saveAll(tmp);
            tmp.clear();

            tmp = crawler.getItems("中山");
            repository.saveAll(tmp);
            tmp.clear();

            tmp = crawler.getItems("中正");
            repository.saveAll(tmp);
            tmp.clear();

            tmp = crawler.getItems("仁愛");
            repository.saveAll(tmp);
            tmp.clear();

            tmp = crawler.getItems("安樂");
            repository.saveAll(tmp);
            tmp.clear();

            tmp = crawler.getItems("信義");
            repository.saveAll(tmp);
            tmp.clear();
        }

    }
}
