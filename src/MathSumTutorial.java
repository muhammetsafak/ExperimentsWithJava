import java.util.Scanner;

public class MathSumTutorial {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("İlk büyük rakamı giriniz:");
        String firstDigit = input.next();
        System.out.println("İkinci büyük sayıyı giriniz :");
        String secondDigit = input.next();
        System.out.println("İşlem sonucunuz : \n" + sum(firstDigit, secondDigit));
    }

    public static String sum(String ...args) {
        if (args.length < 2) {
            return args[0];
        }
        int maxLen = maxLength(args);

        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < maxLen; i++) {
            int sum = carry;
            for (String arg : args) {
                int index = arg.length() - 1 - i;
                sum += (index < 0) ? 0 : arg.charAt(index) - '0';
            }
            carry = sum / 10;
            res.append(sum % 10);
        }
        if (carry > 0) {
            res.append(carry);
        }

        return res.reverse().toString();
    }

    private static int maxLength(String ...str) {
        int len = 0;
        for (String s : str) {
            len = Math.max(len, s.length());
        }

        return len;
    }

}
