package com.tienda.controller;

import com.tienda.dao.ClienteDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.tienda.domain.Cliente;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private ClienteDao ClienteDao;

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora utilizamos MVC");

        /* Cliente cliente = new Cliente("Jonathan", "Brenes Blanco", "jbrenesbl@gmail.com", "8820-2655");
        Cliente cliente2 = new Cliente("Juan", "Lopez Rojas", "jbrenesbl@gmail.com", "8820-2655");
        Cliente cliente3 = new Cliente("Pedro", "Lopez Rojas", "jbrenesbl@gmail.com", "8820-2655");
        
        var clientes = Arrays.asList(cliente,cliente2,cliente3);
                
        model.addAttribute("cliente", cliente);
        model.addAttribute("clientes", clientes);*/
        
        var clientes = ClienteDao.findAll();
        model.addAttribute("clientes", clientes);

        return "index";
    }

}
