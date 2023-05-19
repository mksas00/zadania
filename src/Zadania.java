import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Zadania {

    /**
     *
     "Return the number of even ints in the given array. Note: the % "mod" operator computes the remainder, e.g. 5 % 2 is 1."
     * @param tab
     * @return
     */
    public static int zadanie1(int[] tab){
        int count = 0;
        for(int i : tab){
            if(i % 2 == 0)count++;
        }
        return count;
    }

    /**
     *
     Return the sum of the numbers in the array, returning 0 for an empty array. Except the number 13 is very unlucky,
     so it does not count and numbers that come immediately after a 13 also do not count.
     * @param tab
     * @return
     */
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

    /**
     * Given an array of ints, return true if the array contains no 1's and no 3's.
     * @param nums
     * @return
     */
    public static boolean zadanie3(int[] nums){

        for(int i : nums){
            if (i == 1 || i == 3)
                return false;
        }
        return true;

    }

    /**
     * Return an array that contains the exact same numbers as the given array,
     * but rearranged so that all the even numbers come before all the odd numbers.
     * Other than that, the numbers can be in any order. You may modify and return the given array, or make a new array.
     * @param nums
     * @return
     */
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

    /**
     *
     Return an array that contains the exact same numbers as the given array,
     but rearranged so that all the zeros are grouped at the start of the array.
     The order of the non-zero numbers does not matter. So {1, 0, 0, 1} becomes {0 ,0, 1, 1}.
     You may modify and return the given array or make a new array.
     * @param nums
     * @return
     */
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

    /**
     *
     Given n>=0, create an array length n*n with the following pattern,
     shown here for n=3 : {0, 0, 1,    0, 2, 1,    3, 2, 1} (spaces added to show the 3 groups).
     * @param n
     * @return
     */
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

    /**
     * Return an array that contains exactly the same numbers as the given array, but rearranged so that every 4 is immediately followed by a 5.
     * Do not move the 4's, but every other number may move.
     * The array contains the same number of 4's and 5's, and every 4 has a number after it that is not a 4.
     * In this version, 5's may appear anywhere in the original array.
     * @param nums
     * @return
     */
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

    /**
     *
     Given three ints, a b c, return true if one of b or c is "close" (differing from a by at most 1), while the other is "far",
     differing from both other values by 2 or more. Note: Math.abs(num) computes the absolute value of a number.
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static boolean zadanie8(int a, int b, int c){

        return ((Math.abs(a - b) < 2 || Math.abs(a - c) < 2)) && (((Math.abs(b - c) > 1 && Math.abs(b - a) > 1)) || (Math.abs(c - b) > 1 && Math.abs(c - a) > 1));

    }

    /**
     * Given 3 int values, a b c, return their sum. However,
     * if one of the values is 13 then it does not count towards the sum and values to its right do not count.
     * So for example, if b is 13, then both b and c do not count.
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int zadanie9(int a, int b, int c){

        if(a == 13)return 0;
        else if(b == 13) return a;
        else if(c == 13) return a+b;
        else return a+b+c;
    }

    /**
     *
     Given an array of ints, return the number of times that two 6's are next to each other in the array.
     Also count instances where the second "6" is actually a 7.
     * @param nums
     * @return
     */
    public static int zadanie10(int[] nums){

        int sixPairCount = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == 6 && (nums[i+1] == 6 || nums[i+1] == 7))sixPairCount++;
        }
        return sixPairCount;
    }

    /**
     * We want to make a row of bricks that is goal inches long. We have a number of small bricks (1 inch each) and big bricks (5 inches each).
     * Return true if it is possible to make the goal by choosing from the given bricks.
     * @param small
     * @param big
     * @param goal
     * @return
     */
    public static boolean zadanie11(int small, int big, int goal){

        int reszta, i = 0;

        while (i <= small){
            reszta = goal - i;
            if(big * 5 >= reszta && reszta % 5 == 0)return true;
            i++;
        }
        return false;
    }

    /**
     *
     Given 3 int values, a b c, return their sum. However,
     if any of the values is a teen in the range 13..19 inclusive then that value counts as 0, except 15 and 16 do not count as a teens.
     Write a separate helper "public int fixTeen(int n) {"that takes in an int value and returns that value fixed for the teen rule.
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int zadanie12(int a, int b, int c){

        return fixTeen(a) + fixTeen(b) + fixTeen(c);
    }

    /**
     * Fix Teen
     * @param n
     * @return
     */
    public static int fixTeen(int n){

        if((n >= 13 && n<=19) && (n != 15 && n!=16))return 0;
        else return n;
    }

    /**
     *
     Given 2 int values greater than 0, return whichever value is nearest to 21 without going over. Return 0 if they both go over.
     * @param a
     * @param b
     * @return
     */
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