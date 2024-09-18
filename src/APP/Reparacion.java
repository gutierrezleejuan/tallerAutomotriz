/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package APP;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Reparacion implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private Vehiculo vehiculo;
    private List<Repuesto> listaRepuestosUtilizados;
    private String estado;

    public Reparacion(int id, Vehiculo vehiculo) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.listaRepuestosUtilizados = new ArrayList<>();
        this.estado = "pendiente";
    }

    public int getId() {
        return id;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public List<Repuesto> getListaRepuestosUtilizados() {
        return listaRepuestosUtilizados;
    }

    public String getEstado() {
        return estado;
    }

    public void agregarRepuesto(Repuesto repuesto) throws Exception {
        repuesto.reducirCantidad(1);
        listaRepuestosUtilizados.add(repuesto);
    }

    public void completarReparacion() {
        this.estado = "completa";
    }
}


