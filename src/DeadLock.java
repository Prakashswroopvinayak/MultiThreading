public class DeadLock {


    public static void main(String[] args) {

        Object obj1 = new Object();

        Object obj2 = new Object();

        Thread thread1 = new Thread(()->{

            synchronized (obj1){
                System.out.println(" Thread1 lock obj1");
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                synchronized (obj2){
                    System.out.println(" obj1 lock obj2");
                }
            }
        });

        Thread thread2 = new Thread(()->{
           synchronized (obj2){
               System.out.println(" Thread 2 lock obj2");
               try {
                   Thread.sleep(100);
               }catch (InterruptedException e){
                   e.printStackTrace();
               }

               synchronized (obj1){
                   System.out.println("obj2 lock obj1");
               }
           }
        });

        thread1.start();
        thread2.start();
    }
}
