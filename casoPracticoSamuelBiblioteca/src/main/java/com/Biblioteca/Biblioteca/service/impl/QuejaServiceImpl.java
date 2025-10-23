/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Biblioteca.Biblioteca.service.impl;

import com.Biblioteca.Biblioteca.domain.Queja;
import com.Biblioteca.Biblioteca.repository.QuejaRepository;
import com.Biblioteca.Biblioteca.service.QuejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuejaServiceImpl implements QuejaService {
    
    @Autowired
    private QuejaRepository quejaRepositorio;
    
    @Override
    public List<Queja> obtenerTodas() {
        return quejaRepositorio.findAll();
    }
    
    @Override
    public Queja guardar(Queja queja) {
        return quejaRepositorio.save(queja);
    }
}
