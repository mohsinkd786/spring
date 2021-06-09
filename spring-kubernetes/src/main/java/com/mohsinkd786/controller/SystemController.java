package com.mohsinkd786.controller;

import com.mohsinkd786.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/home")
@RestController
public class SystemController {

    private SystemService systemService;
    private Logger logger = LoggerFactory.getLogger(SystemController.class);

    @Autowired
    public void setSystemService(SystemService systemService) {
        this.systemService = systemService;
    }

    @GetMapping("/process")
    public ResponseEntity<List<String>> findUUIds(){
        //try{
            return ResponseEntity.ok(systemService.getUUIds());
//        }catch (InterruptedException ex){
//                logger.error(ex.getMessage());
//        }
//        return ResponseEntity.ok(null);
    }
}
