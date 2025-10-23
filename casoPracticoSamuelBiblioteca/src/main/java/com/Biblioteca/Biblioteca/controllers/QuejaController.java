/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Biblioteca.Biblioteca.controllers;

import com.Biblioteca.Biblioteca.domain.Queja;
import com.Biblioteca.Biblioteca.service.QuejaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/quejas")
public class QuejaController {
    
    @Autowired
    private QuejaService servicioQueja;
    
    @GetMapping("/formulario")
    public String mostrarFormulario(Model modelo) {
        modelo.addAttribute("queja", new Queja());
        return "quejas/formulario";
    }
    
    @PostMapping("/enviar")
    public String enviarQueja(@Valid @ModelAttribute Queja queja, 
                             BindingResult result) {
        if (result.hasErrors()) {
            return "quejas/formulario";
        }
        servicioQueja.guardar(queja);
        return "redirect:/quejas/exito";
    }
    
    @GetMapping("/exito")
    public String mostrarExito() {
        return "quejas/exito";
    }
}

