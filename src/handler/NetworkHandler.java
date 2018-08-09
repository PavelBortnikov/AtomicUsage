package handler;

import java.util.concurrent.ThreadLocalRandom;

public class NetworkHandler {

    private String thread;

    public NetworkHandler(String thread) {
        this.thread = thread;
    }

    public String handle(){
        int rand = ThreadLocalRandom.current().nextInt();

        if(rand < 0 )
            rand = Math.abs(rand);

        System.out.println(thread + " время " + rand);
        try {
            Thread.sleep(rand/10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Поток номер " + thread + " работал " + rand + " секунд";
    }
}
