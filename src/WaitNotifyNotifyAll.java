public class WaitNotifyNotifyAll {

    public static void main(String[] args) throws InterruptedException {

        final Course course  = new Course("Java wait notify and notifyAll");



        // create three thread  two for the students waiting for notification
        // one is for instructor who is writing the course

        new Thread(()->{
            synchronized (course){
                System.out.println(Thread.currentThread().getName()+ " is waiting for the Course "+course.getTitle());
                try {
                    course.wait();
                    course.notify();


                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(Thread.currentThread().getName() + " the course: "+course.getTitle()+ " is now Completed ");
            }
        },"StudentA").start();

        new Thread(()->{

            synchronized (course){
                System.out.println(Thread.currentThread().getName()+ " is waiting for the Course "+course.getTitle());
                try {
                    course.wait();
                    course.notify();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " the course: "+course.getTitle()+ " is now Completed ");


            }

        },"StudentB").start();

        Thread.sleep(200);
        new Thread(()->{

            synchronized (course){
                System.out.println(Thread.currentThread().getName() + " is starting a new course : "+ course.getTitle());
                try {
                    Thread.sleep(4000);
                    course.notify();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Prakash").start();

    }
}

class Course{
    private String title;
    private boolean completed;

    public Course(String title){
        this.title = title;

    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }



}
