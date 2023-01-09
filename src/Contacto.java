public class Contacto {
    private String nombre;
    private int numero;

    public Contacto(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public Contacto(String nombre){
        this.nombre = nombre;
        this.numero = 0;
    }

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

    public String toString(){
        return "Nombre: "+nombre+"\nNumero: "+numero;
    }

    public boolean existe(Contacto c){//SI EL CONTACTO EXISTE NOS DEVUELVE VERDADERO Y SI NO DEVOLVERA FALSO
        if(this.nombre.equalsIgnoreCase(c.getNombre())){//COMPARA EL OBJETO DE CONTACTO IGNORANDO SI LE METEMOS MAYUS O MINUS
            return true;
        }
        return false;//DESPUES HABRA QUE UTILIZAR ESTE FALSE EN EL MAIN
    }
}
