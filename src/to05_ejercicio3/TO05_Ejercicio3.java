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
public class TO05_Ejercicio3 {

    public static void main(String[] args) {

        Tienda tiendaLoli = new Tienda();

        int entrada = 0;

        do {
            ES.msgln("---------------------------");
            ES.msgln("-Bienvenido a Tiendas Loli-");
            ES.msgln("---------------------------");
            ES.msgln("Selecccione entre las siguientes opciones: \n 1. Alquilar \n 2. Devolver \n 3. Reparar \n 4. Entregar \n 5. Comprar \n 6. Vender patinete \n 7. Ver el estado \n 8. Estadisticas \n 9. Salir");

            entrada = ES.leeEntero("Por favor introduzca la opcion deseada: ", 0, 9);
            if (entrada == 1) {
                int numDias = ES.leeEntero("Por favor, introduzca numero de dias de duracion del alquiler", 0);
                double precioAlquiler = tiendaLoli.CalculaPrecioAlquiler(numDias);
                try {
                    tiendaLoli.Alquilar(precioAlquiler);
                    ES.msgln("El precio del alquiler asciende a: " + precioAlquiler);

                } catch (Exception e) {
                    ES.msgln(e.getMessage());
                }
            }

            if (entrada == 2) {
                int codigo = ES.leeEntero("Por favor, introduzca su codigo de patinete: ");
                try {
                    tiendaLoli.Devolver(codigo);
                } catch (Exception e) {
                    ES.msgln(e.getMessage());
                }

            }

            if (entrada == 3) {
                int codigo = ES.leeEntero("Por favor, introduzca su codigo de patinete: ");
                double precioReparacion = ES.leeEntero("Por favor, inserte el precio de la reparacion: ");
                //String descripcionReparacion = ES.leeCadena("Por favor, inserte la descripcion de la reparacion: ");
                try {
                    tiendaLoli.Reparar(codigo, precioReparacion);

                } catch (Exception e) {
                    ES.msgln(e.getMessage());
                }
            }

            if (entrada == 4) {
                int codigo = ES.leeEntero("Por favor, introduzca su codigo de patinete: ");
                try {
                    tiendaLoli.Entregar(codigo);

                } catch (Exception e) {
                    ES.msgln(e.getMessage());
                }
            }

            if (entrada == 5) {
                try {
                    tiendaLoli.Comprar();

                } catch (Exception e) {
                    ES.msgln(e.getMessage());
                }
            }

            if (entrada == 6) {
                try {
                    tiendaLoli.Vender();
                } catch (Exception e) {
                    ES.msgln(e.getMessage());
                }
            }

            if (entrada == 7) {
                ES.msgln(tiendaLoli.EstadoPatinetes());
            }

            if (entrada == 8) {
                ES.msgln(tiendaLoli.Estadisticas());
            }

        } while (entrada != 9);

        ES.msgln("---------------------------");
        ES.msgln("---Gracias por su visita---");
        ES.msgln("---------------------------");
        System.exit(0);

    }

}
