package com.tienda.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    String nombre;
    String telefono;
    String apellidos;
    String correo;

    public Cliente() {
    }

    public Cliente(String nombre, String telefono, String apellidos, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.apellidos = apellidos;
        this.correo = correo;
    }
    
    
    
    
}
