/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Biblioteca.Biblioteca.service.impl;
import com.Biblioteca.Biblioteca.domain.Libro;
import com.Biblioteca.Biblioteca.repository.LibroRepository;
import com.Biblioteca.Biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LibroServiceImpl implements LibroService {
    
    private final LibroRepository libroRepositorio;
    
    @Autowired
    public LibroServiceImpl(LibroRepository libroRepositorio) {
        this.libroRepositorio = libroRepositorio;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Libro> obtenerTodos() {
        return libroRepositorio.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Libro> obtenerDisponibles() {
        return libroRepositorio.findByDisponibleTrue();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Libro> obtenerPorId(Long id) {
        return libroRepositorio.findById(id);
    }
    
    @Override
    public Libro guardar(Libro libro) {
        return libroRepositorio.save(libro);
    }
    
    @Override
    public void eliminar(Long id) {
        libroRepositorio.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Libro> buscarPorTitulo(String titulo) {
        return libroRepositorio.findByTituloContainingIgnoreCase(titulo);
    }
}
