package org.una.proyecto_Municipal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.una.proyecto_Municipal.services.IDataInitializerService;

@Component
public class DataInitializerController implements ApplicationRunner {

    //@Autowired
     //private IDataInitializerService dataInitializerService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //dataInitializerService.initDevelopData();
    }
}