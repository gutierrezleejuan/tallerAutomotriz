/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package APP;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Vehiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String placa;
    private String marca;
    private String modelo;
    private List<Reparacion> listaReparaciones;

    public Vehiculo(String placa, String marca, String modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.listaReparaciones = new ArrayList<>();
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public List<Reparacion> getListaReparaciones() {
        return listaReparaciones;
    }

    public void agregarReparacion(Reparacion reparacion) {
        listaReparaciones.add(reparacion);
    }
}

