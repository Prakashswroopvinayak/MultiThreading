public class Join {

    public static void main(String[] args) throws InterruptedException {


        Thread thread1 = new Thread(
                ()->{
                    for(int i = 0; i< 4; i++){

                        System.out.println(i);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
        Thread thread2 = new Thread(
                ()->{
                    for(int i = 4; i< 9; i++){

                        System.out.println(i);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );

        thread1.start();
        thread1.join(150,250);
        thread2.start();



    }
}


