
    
    public class Hilo3 extends Thread {

    @Override
    public void run() {

        long inicioT = System.currentTimeMillis();

        for (int i = 0; i < 80; i++) {
            System.out.println("nombre" + i );
        }

        long finalT;
        finalT = System.currentTimeMillis();
        long totalT = finalT - inicioT;
        System.out.println("tiempo total del hilo2 = " + totalT);

    }

}
    

