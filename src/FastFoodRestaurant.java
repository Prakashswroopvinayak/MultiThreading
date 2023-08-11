public class FastFoodRestaurant {

    private int numberOfBurgerSold =0;
    private   String lastCustomerName;

    public void buyBurger( String clientName){
        alongRunningProcess();
        numberOfBurgerSold++;
        this.lastCustomerName = clientName;
        System.out.println(clientName + " bought a burger ");
    }

    public void alongRunningProcess(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getNumberOfBurgerSold() {
        return numberOfBurgerSold;
    }

    public void setNumberOfBurgerSold(int numberOfBurgerSold) {
        this.numberOfBurgerSold = numberOfBurgerSold;
    }

    public String getLastCustomerName() {
        return lastCustomerName;
    }

    public void setLastCustomerName(String lastCustomerName) {
        this.lastCustomerName = lastCustomerName;
    }


    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        FastFoodRestaurant fastFoodRestaurant = new FastFoodRestaurant();
        Thread t1 = new Thread(()->{
           fastFoodRestaurant.buyBurger("prakash");
        });

        Thread t2 = new Thread(()->{
            fastFoodRestaurant.buyBurger("Nikita");
        });

        Thread t3 = new Thread(()->{
            fastFoodRestaurant.buyBurger("Vivek");
        });

        Thread t4 = new Thread(()->{
            fastFoodRestaurant.buyBurger("PriyaRanjan");
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Total number of burger sold "+ fastFoodRestaurant.getNumberOfBurgerSold());

        System.out.println("Last name of Client "+ fastFoodRestaurant.lastCustomerName);

        System.out.println("Total time of execution time :"+ (System.currentTimeMillis()-startTime));
    }
}
