package com.sortiz.springapp_di.controller.service;

import org.springframework.stereotype.Service;

//diferencia de semantica con @Component
//@Service - lo registra como un bean en el contenedor de spring
//por tanto se puede inyectar con el autowired
@Service
public class ExampleService implements IService{
    public String procesar(){
        return "Procesando ... ";
    }
}
