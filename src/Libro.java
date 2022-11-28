public class Libro {
    public boolean enPosesion = false;



    public String nombre;


public Libro(String nombre){
    this.nombre=nombre;

}
    public boolean isEnPosesion() {
        return enPosesion;
    }

    public void setEnPosesion(boolean enPosesion) {
        this.enPosesion = enPosesion;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
