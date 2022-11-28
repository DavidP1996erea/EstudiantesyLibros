import java.util.ArrayList;
import java.util.List;

public class Main implements Runnable {
   public static List<Libro>  libros = new ArrayList<>();
    public boolean leido;
    public boolean leido2;
    @Override
    public void run() {
        try {

            Libro libro1 = libros.get((int)(Math.random()*9));
            Libro libro2 = libros.get((int)(Math.random()*9));

            synchronized (libro1) {
                synchronized (libro2) {
                    while (!leido && libro1.isEnPosesion()  && !leido2 && libro1.isEnPosesion()) {
                        libro1.wait();
                        libro2.wait();
                    }
                    libro1.setEnPosesion(true);
                    System.out.println(Thread.currentThread().getName() + " está leyendo el " + libro1.nombre );
                    Thread.sleep((int) (Math.random() * 5 + 3));
                    System.out.println(Thread.currentThread().getName() + " ha terminado de leer");
                    leido = true;
                    libro1.setEnPosesion(false);
                    libro1.notifyAll();

                    libro2.setEnPosesion(true);
                    System.out.println(Thread.currentThread().getName() + " está leyendo el " + libro2.nombre);
                    Thread.sleep((int) (Math.random() * 5 + 3));
                    System.out.println(Thread.currentThread().getName() + " ha terminado de leer");
                    leido2 = true;
                    libro2.setEnPosesion(false);
                    libro2.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





    public static void main(String[] args) {
        libros.add(new Libro("Libro0"));
        libros.add(new Libro("Libro1"));
        libros.add(new Libro("Libro2"));
        libros.add(new Libro("Libro3"));
        libros.add(new Libro("Libro4"));
        libros.add(new Libro("Libro5"));
        libros.add(new Libro("Libro6"));
        libros.add(new Libro("Libro7"));
        libros.add(new Libro("Libro8"));

        for (int i = 0; i < 4; i++) {
            Main objetos = new Main();

            Thread hilo = new Thread(objetos);
            hilo.setName("Estudiante " + i);
            hilo.start();
        }



    }




}