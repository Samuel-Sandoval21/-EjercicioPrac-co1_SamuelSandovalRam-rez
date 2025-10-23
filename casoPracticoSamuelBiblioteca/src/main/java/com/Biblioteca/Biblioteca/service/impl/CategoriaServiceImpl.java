/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Biblioteca.Biblioteca.service.impl;

import com.Biblioteca.Biblioteca.domain.Categoria;
import com.Biblioteca.Biblioteca.repository.CategoriaRepository;
import com.Biblioteca.Biblioteca.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepositorio;
    
    @Override
    public List<Categoria> obtenerTodas() {
        return categoriaRepositorio.findAll();
    }
    
    @Override
    public Optional<Categoria> obtenerPorId(Long id) {
        return categoriaRepositorio.findById(id);
    }
    
    @Override
    public Categoria guardar(Categoria categoria) {
        return categoriaRepositorio.save(categoria);
    }
    
    @Override
    public void eliminar(Long id) {
        categoriaRepositorio.deleteById(id);
    }
}
