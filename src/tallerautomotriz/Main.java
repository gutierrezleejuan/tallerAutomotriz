/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallerautomotriz;

import APP.Reparacion;
import APP.Repuesto;
import APP.Taller;
import APP.Vehiculo;
import javax.swing.JOptionPane;

public class Main implements Runnable {
    private Taller taller;
    private Reparacion reparacion;

    public Main(Taller taller, Reparacion reparacion) {
        this.taller = taller;
        this.reparacion = reparacion;
    }

    @Override
    public void run() {
        try {
            // Simular la reparacion
            for (Repuesto repuesto : reparacion.getListaRepuestosUtilizados()) {
                reparacion.agregarRepuesto(repuesto);
            }
            reparacion.completarReparacion();
            System.out.println("Reparacion " + reparacion.getId() + " completada.");
        } catch (Exception e) {
            System.out.println("Error en la reparacion " + reparacion.getId() + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Taller taller = new Taller();

        // Ingresar repuestos
        int numRepuestos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de repuestos:"));
        for (int i = 0; i < numRepuestos; i++) {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del repuesto:"));
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del repuesto:");
            int cantidadDisponible = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad disponible:"));
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del repuesto:"));
            Repuesto repuesto = new Repuesto(id, nombre, cantidadDisponible, precio);
            taller.agregarRepuesto(repuesto);
        }

        // Ingresar vehiculos
        int numVehiculos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de vehiculos:"));
        for (int i = 0; i < numVehiculos; i++) {
            String placa = JOptionPane.showInputDialog("Ingrese la placa del vehiculo:");
            String marca = JOptionPane.showInputDialog("Ingrese la marca del vehiculo:");
            String modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehiculo:");
            Vehiculo vehiculo = new Vehiculo(placa, marca, modelo);
            taller.registrarVehiculo(vehiculo);

            // Crear reparaciones
            int idReparacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la reparacion:"));
            Reparacion reparacion = new Reparacion(idReparacion, vehiculo);
            int numRepuestosUtilizados = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de repuestos utilizados:"));
            for (int j = 0; j < numRepuestosUtilizados; j++) {
                int idRepuesto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del repuesto utilizado:"));
                for (Repuesto repuesto : taller.listarRepuestos()) {
                    if (repuesto.getId() == idRepuesto) {
                        try {
                            reparacion.agregarRepuesto(repuesto);
                        } catch (Exception e) {
                            System.out.println("Error al agregar repuesto: " + e.getMessage());
                        }
                    }
                }
            }
            taller.asignarReparacion(reparacion);

            // Simular reparaciones concurrentes
            Thread hilo1 = new Thread(new Main(taller, reparacion));
            Thread hilo2 = new Thread(new Main(taller, reparacion));
            Thread hilo3 = new Thread(new Main(taller, reparacion));
            Thread hilo4 = new Thread(new Main(taller, reparacion));

            hilo1.start();
            hilo2.start();
            hilo3.start();
            hilo4.start();
        }

        // Guardar inventario
        taller.guardarInventario("inventario.dat");

        // Cargar inventario
        Taller tallerCargado = Taller.cargarInventario("inventario.dat");
        if (tallerCargado != null) {
            System.out.println("Inventario cargado exitosamente.");
        }
    }
}


