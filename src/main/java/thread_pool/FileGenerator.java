package thread_pool;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileGenerator {
    private final String outfile;

    public FileGenerator(String outfile) {
        this.outfile = outfile;
    }

    public void generateFile() {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(this.outfile))) {
            for (int i = 0; i < 100; i++) {
                writer.write(String.valueOf(i));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
