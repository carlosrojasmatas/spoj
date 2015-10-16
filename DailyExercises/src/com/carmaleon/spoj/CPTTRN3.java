package com.carmaleon.spoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by charly on 10/14/15.
 */
public class CPTTRN3 {


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
                System.out.print(getPattern(r == rows.get(i) - 1, cols.get(i)));
            }

            System.out.println();

        }


    }

    private static String getPattern(boolean isEnd, int cols) {
        String Separator = "***";
        String Inner = "*..";
        StringBuffer buff = new StringBuffer();

        for (int c = 0; c < cols; c++) {
            buff.append(Separator);
        }

        buff.append("*\n");
        for (int c = 0; c < cols; c++) {
            buff.append(Inner);
        }

        buff.append("*\n");
        for (int c = 0; c < cols; c++) {
            buff.append(Inner);
        }

        if (isEnd) {
            buff.append("*\n");
            for (int c = 0; c < cols; c++) {
                buff.append(Separator);
            }
        }

        return buff.append("*\n").toString();
    }
}
