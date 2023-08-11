import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankTranferLock {

    private double balance;
    private int id;
    private String accountName;

    final Lock lock = new ReentrantLock();

    public BankTranferLock(int id, double balance, String accountName){
        this.id = id;
        this.balance = balance;
        this.accountName = accountName;
    }


    public boolean withdraw(double amount) throws InterruptedException {
        if (this.lock.tryLock()) {
            Thread.sleep(100);
            balance -= amount;
            this.lock.unlock();
            return true;

        }
        return false;

    }

    public  boolean deposit(double amount) throws InterruptedException {
        if(this.lock.tryLock()){
            Thread.sleep(100);
            balance +=amount;
            this.lock.unlock();
            return true;

        }

        return false;
    }

    public boolean tranfer(BankTranferLock to, double amount) throws InterruptedException {

        if(withdraw(amount)){
            System.out.println("Withdrawing amount : "+ amount + " from "+ accountName);
            if(to.deposit(amount)){
                System.out.println("Depositing amount "+ amount + " to : "+ to.accountName);
                return true;
            }else{
                System.out.println("#########failed to acquire both locks : refunding "+ amount + "to: "+ accountName);
                while (!to.deposit(amount))
                    continue;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        BankTranferLock strudenBankAccount = new BankTranferLock(1, 50000, "Prakash");

        BankTranferLock universityBankAccount = new BankTranferLock(2, 100000, "cvrce");

        System.out.println(" Starting balance of account are University:  "+ universityBankAccount.balance + " Student: "+ strudenBankAccount.balance );


        ExecutorService service = Executors.newFixedThreadPool(10);


        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " says starting transfer ");

                try {
                    while (!strudenBankAccount.tranfer(universityBankAccount, 1000)) {

                        Thread.sleep(100);
                        continue;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


        });


        for (int i= 0; i<20; i++){
            service.submit(t);
        }

        service.shutdown();

        try{
            while(!service.awaitTermination(20L, TimeUnit.HOURS)){
                System.out.println(" Not yet. still waiting for termination");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(" Ending balance of students account :"+ strudenBankAccount.balance + "University Account : "+ universityBankAccount.balance);
    }


}
