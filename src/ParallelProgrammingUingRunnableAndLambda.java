public class ParallelProgrammingUingRunnableAndLambda {
    public static int sum =0;
    public static void main(String[] args) throws InterruptedException {


        int totalSum = 0;

        for (int i= 0;i<=100;i++){
            totalSum +=i;
        }


        Runnable worker1 = ()->{
            for(int i=0;i<50;i++){
                sum+=i;
                System.out.println("Tread1 : "+ i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };




        Thread thread1 = new Thread(worker1);

        //  without creating instance of runable interface we will pass whole body as a parameter of thread constructor
        Thread thread2 = new Thread(()->{
            for(int i= 50; i<=100; i++){
                sum +=i;
                System.out.println("Tread2 : "+ i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("sum "+ sum);
        System.out.println("total sum "+ totalSum);
    }


}
