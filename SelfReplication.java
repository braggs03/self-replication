public class SelfReplication {
    private static String self = "";
    public static void main(String[] args) {
        System.out.print("public class SelfReplication {\nprivate static String self = \"");
        int cnt = 0;
        while (cnt < self.length()) {
            char c = self.charAt(cnt);
            if (c == '\\') {
                cnt++;
                System.out.print("\\");
                c = self.charAt(cnt);
                if (c == 'n'){
                    System.out.print("\\n");
                } else if(c == '\\'){
                    System.out.print("\\");
                } else if (c == '\"') {
                    System.out.print("\\\\\"");
                }
            } else {
                System.out.print(c);
            }
            cnt++;
        }
        System.out.println(self);
    }
}