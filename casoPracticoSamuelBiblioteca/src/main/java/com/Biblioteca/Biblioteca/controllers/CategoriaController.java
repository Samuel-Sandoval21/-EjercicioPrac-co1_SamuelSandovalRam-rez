/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Biblioteca.Biblioteca.controllers;

import com.Biblioteca.Biblioteca.domain.Categoria;
import com.Biblioteca.Biblioteca.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    
    @Autowired
    private CategoriaService servicioCategoria;
    
    @GetMapping
    public String listarCategorias(Model modelo) {
        modelo.addAttribute("categorias", servicioCategoria.obtenerTodas());
        return "categorias/lista";
    }
    
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model modelo) {
        modelo.addAttribute("categoria", new Categoria());
        return "categorias/formulario";
    }
    
    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        servicioCategoria.guardar(categoria);
        return "redirect:/categorias";
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
        Categoria categoria = servicioCategoria.obtenerPorId(id).orElse(null);
        if (categoria == null) {
            return "redirect:/categorias";
        }
        modelo.addAttribute("categoria", categoria);
        return "categorias/formulario";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Long id) {
        servicioCategoria.eliminar(id);
        return "redirect:/categorias";
    }
}