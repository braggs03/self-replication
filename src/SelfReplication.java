import java.io.FileWriter;
import java.io.IOException;
class SelfReplication {
    public static void main(String[] args) throws IOException, InterruptedException {
        int currentIteration = 0;
        if (args.length == 1) {
            currentIteration = Integer.parseInt(args[0]);
            if (currentIteration > 5) {
                System.exit(0);
            }
        }
        String self = """
import java.io.FileWriter;
import java.io.IOException;
class SelfReplication%d {
    public static void main(String[] args) throws IOException, InterruptedException {
        int currentIteration = 0;
        if (args.length == 1) {
            currentIteration = Integer.parseInt(args[0]);
            if (currentIteration > 5) {
                System.exit(0);
            }
        }
        String self = %c%c%c%c%s%c%c%c;
        self = String.format(self, currentIteration + 1, 34, 34, 34, 10, self, 34, 34, 34, 37, 100);
        String filename = String.format("SelfReplication%c%c", currentIteration + 1);
        write(filename, self);
        Process compile = Runtime.getRuntime().exec(new String[]{ "javac", System.getProperty("user.dir") + "/" + filename + ".java" });
        compile.waitFor();
        Process proc = Runtime.getRuntime().exec(new String[]{ "java", "-cp", System.getProperty("user.dir") + "/", filename, String.valueOf(currentIteration + 1) });;
        proc.waitFor();
    }
    static void write(String filename, String self) throws IOException {
        FileWriter file = new FileWriter(filename + ".java");
        file.write(self);
        file.close();
    }
}
""";
        self = String.format(self, currentIteration + 1, 34, 34, 34, 10, self, 34, 34, 34, 37, 100);
        String filename = String.format("SelfReplication%d", currentIteration + 1);
        write(filename, self);
        Process compile = Runtime.getRuntime().exec(new String[]{ "javac", System.getProperty("user.dir") + "/" + filename + ".java" });
        compile.waitFor();
        Process proc = Runtime.getRuntime().exec(new String[]{ "java", "-cp", System.getProperty("user.dir") + "/", filename, String.valueOf(currentIteration + 1) });;
        proc.waitFor();
    }
    static void write(String filename, String self) throws IOException {
        FileWriter file = new FileWriter(filename + ".java");
        file.write(self);
        file.close();
    }
}