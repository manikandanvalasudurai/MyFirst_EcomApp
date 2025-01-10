package com.scaler.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say")
public class sampleController {
    @GetMapping("/hello/{name}/{times}")
    public String sayHello(@PathVariable("name") String name,@PathVariable("times") int times) {
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < times; i++) {
            output.append("Hello ").append(name).append("..!").append("\n");
            //Hello and Hey all things works since Spring Dev tools provides Dependency injection
        }
        return output.toString();
    }
    @GetMapping("/bye")
    public String sayBye(){
        return "Bye World!";
    }
}
