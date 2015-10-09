package com.carmaleon.spoj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by charly on 10/9/15.
 */
public class CPTTRN1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int tcnr = scan.nextInt();
        assert tcnr < 100;
        List<Integer> rows = new ArrayList<Integer>();
        List<Integer> cols = new ArrayList<Integer>();

        for (int i = 0; i < tcnr; i++) {
            int ln = scan.nextInt();
            int col = scan.nextInt();
            assert ln < 100 && col < 100;
            rows.add(ln);
            cols.add(col);
        }


        for (int idx = 0; idx < rows.size(); idx++) {
            int row = rows.get(idx);
            int col = cols.get(idx);
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {

                    if (r % 2 == 0) {
                        if (c % 2 == 0) {
                            System.out.print("*");
                        } else {
                            System.out.print(".");
                        }
                    } else {
                        if (c % 2 == 0) {
                            System.out.print(".");
                        } else {
                            System.out.print("*");
                        }
                    }
                    if (c == col - 1) System.out.print("\n");
                }
                if (r == row - 1) System.out.print("\n");

            }


        }
    }

}
