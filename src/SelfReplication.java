import java.io.*;

class SelfReplication {
    public static void main(String[] args) throws IOException, InterruptedException {
        int currentIteration = 0;
        if (args.length == 1) {
            currentIteration = Integer.parseInt(args[0]);
            if (currentIteration > 5) {
                System.exit(0);
            }
        }
        String self = String.format("public class SelfReplication%d{ public static void main(String[] args){System.out.println(\"Hello \" + args[0]);}}", currentIteration);
        String filename = String.format("SelfReplication%d", currentIteration);
        write(filename, self);
        Runtime.getRuntime().exec(new String[]{ "javac", System.getProperty("user.dir") + "/" + filename + ".java" });
        Thread.sleep(1000);
        Process proc = Runtime.getRuntime().exec(new String[]{ "java", "-cp", System.getProperty("user.dir") + "/", filename, String.valueOf(currentIteration + 1) });;

        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(proc.getInputStream()));

        BufferedReader stdError = new BufferedReader(new
                InputStreamReader(proc.getErrorStream()));

        String s;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }

        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }
    }

    static void write(String filename, String self) throws IOException {
        FileWriter file = new FileWriter(filename + ".java");
        file.write(self);
        file.close();
    }
}