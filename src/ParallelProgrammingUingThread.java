
//  Implementing multithreading using thread class
public class ParallelProgrammingUingThread {

    public static void main(String[] args) {
        ThreadWorker1 threadWorker1 = new ThreadWorker1();
        ThreadWorker2 threadWorker2 = new ThreadWorker2();
        threadWorker1.start();
        threadWorker2.start();
    }
}



class ThreadWorker1 extends Thread{

    @Override
    public void run() {

        for(int i=0; i<10;i++){
            System.out.println("worker1 is executing : "+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class ThreadWorker2 extends Thread{

    @Override
    public void run() {

        for(int i=0; i<10;i++){
            System.out.println("worker2 is executing : "+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


/*
*       Output
        worker2 is executing : 0
        worker1 is executing : 0
        worker2 is executing : 1
        worker1 is executing : 1
        worker2 is executing : 2
        worker1 is executing : 2
        worker1 is executing : 3
        worker2 is executing : 3
        worker2 is executing : 4
        worker1 is executing : 4
        worker2 is executing : 5
        worker1 is executing : 5
        worker1 is executing : 6
        worker2 is executing : 6
        worker1 is executing : 7
        worker2 is executing : 7
        worker1 is executing : 8
        worker2 is executing : 8
        worker2 is executing : 9
        worker1 is executing : 9
* */