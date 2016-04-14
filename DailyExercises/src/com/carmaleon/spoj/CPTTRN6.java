package com.carmaleon.spoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by carlosrojasmatas on 3/22/16.
 */
public class CPTTRN6 {

    public static void main(String[] args) {

        class Coordinate {
            final int r;
            final int c;
            final int v;
            final int h;

            public Coordinate(int rows, int cols, int ver, int hor) {
                this.r = rows;
                this.c = cols;
                this.v = ver;
                this.h = hor;
            }

        }

        Scanner scanner = new Scanner(System.in);

        List<Coordinate> coords = new ArrayList<>();


        int tcs = scanner.nextInt();
        for (int i = 0; i < tcs; i++) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            int v = scanner.nextInt();
            int h = scanner.nextInt();
            coords.add(new Coordinate(r, c, v,h));
        }

        for (Coordinate c : coords) {

            List<String> pattern  = new ArrayList<>(c.v);
            List<String> result = new ArrayList<>();

            for(int i = 0 ; i < c.v ; i ++){
                for(int j = 0 ; j < c.h; j ++){
                    if( i  >= pattern.size()){
                        pattern.add(".");
                    }else{
                        pattern.set(i,pattern.get(i) + ".");
                    }
                }
            }

            for(String p : pattern){
                result.add(reflectHorizontally(p,"",c.c + 1));
            }

            for(String row:reflectVertically(result,new ArrayList<>(),c.r + 1)){
                System.out.println(row);
            };

            System.out.println();
        }


    }

    private static String footerFor(String pattern) {
        String footer= "";
        for(char c:pattern.toCharArray()){
            if(c == '.') footer = footer + "-";
            else footer = footer + "+";
        }
        return footer;
    }

    private static  List<String> reflectVertically(List<String> pattern, List<String> current,int nr){

        List<String> result = new ArrayList<>();
        String footer = footerFor(pattern.get(0));
       for(int i = 0 ; i< nr ; i ++){
           result.addAll(pattern);
           if(i != nr - 1){
               result.add(footer);
           }
       }

        return result;
    }

    private static String reflectHorizontally(String pattern, String current, int nr) {
        if(nr == 0 )
            return current.substring(0,current.length() - 1);
        else return reflectHorizontally(pattern,pattern + "|" + current,nr -1);
    }
}
