package test.com.solutions;

public class TestPrint {
    public static void main(String[] a) {

        for (int i = 'A'; i <= 'Z'; i++) {
            System.out.print(Character.valueOf((char)i).charValue()+" ");

        }

        System.out.println("");
        for (int i = 1; i <= 100; i++) {
            if (i % 10 == 0) System.out.println("");
            System.out.print(i +" ");
        }
    }
}
