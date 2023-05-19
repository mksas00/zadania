import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Zadania {

    public static int zadanie1(int[] tab){
        int count = 0;
        for(int i : tab){
            if(i % 2 == 0)count++;
        }
        return count;
    }

    public static int zadanie2(int[] tab){
        int suma = 0;
        if(tab.length==0) return 0;
        else {
            for(int i = 0; i<tab.length; i++){
                if(tab[i] == 13){
                    i++;
                }
                else {
                    suma += tab[i];
                }
            }
        }
        return suma;
    }

    public static boolean zadanie3(int[] nums){

        for(int i : nums){
            if (i == 1 || i == 3)
                return false;
        }
        return true;

    }

    public static int[] zadanie4(int[] nums){
        List<Integer> parzyste = new ArrayList();
        List<Integer> nieparzyste = new ArrayList();

        for(int i: nums){
            if(i % 2 == 0)parzyste.add(i);
            else nieparzyste.add(i);
        }

        parzyste.addAll(nieparzyste);
        int[] wynik = new int[parzyste.size()];
        for(int i = 0; i < parzyste.size(); i++){
            wynik[i] = parzyste.get(i);
        }
        return  wynik;
    }

    public static int[] zadanie5(int[] nums){

        List<Integer> zeros = new ArrayList();
        List<Integer> numbers = new ArrayList();
        for (int i : nums){
            if(i == 0)zeros.add(i);
            else numbers.add(i);
        }
        zeros.addAll(numbers);

        int[] wynik = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            wynik[i] = zeros.get(i);
        }
        return wynik;
    }

    public static int[] zadanie6(int n){

        if(n == 0) return new int[]{};
        if(n == 1) return new int[]{1};
        else {
            int[] tab = new int[n*n];
            int groupNum = 1;
            for (int i = n - 1; i < tab.length; i += n) {
                int value = 1;
                for (int j = i; j + groupNum != i; j--) {
                    tab[j]=value;
                    value++;
                }
                groupNum++;
            }
            return tab;
        }
    }

    public static int[] zadanie7(int[] nums){
        Stack<Integer> notFoursAndFives = new Stack();
        for(int i: nums){
            if (i != 4 && i != 5) notFoursAndFives.add(i);
        }

        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 4){
                nums[i+1] = 5;
                i++;
            }
            else nums[i] = notFoursAndFives.pop();
        }
        return nums;
    }

    public static boolean zadanie8(int a, int b, int c){

        return ((Math.abs(a - b) < 2 || Math.abs(a - c) < 2)) && (((Math.abs(b - c) > 1 && Math.abs(b - a) > 1)) || (Math.abs(c - b) > 1 && Math.abs(c - a) > 1));

    }

    public static int zadanie9(int a, int b, int c){

        if(a == 13)return 0;
        else if(b == 13) return a;
        else if(c == 13) return a+b;
        else return a+b+c;
    }

    public static int zadanie10(int[] nums){

        int sixPairCount = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == 6 && (nums[i+1] == 6 || nums[i+1] == 7))sixPairCount++;
        }
        return sixPairCount;
    }

    public static boolean zadanie11(int small, int big, int goal){

        int reszta, i = 0;

        while (i <= small){
            reszta = goal - i;
            if(big * 5 >= reszta && reszta % 5 == 0)return true;
            i++;
        }
        return false;
    }

    public static int zadanie12(int a, int b, int c){

        return fixTeen(a) + fixTeen(b) + fixTeen(c);
    }

    public static int fixTeen(int n){

        if((n >= 13 && n<=19) && (n != 15 && n!=16))return 0;
        else return n;
    }

    public static int zadanie13(int a, int b){
        if(a > 21 && b > 21)return 0;
        else if(a > 21 && b < 21) return b;
        else if(a < 21 && b > 21)return a;
        else if(Math.abs(a-21) > Math.abs(b-21))return b;
        else return a;
    }



    public static void main(String[] args) {

        int[] wynik = zadanie6(4);
        System.out.print("[  ");
        for (int i : wynik){
            System.out.print(i + "  ");
        }
        System.out.println("]");

        System.out.println(zadanie12(1,2,15));

    }
}