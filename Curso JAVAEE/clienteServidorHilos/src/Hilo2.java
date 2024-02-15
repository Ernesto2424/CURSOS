
public class Hilo2 extends Thread {

    @Override
    public void run() {

        long inicioT = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            int a = (i * i) / 2;
            System.out.println(Integer.toBinaryString(i));
        }

        long finalT;
        finalT = System.currentTimeMillis();
        long totalT = finalT - inicioT;
        System.out.println("tiempo total del hilo2 = " + totalT);

    }

}
