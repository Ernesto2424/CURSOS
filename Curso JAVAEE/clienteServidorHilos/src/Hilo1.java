
public class Hilo1 extends Thread {

    @Override
    public void run() {

        long inicioT = System.currentTimeMillis();
        int num = 0;
        int i=0;
        for ( i = 1; i <= 1000; i++) {
            int cont = 0;
            for (num = i; num >= 1; num--) {
                if (i % num == 0) {
                    cont += 1;
                }

                if (cont == 2) {
                    System.out.println("ES primo: " + i);
                }
            }
        }

        long finalT;
        finalT = System.currentTimeMillis();
        long totalT = finalT - inicioT;
        System.out.println("tiempo total del hilo1 = " + totalT);

    }

}
