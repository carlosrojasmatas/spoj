package com.carmaleon.spoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by carlosrojasmatas on 3/22/16.
 */
public class CPTTRN7 {

    private static String Footer = "\\/";
    private static String Header = "/\\";

    public static void main(String[] args) {


        class Coordinate {
            final int r;
            final int c;
            final int w;

            public Coordinate(int rows, int cols, int width) {
                this.r = rows;
                this.c = cols;
                this.w = width;
            }

        }

        Scanner scanner = new Scanner(System.in);

        List<Coordinate> coords = new ArrayList<>();


        int tcs = scanner.nextInt();
        for (int i = 0; i < tcs; i++) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            int w = scanner.nextInt();
            coords.add(new Coordinate(r, c, w));
        }

        for (Coordinate c : coords) {
            for (int i = 0; i < c.r; i++) {
                buildPattern(c.w, c.c);
            }
            System.out.println();
        }


    }

    private static String addDots(String current, int it) {
        if (it == 0) return current;
        else return addDots(current + ".", --it);
    }


    private static void buildPattern(int width, int c) {

        for (int i = 0; i < width; i++) {
            String dots = addDots("", width - (i + 1));
            if (width == 1) {
                System.out.println(reflectHorizontally(Header, "", c));
                continue;
            } else if (i == 0) {
                System.out.println(reflectHorizontally(dots + Header + dots, "", c));
                continue;
            }
            System.out.println(reflectHorizontally(dots + "/" + addDots("", i * 2) + "\\" + dots, "", c));
        }

        for (int i = width - 1; i > -1; i--) {

            String dots = addDots("", width - (i + 1));

            if (i == 0) {
                if (width == 1) {
                    System.out.println(reflectHorizontally(Footer, "", c));
                    continue;
                } else {
                    System.out.println(reflectHorizontally(dots + Footer + dots, "", c));
                    continue;
                }
            }

            System.out.println(reflectHorizontally(dots + "\\" + addDots("", i * 2) + "/" + dots, "", c));
        }
    }

    private static String reflectHorizontally(String pattern, String current, int nr) {
        if (nr == 0) return current;
        else return reflectHorizontally(pattern, current + pattern, --nr);
    }


}
