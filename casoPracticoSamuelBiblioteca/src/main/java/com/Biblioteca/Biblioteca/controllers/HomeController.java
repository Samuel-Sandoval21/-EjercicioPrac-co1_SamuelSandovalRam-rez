/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Biblioteca.Biblioteca.controllers;

import com.Biblioteca.Biblioteca.domain.Libro;
import com.Biblioteca.Biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class HomeController {
    
    @Autowired
    private LibroService servicioLibro;
    
    @GetMapping("/")
    public String paginaInicio(Model modelo) {
        List<Libro> librosRecientes = servicioLibro.obtenerDisponibles();
        if (!librosRecientes.isEmpty()) {
            modelo.addAttribute("libroDestacado", librosRecientes.get(0));
        }
        modelo.addAttribute("librosRecientes", librosRecientes);
        return "index";
    }
}
