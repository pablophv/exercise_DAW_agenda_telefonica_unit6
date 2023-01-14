import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Agenda {
    //LA CLASE AGENDA ESTARA FORMADA POR UN CONJUNTO DE CONTACTOS
    private Contacto[] contactosAgenda;

    public Agenda() {
        contactosAgenda = new Contacto[10];
    }

    public Agenda(int numeroContactos) {
        contactosAgenda = new Contacto[numeroContactos];
    }

    public void anadirContacto(Contacto c) {
        boolean encontrado = false;

        if (existeContacto(c)) {//SI EL CONTACTO EXISTE........
            System.out.println("El contacto ya existe");
        } else if (agendaLlena()) {//SI AGENDA LLENA NOS RETORNA VERDADERO
            System.out.println("La agenda esta llena...");
        } else {
            //SI NO EXISTE COMPROBAMOS QUE HAY ESPACIOS CON NULL, Y SI HAY AÑADIMOS EL CONTACTO
            for (int i = 0; i < contactosAgenda.length && !encontrado; i++) {//SI ENCONTRADO ES DIFERENTE A FALSE PARAMOS DE BUSCAR
                if (contactosAgenda[i] == null) {
                    contactosAgenda[i] = c;
                    encontrado = true;
                }
                //LA VARIABLE ENCONTRADA LA USAMOS PARA DARLE INFORMACION AL USUARIO
                if (encontrado) {
                    System.out.println("Se ha añadido el contacto");
                }
            }
        }
    }

    public boolean existeContacto(Contacto c) {//METODO QUE COMPRUEBA SI EL CONTACTO QUE LE PASAMOS EXISTE
        for (int i = 0; i < contactosAgenda.length; i++) {//NOS DEVUELVE TRUE O FALSE
            if (contactosAgenda[i] != null && contactosAgenda[i].equals(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean agendaLlena() {
        for (int i = 0; i < contactosAgenda.length; i++) {
            if (contactosAgenda[i] == null) {
                return false;
            }
        }
        return true;
    }

    public void eliminarContacto(Contacto c) {
        boolean encontrado = false;
        for (int i = 0; i < contactosAgenda.length; i++) {
            //IMPORTANTE QUE EN ESTE CONDICIONAL TAMBIEN TENGAMOS EL contactosAgenda[i] != null
            if (contactosAgenda[i] != null && contactosAgenda[i].getNombre().equals(c.getNombre())) {
                contactosAgenda[i] = null;
                encontrado = true;
                System.out.println("El contacto ha sido eliminado");
            }
        }
        if(!encontrado){
            System.out.println("No se ha encontrado el contacto que busca...");
        }
    }

    public void buscarContacto(Contacto c) {
        // BUSCAR CONTACTO ESTA BIEN IMPLEMENTADO SI QUIERES QUE FUNCIONE COMO EN MI SOLUCION SIMPLEMENTE
        // SUSTITUYE EL EQUALS POR STARTSWITH, EN CASO DE TU IMPLEMENTACION EL NOMBRE A BUSCAR DEBE SER
        // EXACTAMENTE IGUAL

        boolean encontrado = false;
        for (int i = 0; i < contactosAgenda.length; i++) {
            if(contactosAgenda[i] != null && contactosAgenda[i].getNombre().startsWith(c.getNombre())){
                encontrado = true;
                System.out.println(contactosAgenda[i]);
            }
        }
        if(!encontrado){
            System.out.println("El contacto no existe");
        }
    }

    public int espacioEnAgenda(Contacto... contactos) {
        int contadorEspacioAgenda = 0;
        for (int i = 0; i < contactosAgenda.length; i++) {
            if (contactosAgenda[i] == null) {
                contadorEspacioAgenda++;
            }
        }
        return contadorEspacioAgenda;
    }

    //METODO COMPARETO
    //-Si la cadena argumento es igual a esta cadena, devuelve un valor de 0
    //-Si esta cadena es menor que el parametro de cadena, devuelve un valor iferior a cero
    //-Si esta cadena es mayor que el parametro de cadena, se devuelve un valor mayor que 0(esta es la que usamos aqui abajo)
    public void mostrarAgenda() {
        int numelementos=0;
        for (int i = 0; i < contactosAgenda.length; i++) {
            if(contactosAgenda[i] != null){
                numelementos++;
            }
        }

        Contacto[] aux;
        aux=Arrays.copyOf(contactosAgenda,numelementos);
        Arrays.sort(aux);

        for (int i = 0; i < aux.length; i++) {
            System.out.println(aux[i]);
            }
    }
    // PARA ORDENAR SEGUN UN ALGORITMO DE ORDENACION DE LOS QUE HEMOS VISTO DEBERIAMOS POR EJEMPLO
    // SACAR LOS NOMBRES DE LA AGENDA EN UN ARRAY DE STRINGS, ORDENAR POR EJEMPLO CON ARRAYS.SORT
    // Y VOLVER A COLOCAR LOS OBJETOS EN UN ARRAY DE OBJETOS SEGUN LOS NOMBRES YA ORDENADOS.
    //COMO ESTO ES MUY INEFICIENTE TE RECOMIENDO IMPLEMENTAR LA INTERFAZ COMPARABLE POR LA CLASE CONTACTO
    // Y ORDENAR CON SORT.
    // EL PROBLEMA ES QUE LE DAS AL ARRAY UN TAMAÑO FIJO Y AL UTILIZAR EL METODO SORT SE ENCUENTRA CON
    // POSICIONES QUE APUNTAN A NULL Y SOLO FUNCIONA CUANDO EL ARRAY TIENE TODAS SUS POSICIONES COMPLETAS
    // 5 REGISTROS
    // PARA EVITAR ESO DEBES HACER CRECER EL ARRAY CADA VEZ QUE AÑADES UN NUEVO CONTACTO Y INICIALIZARLO CON
    // 0 ELEMENTOS O BIEN LA SOLUCION QUE HE IMPLEMENTADO ABAJO CON UN ARRAY AUXILIAR
    // AUNQUE ES MENOS EFICIENTE
}