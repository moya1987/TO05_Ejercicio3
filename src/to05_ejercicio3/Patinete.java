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
public class Patinete {

    public static final int PRECIOVENTA = 500;
    public static final int PRECIOCOMPRA = 350;
    public static final int ALQUILERDIARIO = 10;
    public static final int ALQUILERSEMANAL = 50;
    
    

    private final int codigo;

    enum Estado {
        DISPONIBLE, ALQUILADO, ENREPARACION
    };
    
    private Estado estado;
    

    public Patinete(int codigo) {
        this.codigo = codigo;
        estado = Estado.DISPONIBLE;
    }

    public int getCodigo() {
        return codigo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


}
