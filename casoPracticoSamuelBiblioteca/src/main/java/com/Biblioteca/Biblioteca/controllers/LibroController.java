/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Biblioteca.Biblioteca.controllers;

import com.Biblioteca.Biblioteca.domain.Libro;
import com.Biblioteca.Biblioteca.service.CategoriaService;
import com.Biblioteca.Biblioteca.service.LibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/libros")
public class LibroController {
    
    @Autowired
    private LibroService servicioLibro;
    
    @Autowired
    private CategoriaService servicioCategoria;
    
    @GetMapping
    public String listarLibros(Model modelo) {
        List<Libro> libros = servicioLibro.obtenerTodos();
        modelo.addAttribute("libros", libros);
        return "libros/lista";
    }
    
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model modelo) {
        modelo.addAttribute("libro", new Libro());
        modelo.addAttribute("categorias", servicioCategoria.obtenerTodas());
        return "libros/formulario";
    }
    
    @PostMapping("/guardar")
    public String guardarLibro(@Valid @ModelAttribute Libro libro, 
                              BindingResult result, 
                              Model modelo) {
        if (result.hasErrors()) {
            modelo.addAttribute("categorias", servicioCategoria.obtenerTodas());
            return "libros/formulario";
        }
        servicioLibro.guardar(libro);
        return "redirect:/libros";
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
        Libro libro = servicioLibro.obtenerPorId(id).orElse(null);
        if (libro == null) {
            return "redirect:/libros";
        }
        modelo.addAttribute("libro", libro);
        modelo.addAttribute("categorias", servicioCategoria.obtenerTodas());
        return "libros/formulario";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable Long id) {
        servicioLibro.eliminar(id);
        return "redirect:/libros";
    }
    
    @GetMapping("/buscar")
    public String buscarLibros(@RequestParam String titulo, Model modelo) {
        List<Libro> libros = servicioLibro.buscarPorTitulo(titulo);
        modelo.addAttribute("libros", libros);
        modelo.addAttribute("terminoBusqueda", titulo);
        return "libros/lista";
    }
}