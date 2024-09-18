/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package APP;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Taller implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Repuesto> listaRepuestos;
    private List<Vehiculo> listaVehiculos;
    private List<Reparacion> listaReparaciones;

    public Taller() {
        this.listaRepuestos = new ArrayList<>();
        this.listaVehiculos = new ArrayList<>();
        this.listaReparaciones = new ArrayList<>();
    }

    public void agregarRepuesto(Repuesto repuesto) {
        listaRepuestos.add(repuesto);
    }

    public void registrarVehiculo(Vehiculo vehiculo) {
        listaVehiculos.add(vehiculo);
    }

    public void asignarReparacion(Reparacion reparacion) {
        listaReparaciones.add(reparacion);
        reparacion.getVehiculo().agregarReparacion(reparacion);
    }

    public List<Repuesto> listarRepuestos() {
        return listaRepuestos;
    }

    public void guardarInventario(String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(this);
            System.out.println("Inventario guardado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el inventario: " + e.getMessage());
        }
    }

    public static Taller cargarInventario(String archivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (Taller) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar el inventario: " + e.getMessage());
            return null;
        }
    }
}
