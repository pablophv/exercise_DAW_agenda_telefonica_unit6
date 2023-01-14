
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        String nombre;
        int numero;
        Agenda agenda = new Agenda(5);
        int opcion;
        //Contacto contacto;
        //Contacto [] contactos;
        // El ARRAY DE OBJETOS DE LA CLASE CONTACTOS YA ESTA DECLARADO COMO ATRIBUTO DEL OBJETO AGENDA
        // NO TIENES QUE DECLARARLO AQUI DE NUEVO
        do {
            System.out.println();
            System.out.println("\t.:MENU:.");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Eliminar contacto");
            System.out.println("3. Buscar un contacto");
            System.out.println("4. Mostrar agenda");
            System.out.println("5. Salir");
            System.out.println("Elija una opcion del menu: ");
            opcion = ent.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Introduzca el nombre del contacto: ");
                    nombre = ent.next();
                    System.out.print("Introduzca el numero de telefono: ");
                    numero = ent.nextInt();
                    Contacto contacto = new Contacto(nombre, numero);
                    //AQUI TE FALTA PONER DE QUE CLASE ES LA VARIABLE "contacto"
                    agenda.anadirContacto(contacto);
                    break;
                case 2:
                    System.out.print("Introduzca el nombre del contacto: ");
                    nombre = ent.next();
                    contacto = new Contacto(nombre);
                    agenda.eliminarContacto(contacto);
                    break;
                case 3:
                    System.out.print("Introduzca el nombre del contacto: ");
                    nombre= ent.next();
                    contacto = new Contacto(nombre);
                    agenda.buscarContacto(contacto);
                    break;
                case 4:
                    agenda.mostrarAgenda();

                case 5:
                    break;
            }
        }while(opcion!=5);
    }
}