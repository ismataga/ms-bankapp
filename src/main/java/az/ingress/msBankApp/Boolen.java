package az.ingress.msBankApp;

public class Boolen {
    public static void main(String[] args) {
        String a = "a";
        boolean b = isValidTokens(a);
        System.out.println(b);
        System.out.println(isValidTokens(a));
        System.out.println("resultb      " + b);
    }

    private static boolean isValidTokens(String a) {
        System.out.println(a);
        return a.equalsIgnoreCase("a");
    }
}
