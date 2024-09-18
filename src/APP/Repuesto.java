/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package APP;
import java.io.Serializable;

public class Repuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private int cantidadDisponible;
    private double precio;

    public Repuesto(int id, String nombre, int cantidadDisponible, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void reducirCantidad(int cantidad) throws Exception {
        if (cantidad > cantidadDisponible) {
            throw new Exception("Repuesto fuera de stock");
        }
        this.cantidadDisponible -= cantidad;
    }

    public double getPrecio() {
        return precio;
    }
}

