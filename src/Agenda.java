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
        boolean encontrado = false;
        for (int i = 0; i < contactosAgenda.length; i++) {
            if(contactosAgenda[i] != null && contactosAgenda[i].getNombre().equals(c.getNombre())){
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
/*
    public void mostrarAgenda() {//UTILIZAMOS EL METODO BURBUJA
        //EN ESTE METODO RECORREMOS EL ARRAY CON UN FOR Y CADA VEZ QUE SE HAGA UN INTERCAMBIO DE VALORES EN LAS VARIABLES SUBIRA NUESTRO CONTADOR
        //SE RECORRERA EL ARRAY HASTA EL QUE EL CONTADOR SEA IGUAL A 0, LO QUE QUERRA DECIR QUE EL ARRAY YA ESTA ORDENADO
        //DEBEMOS REINICIAR EL CONTADORDEINTERCAMBIOS CADA VEZ QUE SE RECORRE EL ARRAY.

        //METODO COMPARETOIGNORECASE
        //-Si la cadena argumento es igual a esta cadena, devuelve un valor de 0
        //-Si esta cadena es menor que el parametro de cadena, devuelve un valor iferior a cero
        //-Si esta cadena es mayor que el parametro de cadena, se devuelve un valor mayor que 0(esta es la que usamos aqui abajo)


        int contadorIntercambios = 0;
        boolean ordenado = false;

        while (!ordenado){
            for (int i = 0; i < contactosAgenda.length-1; i++) {
                if(contactosAgenda[i].getNombre().compareToIgnoreCase(contactosAgenda[i+1].getNombre()) > 0){
                    String aux = contactosAgenda[i].getNombre();
                    contactosAgenda[i] = contactosAgenda[i+1];
                    aux = contactosAgenda[i].getNombre();
                    //CUANDO EL CONTADOR
                    contadorIntercambios++;
                }

                if (contadorIntercambios == 0){
                    ordenado = true;
                }
                contadorIntercambios = 0;
            }
        }

        //---------------------------------------------------------------------------------------------------------
        /*
        BUENAS JAVIER TAL Y COMO HE PLANTEADO EL EJERCICIO ESTE METODO PARA ORDENAR LOS CONTACTOS ALFABETICAMENTE
        NO ME FUNCIONA, QUERIA SABER SI HAY ALGUNA MANERA DE PODER ORDENARLOS CON ESTA FORMA DE PLANTEAR EL EJERCICIO

         for (int i = 0; i < contactosAgenda.length; i++) {
            if(contactosAgenda[i] != null){
                System.out.println(contactosAgenda[i]);
            }
        }

        */
        public void mostrarAgenda() {

            for (int i = 0; i < contactosAgenda.length; i++) {

                if(contactosAgenda[i] != null) {
                    System.out.println(contactosAgenda[i].toString());
                }

            }
            /*
            Contacto aux;
             for (int i = 0; i < contactosAgenda.length-1; i++) {
                for (int j = 0; j < contactosAgenda.length-1; j++) {
                    if(contactosAgenda[j].getNombre().compareTo(contactosAgenda[j+1].getNombre())>0){
                        aux = contactosAgenda[j];
                        contactosAgenda[j] = contactosAgenda[j+1];
                        contactosAgenda[j+1] = aux;

                    }
                }
            }
             */



        }






    }

