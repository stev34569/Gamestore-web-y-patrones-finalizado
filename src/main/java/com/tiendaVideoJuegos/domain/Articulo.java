/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tiendaVideoJuegos.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author jorg1_x2s2y36
 */
@Data
@Entity
@Table(name="articulo")
public class Articulo implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_articulo")
    private Long idArticulo;//hibernet lo transforma en id_credito
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private boolean activo;

    public Articulo() {
    }

    public Articulo( String descripcion, String detalle, double precio, int existencias, boolean activo) {
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
    }
    
    
}