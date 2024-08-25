public class Hello {
    public static void main(String[] args) {
        System.out.print("Enter your name: ");
        Scanner in = new Scanner(System.in);
        String name;
        name = in.nextString();
        System.out.printf("hello, %s", name);
    }
}