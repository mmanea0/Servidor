package com.daw2.infoba.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Articulo implements Serializable {
    private Integer id;
    private String ref;
    private String descripcion;
    private double precio;
    private Proveedor proveedor;
    private Date createdAt;
    private Date modifiedAt;

    public Articulo() {
    }

    public Articulo(Integer id, String ref, String descripcion, double precio, Proveedor proveedor, Date createdAt, Date modifiedAt) {
        this.id = id;
        this.ref = ref;
        this.descripcion = descripcion;
        this.precio = precio;
        this.proveedor = proveedor;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
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
        return "Articulo{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", proveedor=" + proveedor +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
