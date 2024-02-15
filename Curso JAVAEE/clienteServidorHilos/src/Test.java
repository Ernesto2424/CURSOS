
public class Test {

    public static void main(String[] args) throws InterruptedException {

        Hilo1 hilo1 = new Hilo1();
        Hilo2 hilo2 = new Hilo2();
        Hilo3 hilo3 = new Hilo3();
        
//        hilo3.setPriority(10);
//        hilo2.setPriority(1);
        
        
        hilo3.start();
        
        
        
        
        hilo2.start();
        hilo2.sleep(3000);

    }

}
