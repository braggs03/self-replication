public class Quine2 {
    public static void main(String[] theArgs) {
        String s = "public class Quine2 {%npublic static void main(String[] theArgs) {%nString s = %c%s%c;%nint dx = 45+46;%nint dy = 34+34;%nint slope = dy/dx;%nSystem.out.printf(s,34,s,34);%n}%n}";
        int dx = 45+46;
        int dy = 34+34;
        int slope = dy/dx;
        System.out.printf(s,34,s,34);
    }
}