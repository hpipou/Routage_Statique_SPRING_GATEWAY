package fr.apirest.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

    @GetMapping("/")
    public String getServer(){
        return "HELLO FROM SERVER 1";
    }

}
