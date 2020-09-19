package com.eventoapp.controller;

import com.eventoapp.models.Evento;
import com.eventoapp.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author CarlosMacaneta
 */
@Controller
public class EventoController {
    
    @Autowired
    private EventoRepository er;
    
    //usaremos o metodo get porque ele ira retornar um formulario
    @RequestMapping(value="/registarevento", method=RequestMethod.GET)
    public String form(){
        return "evento/formEvento";
    }
    
    //aqui usamos o metodo POST porque quando o usuario clicar em salvar ele vai mandar a requisicao para o banco
    @RequestMapping(value="/registarevento", method=RequestMethod.POST)
    public String form(Evento evento){
        
        //criando uma persistencia no banco de dados para salvar o evento
        er.save(evento);     
        
        //redicionando para salvar no banco
        return "redirect:/registarevento";
    }
     
    //este metodo vai retornar a lista de eventos
    @RequestMapping("/eventos")
    public ModelAndView listaEventos(){
        //renderizar eventos
        ModelAndView mv = new ModelAndView("index");
        
        //fazendo uma busca no banco de dados
        //usaremos Iterable porque sera uma lista
        
        Iterable<Evento> eventos = er.findAll();
        
        //passar a lista de eventos na view
        mv.addObject("eventos", eventos);
        
        return mv;
    }
}
