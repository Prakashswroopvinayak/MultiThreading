public class ParallelProgrammingUingRunnable {

    public static int sum =0;
    public static void main(String[] args) throws InterruptedException {
        Worker1Runable worker1Runable = new Worker1Runable(10);
        Worker2Runable worker2Runable = new Worker2Runable((10));


        Thread thread1 = new Thread(worker1Runable);
        Thread thread2 = new Thread(worker2Runable);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(" sum of n number using thread "+sum);
        int totalSum = 0;

        for(int i =0; i<=10;i++){
            totalSum +=i;
        }

        System.out.println(" sum of n number  "+ totalSum);

    }


    public static void add(int val){
        sum += val;
    }
}


class Worker1Runable implements Runnable{
    int sum =0;
    int n=0;
    Worker1Runable(int n){
        this.n =n;
    }
    @Override
    public void run(){
        for(int i =0; i<n/2;i++){
            sum+=i;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        ParallelProgrammingUingRunnable.add(sum);

    }

}

class Worker2Runable implements Runnable{
    int sum =0;
    int n=0;
    Worker2Runable(int n){
        this.n =n;
    }
    @Override
    public void run(){
        for(int i =n/2; i<=n;i++){
            sum+=i;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        ParallelProgrammingUingRunnable.add(sum);



    }
}