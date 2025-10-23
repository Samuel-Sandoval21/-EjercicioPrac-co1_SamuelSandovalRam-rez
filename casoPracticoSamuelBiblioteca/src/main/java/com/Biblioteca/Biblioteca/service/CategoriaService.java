/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Biblioteca.Biblioteca.service;

import com.Biblioteca.Biblioteca.domain.Categoria;
import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> obtenerTodas();
    Optional<Categoria> obtenerPorId(Long id);
    Categoria guardar(Categoria categoria);
    void eliminar(Long id);
}
