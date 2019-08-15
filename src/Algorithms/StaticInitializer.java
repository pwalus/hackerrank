package Algorithms;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StaticInitializer {

    static boolean flag = true;

    static int B;

    static int H;

    static {
        Scanner in = new Scanner(System.in);
        B = in.nextInt();
        H = in.nextInt();

        if (B <= 0 || H <= 0) {
            throw new Exception("Breadth and height must be positive");
        }


    }

    public static void main(String[] args) throws Exception {
        if (flag) {
            int area = B * H;
            System.out.print(area);
        } else {
            throw new Exception("Breadth and height must be positive");
        }

    }//end of main

}//end of class

