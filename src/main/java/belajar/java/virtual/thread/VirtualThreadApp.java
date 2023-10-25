package belajar.java.virtual.thread;

import java.io.IOException;
import java.time.Duration;

public class VirtualThreadApp {

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 1_000_000; i++) {
            Thread thread = Thread.ofVirtual().name("Thread Laptop Arief Ke-" + i).unstarted(() -> {
                try {
                    Thread.sleep(Duration.ofSeconds(2));
                    System.out.println("Hello " + Thread.currentThread() + "!");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            thread.start();
        }

        System.in.read();
    }
}
