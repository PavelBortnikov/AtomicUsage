import handler.NetworkHandler;

import java.util.concurrent.atomic.AtomicReference;

public class Main {

    public static void main(String[] args) {

        AtomicReference<String> result = new AtomicReference<>();

        new Thread(() -> {
            result.compareAndSet(null, new NetworkHandler("1").handle());
        }).start();


        new Thread(() -> {
            result.compareAndSet(null, new NetworkHandler("2").handle());
        }).start();

        while (result.get() == null){
            sleep();
        }

        System.out.print(result.get());
    }

    private static void sleep(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {}
    }
}
