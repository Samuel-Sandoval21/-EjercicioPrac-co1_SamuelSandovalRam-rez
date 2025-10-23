/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Biblioteca.Biblioteca.service;
import com.Biblioteca.Biblioteca.domain.Queja;
import java.util.List;

public interface QuejaService {
    List<Queja> obtenerTodas();
    Queja guardar(Queja queja);
}
