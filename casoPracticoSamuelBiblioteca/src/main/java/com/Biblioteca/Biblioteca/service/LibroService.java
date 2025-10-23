/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Biblioteca.Biblioteca.service;
import com.Biblioteca.Biblioteca.domain.Libro;
import java.util.List;
import java.util.Optional;

public interface LibroService {
    List<Libro> obtenerTodos();
    List<Libro> obtenerDisponibles();
    Optional<Libro> obtenerPorId(Long id);
    Libro guardar(Libro libro);
    void eliminar(Long id);
    List<Libro> buscarPorTitulo(String titulo); // ← Este método debe estar
}
