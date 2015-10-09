package com.carmaleon.spoj;

import java.util.Scanner;

/**
 * Created by charly on 10/7/15.
 */
public class Half {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        StringBuffer result = new StringBuffer();
        for( int i = 0; i < t; i++){
            String word = scan.next();
            result = result.append(word.charAt(0));
            for (int k = 1; k < word.length() /2 ;k++ ){
                if(k%2 == 0 ){
                    result = result.append(word.charAt(k));
                }
            }
            if(i < t){
                result = result.append("\n");
            }
        }
        System.out.println(result.toString());

    }
}