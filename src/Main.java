import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random randNum = new Random();
        int number = randNum.nextInt(100);
        Scanner input = new Scanner(System.in);

        int right = 0;
        int userInput;
        int[] wrong = new int[5];
        boolean isWin = false;
        boolean isWrong = false;

        while(right < 5){
            System.out.print("Lütfen tahmininizi giriniz : ");
            userInput = input.nextInt();

            if(userInput < 0 || userInput > 99){
                System.out.println("Lütfen 0 - 100 arasında bir değer giriniz.");
                if(isWrong){
                    right++;
                    System.out.println("Çok fazla hatalı giriş yaptınız. Kalan hak : " + (5 - right));
                } else {
                    isWrong = true;
                    System.out.println("Bir daha hatalı girişinizde hakkınızdan düşülecektir.");
                }
                continue;
            }

            if (userInput == number){
                System.out.println("Tebrikler, doğru tahmin ! Tahmin ettiğiniz sayı : " + number);
                isWin = true;
                break;
            } else {
                System.out.println("Hatalı bir sayı girdiniz !");
                if (userInput > number) {
                    System.out.println(userInput + " sayısı, gizli sayıdan büyüktür.");
                } else {
                    System.out.println(userInput + " sayısı, gizli sayıdan küçüktür.");
                }

                wrong[right++] = userInput;
                System.out.println("Kalan hakkı : " + (5 - right));
            }

        }

        if (!isWin) {
            System.out.println("Kaybettiniz ! ");

            System.out.println("Tahminleriniz : " + Arrays.toString(wrong));
            System.out.println("Gizli Sayı : " + number);

        }


    }
}