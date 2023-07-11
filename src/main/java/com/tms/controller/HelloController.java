package com.tms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller         //делает класс контроллером
@RequestMapping(value = "/main-path")   //(такие ставятся обычно над классом) будет перед всеми путями методов
public class HelloController {

//    @GetMapping
//    @PostMapping
//    @PutMapping
//    @DeleteMapping

//    @GetMapping("/hello/{number}")  /** для @PathVariable*/
    @GetMapping("/hello")  /** для @RequestParam*/
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)       //тоже самое что и прошлый (прошлый лучше)
    //public String getHelloPage(@PathVariable int number) {      /** как getParametr*/
    public String getHelloPage(@RequestParam("number") int number) {      /** как getParametr*/
        System.out.println(number);
        //logic(Service -> Repository)
        return "HelloMVC";      //  /main-path/hello
    }


}
