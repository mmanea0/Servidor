package com.daw2.infoba.model.entity;

import java.util.Date;

public class Habitacion {
    private Integer id;
    private  String numero;
    private Integer capacidad;
    private Boolean fumador;
    private String descripcion;
    private Date createdAt;
    private Date modifiedAt;

    public Habitacion(){
    }

    public Habitacion(Integer id, String numero, Integer capacidad, Boolean fumador, String descripcion, Date createdAt, Date modifiedAt) {
        this.id = id;
        this.numero = numero;
        this.capacidad = capacidad;
        this.fumador = fumador;
        this.descripcion = descripcion;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Boolean getFumador() {
        return fumador;
    }

    public void setFumador(Boolean fumador) {
        this.fumador = fumador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "id=" + id +
                ", numero=" + numero +
                ", capacidad='" + capacidad + '\'' +
                ", fumador=" + fumador +
                ", descripcion='" + descripcion + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }

}
