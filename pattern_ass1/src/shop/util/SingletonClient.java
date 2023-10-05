/*
package shop.util;
public class SingletonClient {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            Singleton singleton = Singleton.getInstance();
            singleton.showMessage();
        });

        Thread thread2 = new Thread(() -> {
            Singleton singleton = Singleton.getInstance();
            singleton.showMessage();
        });

        thread1.start();
        thread2.start();
    }
}
*/