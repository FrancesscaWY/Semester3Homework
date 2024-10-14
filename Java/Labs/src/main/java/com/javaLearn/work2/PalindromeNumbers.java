package com.javaLearn.work2;
import java.util.ArrayList;
public class PalindromeNumbers {
    public static boolean isPalindrome(int number){
        return number==reverse(number);
    }
    public static int reverse(int number){
        int count = 0;
        int newNum = 0;
//        create a ArrayList to store number of digits
        ArrayList<Integer> nums = new ArrayList<Integer>();
//        The modulo operation deposits the numbers in each position into the nums list
        while(number!=0){
            int a = number%10;
            nums.add(a);
            number/=10;
            count++;
        }
//        generate new reverse number
        for(int i=0;i<nums.size();i++){
            int temp = count-1;
            int b = nums.get(i);
            while(temp!=0){
                b*=10;
                temp--;
            }
            newNum += b;
            count--;
        }
        return newNum;
    }

    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        System.out.printf("从1到%-3d的回文数如下:\n", n);
        for(int i=1;i<n;i++){
            if(isPalindrome(i)){
                System.out.print(i+" ");
            }
        }
    }

}
