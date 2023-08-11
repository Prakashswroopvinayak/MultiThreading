package JavaConcept;

public class SingleTon {

    private  String name = "Prakash Swaroop Vinayak";

    private SingleTon(){
        System.out.println(" inside constructor");
    }

    private static SingleTon singleTon = null;
    public static SingleTon getInstance(){
        if(singleTon == null){

            singleTon = new SingleTon();
        }
        System.out.println(" inside method");
        return singleTon;
    }


    public static void main(String[] args) {
        SingleTon newSingleTon =  SingleTon.getInstance();

        System.out.println(" My name is : "+ newSingleTon.name);
        SingleTon newSingleTon2 = new SingleTon();

        System.out.println(" My name is : "+ newSingleTon2.name);

    }
}
