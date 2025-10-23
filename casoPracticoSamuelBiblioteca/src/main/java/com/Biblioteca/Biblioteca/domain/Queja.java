/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Biblioteca.Biblioteca.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "queja")
public class Queja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre_cliente", length = 150)
    private String nombreCliente;
    
    @Column(length = 200)
    private String email;
    
    @Column(length = 30)
    private String telefono;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoQueja tipo = TipoQueja.CONSULTA;
    
    @Column(length = 200)
    private String asunto;
    
    @NotBlank(message = "El mensaje es obligatorio")
    @Column(columnDefinition = "TEXT", nullable = false)
    private String mensaje;
    
    @Column(nullable = false)
    private Boolean tratado = false;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    public enum TipoQueja {
        QUEJA, SUGERENCIA, CONSULTA
    }
    
    public Queja() {
        this.createdAt = LocalDateTime.now();
    }
    
    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public TipoQueja getTipo() { return tipo; }
    public void setTipo(TipoQueja tipo) { this.tipo = tipo; }
    
    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }
    
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    
    public Boolean getTratado() { return tratado; }
    public void setTratado(Boolean tratado) { this.tratado = tratado; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}