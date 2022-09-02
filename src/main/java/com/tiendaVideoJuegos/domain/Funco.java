/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tiendaVideoJuegos.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "funco")
public class Funco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFunco;

    String nombre;
    String detalle;
    int precio;

    public Funco() {
    }

    public Funco(String nombre, String detalle, int precio) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.precio = precio;
    }

    

}
