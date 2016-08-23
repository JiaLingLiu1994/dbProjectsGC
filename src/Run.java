public class Run {
    public static void main(String[] args) {
        Attributes info = getInput();
        System.out.println(info.getA() + " " + info.getB() + " " + info.getC());
    }

    public static Attributes getInput() {
        Attributes info = new Attributes();
        return info;
    }
}
