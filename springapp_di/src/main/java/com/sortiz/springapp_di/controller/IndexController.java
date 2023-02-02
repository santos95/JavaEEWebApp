package com.sortiz.springapp_di.controller;

import com.sortiz.springapp_di.controller.service.ExampleService;
import com.sortiz.springapp_di.controller.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    //inyeccion de dependencia para reducir el acoplamiento
    //obtenemos un objeto - bean - singleton - inyecta la instancia del tipo ExampleService
    //private ExampleService service = new ExampleService();
    //pero sigue acoplado - requiere usar interfaces
    //ahora mas abstracto mediante la interfaz evitando objetos concretos
    //reduciendo asi el acoplamiento
   @Autowired
    private IService service;

    @GetMapping({"/index","", "/"})
    public String index(Model model){
        model.addAttribute("title", "Dependency Injection with Spring: ");
        model.addAttribute("result", service.procesar());
        return "index";
    }
}
