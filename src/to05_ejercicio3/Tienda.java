/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to05_ejercicio3;

/**
 *
 * @author adrian
 */
public class Tienda {

    private static final int MAXIMONUMPATINETES = 20;

    private double saldo;

    private int codigoPatinete;
    private double beneficios;

    private double numAlquileres;
    private double numCompras;
    private double numVentas;
    private double numReparaciones;
    private double impAlquileres;
    private double impCompras;
    private double impVentas;
    private double impReparaciones;

    private Patinete[] listaPatinetes;

    public double CalculaPrecioAlquiler(int diasTotales) {
        if (diasTotales % 7 == 0) {
            return Patinete.ALQUILERDIARIO * (diasTotales / 7);
        } else {
            int resto = (diasTotales % 7);
            return Patinete.ALQUILERSEMANAL * (diasTotales / 7) + (resto * 10);
        }
    }

    public void Alquilar(double precioAlquiler) throws Exception {
        if (listaPatinetes == null) {
            throw new Exception("No quedan patinetes para alquilar");
        }

        for (int i = 0; i < listaPatinetes.length; i++) {
            Patinete p = listaPatinetes[i];
            if (p.getEstado().equals(Patinete.Estado.DISPONIBLE)) {
                p.setEstado(Patinete.Estado.ALQUILADO);
                numAlquileres++;
                impAlquileres = impAlquileres + precioAlquiler;
                return;
            }
        }
        throw new Exception("No quedan patinetes para alquilar");
    }

    public void Devolver(int codigo) throws Exception {

        if (existePatinete(codigo) == false) {
            throw new Exception("No se puede devolver porque no existe");
        }
        for (int i = 0; i < listaPatinetes.length; i++) {
            Patinete p = listaPatinetes[i];

            if (p.getCodigo() == codigo) {
                if (p.getEstado().equals(Patinete.Estado.ALQUILADO)) {
                    p.setEstado(Patinete.Estado.DISPONIBLE);
                    return;
                } else {
                    throw new Exception("No se puede devolver porque no está alquilado");
                }
            }
        }
    }

    public void Reparar(int codigo, double precioReparacion) throws Exception {

        if (existePatinete(codigo) == false) {
            throw new Exception("No se puede reparar porque no existe");
        }

        for (int i = 0; i < listaPatinetes.length; i++) {
            Patinete p = listaPatinetes[i];

            if (p.getCodigo() == codigo) {
                if (p.getEstado().equals(Patinete.Estado.ALQUILADO) || p.getEstado().equals(Patinete.Estado.DISPONIBLE)) {
                    p.setEstado(Patinete.Estado.ENREPARACION);
                    numReparaciones++;
                    impReparaciones = impReparaciones + precioReparacion;
                    return;
                } else {
                    throw new Exception("No se puede reparar porque ya esta puesto a reparar");
                }
            }
        }

    }

    public void Entregar(int codigo) throws Exception {
        if (existePatinete(codigo) == false) {
            throw new Exception("No se puede entregar porque no existe");
        }
        for (int i = 0; i < listaPatinetes.length; i++) {
            Patinete p = listaPatinetes[i];

            if (p.getCodigo() == codigo) {
                if (p.getEstado().equals(Patinete.Estado.ENREPARACION)) {
                    p.setEstado(Patinete.Estado.DISPONIBLE);
                    return;
                } else {
                    throw new Exception("No se puede reparar porque no esta puesto a reparar");
                }
            }
        }

    }

    public void Comprar() throws Exception {
        codigoPatinete++;
        Patinete p = new Patinete(codigoPatinete);

        if (listaPatinetes == null) {
            listaPatinetes = new Patinete[1];
            listaPatinetes[0] = p;
        } else {
            if (listaPatinetes.length >= MAXIMONUMPATINETES) {
                throw new Exception("No se puede comprar porque se ha alcanzado el maximo de patinetes en la tienda");
            }

            Patinete newarr[] = new Patinete[listaPatinetes.length + 1];

            for (int i = 0; i < listaPatinetes.length; i++) {
                newarr[i] = listaPatinetes[i];
            }

            newarr[listaPatinetes.length] = p;
            listaPatinetes = newarr;

        }

        numCompras++;
        impCompras = impCompras + p.PRECIOCOMPRA;
    }

    public void Vender() throws Exception {
        if (listaPatinetes.length == 0) {
            throw new Exception("No se puede vender porque no quedan patinetes en stock");
        }

        int numPatinetesNoDisponibles = calcularNumeroPatinetesNoDisponibles();
        int numPatinetesDisponibles = listaPatinetes.length - numPatinetesNoDisponibles;

        if (numPatinetesDisponibles == 0) {
            throw new Exception("No se puede vender porque ahora mismo no hay disponibles");
        }
        Patinete newarr[] = new Patinete[numPatinetesNoDisponibles];
        int j = 0;;
        for (int i = 0; i < listaPatinetes.length; i++) {
            Patinete p = listaPatinetes[i];

            if (!p.getEstado().equals(Patinete.Estado.DISPONIBLE)) {
                newarr[j] = p;
                j++;

            } else {
                numVentas++;
                impVentas = impVentas + p.PRECIOVENTA;
            }

        }

        listaPatinetes = newarr;

    }

    public String EstadoPatinetes() {
        // Comprobar que la lista de patinetes esta rellena
        if (listaPatinetes.length == 0) {
            return "";
        }

        String salida = "";
        for (int i = 0; i < listaPatinetes.length; i++) {
            Patinete p = listaPatinetes[i];
            salida = salida + p.getCodigo() + "=" + p.getEstado() + ",";
        }
        return salida.substring(0, salida.length() - 1);
    }

    public String Estadisticas() {

        String salida = "El numero de alquileres es: " + numAlquileres + "\n";
        salida = salida + "El numero de ventas es: " + numVentas + "\n";
        salida = salida + "El numero total de compras es " + numCompras + "\n";
        salida = salida + "El numero total de reparaciones es " + numReparaciones + "\n";
        salida = salida + "El importe total por alquileres es " + impAlquileres + "\n";
        salida = salida + "El importe total por ventas es " + impVentas + "\n";
        salida = salida + "El importe total por compras asciende a " + impCompras + "\n";
        salida = salida + "El importe total por reparaciones asciende a " + impReparaciones + "\n";

        beneficios = impAlquileres + impVentas + impReparaciones - impCompras;

        salida = salida + "El saldo total es: " + beneficios;

        return salida;

    }

    private boolean existePatinete(int codigo) {
        for (int i = 0; i < listaPatinetes.length; i++) {
            Patinete p = listaPatinetes[i];

            if (p.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    private int calcularNumeroPatinetesNoDisponibles() {
        int numPatinetesDisponibles = 0;
        for (int i = 0; i < listaPatinetes.length; i++) {
            Patinete p = listaPatinetes[i];
            if (!p.getEstado().equals(Patinete.Estado.DISPONIBLE)) {
                numPatinetesDisponibles++;
            }
        }
        return numPatinetesDisponibles;
    }

}
