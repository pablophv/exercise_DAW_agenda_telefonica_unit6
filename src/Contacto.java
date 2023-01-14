public class Contacto implements Comparable<Contacto>{
    private String nombre;
    private int numero;

    public Contacto(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public Contacto(String nombre) {
        this.nombre = nombre;
        this.numero = 0;
    }
//------ Codigo agregado  ------
    public int compareTo(Contacto c){
        return this.nombre.compareTo(c.getNombre());
    }

//-----------------------------------------------
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String toString() {
        return nombre + " - " + numero;
    }

    public boolean existe(Contacto c) {//SI EL CONTACTO EXISTE NOS DEVUELVE VERDADERO Y SI NO DEVOLVERA FALSO
        if (this.nombre.equalsIgnoreCase(c.getNombre())) {//COMPARA EL OBJETO DE CONTACTO IGNORANDO SI LE METEMOS MAYUS O MINUS
            return true;
        }
        return false;//DESPUES HABRA QUE UTILIZAR ESTE FALSE EN EL MAIN
    }
}