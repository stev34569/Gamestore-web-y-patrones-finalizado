package com.tiendaVideoJuegos.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idCliente;
    String nombre;
    String apellidos;
    String correo;
    String telefono;
    String provincia;
    String ciudad;
    

    @JoinColumn(name = "id_credito", referencedColumnName = "id_credito")
    @ManyToOne
    private Credito credito;

    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono, String provincia, String ciudad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.provincia = provincia;
        this.ciudad = ciudad;
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono,String provincia, String ciudad,  Credito credito) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.credito = credito;
    }
    
   

}
