 class SequencialProgramming {

    public static void main(String[] args) {

        Worker1 worker1 = new Worker1();
        Worker2 worker2 = new Worker2();

        worker1.execute(10);
        worker2.execute(10);
    }

}


 class Worker1 {

    public void execute(int n) {

        for( int i = 1; i<=n; i++){
            System.out.println("worker1 is executing "+ i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
 class Worker2 {

    public void execute(int n) {

        for( int i = 1; i<=n; i++){
            System.out.println("worker2 is executing "+ i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

/*
 worker1 is executing 1
worker1 is executing 2
worker1 is executing 3
worker1 is executing 4
worker1 is executing 5
worker1 is executing 6
worker1 is executing 7
worker1 is executing 8
worker1 is executing 9
worker1 is executing 10
worker2 is executing 1
worker2 is executing 2
worker2 is executing 3
worker2 is executing 4
worker2 is executing 5
worker2 is executing 6
worker2 is executing 7
worker2 is executing 8
worker2 is executing 9
worker2 is executing 10
*/
