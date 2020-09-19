package com.eventoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author CarlosMacaneta
 */
@Controller
public class EventoController {
    
    @RequestMapping("/registarevento")
    public String form(){
        return "evento/formEvento";
    }
    
}
