package thread_pool;

import java.io.IOException;

public class ThreadPool {
    public static void main(String[] args) throws IOException, InterruptedException {

        long startTime = System.currentTimeMillis();

        FileGenerator file = new FileGenerator("src/main/input.txt");
        file.generateFile();

        // Thread Based Code - Need to fix file lock on this code.
        Thread adder = new Thread(new Adder("src/main/input.txt","src/main/output.txt"));
        adder.start();
        adder.join();

        Thread adder1 = new Thread(new Adder("src/main/input.txt","src/main/output.txt"));
        adder1.start();
        adder1.join();

        // Without Thread
        for (int i = 0; i <100 ; i++) {
            new Adder("src/main/input.txt", "src/main/output.txt").doAdd();
        }


        long endTime = System.currentTimeMillis();

        long totalTimeTaken = endTime - startTime;

        System.out.println("Time taken : " + totalTimeTaken);
    }
}
