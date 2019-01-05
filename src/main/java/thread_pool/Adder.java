package thread_pool;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Adder implements Runnable {
    private final String inFile, outFile;

    public Adder(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }

    public void doAdd() throws IOException {
        int total = 0;
        int count = 0;
        String line;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(this.inFile))) {
            while ((line = reader.readLine()) != null) {
                total = total + Integer.parseInt(line);
                count = count + 1;
            }
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(this.outFile))) {
            writer.write("Total : " + total);
            writer.write("Count : " + count);
        }
    }


    @Override
    public void run() {
        try {
            doAdd();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
