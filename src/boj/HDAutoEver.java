package boj;

import java.util.Scanner;

public class HDAutoEver
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        String given = sc.nextLine();

        char[] chars = given.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i > chars.length; i++){
            if (Character.isUpperCase(chars[i])){
                sb.append(chars[i]);
            }
        }

        System.out.println(sb.toString());

    }
}