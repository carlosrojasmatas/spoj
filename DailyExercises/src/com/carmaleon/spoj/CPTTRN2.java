package com.carmaleon.spoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by charly on 10/14/15.
 */
public class CPTTRN2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> rows = new ArrayList<Integer>();
        List<Integer> cols = new ArrayList<Integer>();

        int tcs = scanner.nextInt();
        for (int i = 0; i < tcs; i++) {
            rows.add(scanner.nextInt());
            cols.add(scanner.nextInt());
        }

        for (int i = 0; i < rows.size(); i++) {
            for (int r = 0; r < rows.get(i); r++) {
                for (int c = 0; c < cols.get(i); c++) {

                    if (c == 0 || r == 0 || r == rows.get(i) - 1 || c == cols.get(i) - 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(".");
                    }

                }

                if (r != rows.get(i) - 1) {
                    System.out.println();
                }
            }

            if (i < rows.size() - 1) {
                System.out.println("\n");
            }

        }
        

    }
}
