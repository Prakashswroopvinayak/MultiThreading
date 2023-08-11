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
