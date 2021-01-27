/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to05_ejercicio3;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adrian
 */
public class TiendaTest {
    
    public TiendaTest() {
    }

    /**
     * Test of CalculaPrecioAlquier method, of class Tienda.
     */
    @Test
    public void testCalculaPrecioAlquier() {
        System.out.println("CalculaPrecioAlquier");
        int diasTotales = 3;
        Tienda miTienda = new Tienda();
        double expResult = 30.0;
        double result = miTienda.CalculaPrecioAlquier(diasTotales);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of Alquilar method, of class Tienda.
     */
    @Test
    public void testAlquilar() throws Exception {
        System.out.println("Alquilar");
        double precioAlquiler = 20.0;
        Tienda miTienda = new Tienda();
        miTienda.Alquilar(precioAlquiler);

    }

    /**
     * Test of Devolver method, of class Tienda.
     */
    @Test
    public void testDevolver() throws Exception {
        System.out.println("Devolver");
        int codigo = 0;
        Tienda instance = new Tienda();
        instance.Devolver(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Reparar method, of class Tienda.
     * @throws java.lang.Exception
     */
    @Test
    public void testReparar() throws Exception {
        System.out.println("Reparar");
        int codigo = 15;
        double precioReparacion = 10.0;
        Patinete miPatinete = new Patinete(codigo);
        Tienda miTienda = new Tienda();
        Tienda MiTienda2 = new Tienda().Reparar(codigo, precioReparacion);
        assertEquals(miTienda.Reparar(codigo, precioReparacion), Patinete.Estado.ENREPARACION);
        
    }

    /**
     * Test of Entregar method, of class Tienda.
     */
    @Test
    public void testEntregar() throws Exception {
        System.out.println("Entregar");
        int codigo = 15;
        Tienda miTienda = new Tienda();
        mi.Entregar(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Comprar method, of class Tienda.
     */
    @Test
    public void testComprar() throws Exception {
        System.out.println("Comprar");
        Tienda instance = new Tienda();
        instance.Comprar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Vender method, of class Tienda.
     */
    @Test
    public void testVender() throws Exception {
        System.out.println("Vender");
        Tienda instance = new Tienda();
        instance.Vender();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of EstadoPatinetes method, of class Tienda.
     */
    @Test
    public void testEstadoPatinetes() {
        System.out.println("EstadoPatinetes");
        Tienda instance = new Tienda();
        String expResult = "";
        String result = instance.EstadoPatinetes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Estadisticas method, of class Tienda.
     */
    @Test
    public void testEstadisticas() {
        System.out.println("Estadisticas");
        Tienda instance = new Tienda();
        String expResult = "";
        String result = instance.Estadisticas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existePatinete method, of class Tienda.
     */
    @Test
    public void testExistePatinete() {
        System.out.println("existePatinete");
        int codigo = 0;
        Tienda instance = new Tienda();
        boolean expResult = false;
        boolean result = instance.existePatinete(codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
