
import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {

        long inicioT = System.currentTimeMillis();
        long totalT = 1;
        Hilo1 h1 = new Hilo1();
        Hilo2 h2 = new Hilo2();
        Hilo3 h3 = new Hilo3();

        h1.setPriority(10);
        h2.setPriority(10);
        h3.setPriority(10);

        h1.start();
        h2.start();
        h3.start();

        while (true) {
            Thread.State estado1 = h1.getState();
            Thread.State estado2 = h2.getState();
            Thread.State estado3 = h3.getState();
            if (!h1.isAlive() && !h2.isAlive() && !h3.isAlive()) {
                long finalT = System.currentTimeMillis();
                totalT = finalT - inicioT;
                System.out.println("Tiempo TOTAL en milisegundos:..................................." + totalT);
                exit(0);
            }
        }

    }

}
