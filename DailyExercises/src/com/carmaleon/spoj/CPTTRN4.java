package com.carmaleon.spoj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by carlosrojasmatas on 3/22/16.
 */
public class CPTTRN4 {

    public static void main(String[] args) {

        class Coordinate {
            final int rows;
            final int cols;
            final int h;
            final int w;

            public Coordinate(int rows, int cols, int vdots, int hdots) {
                this.rows = rows;
                this.cols = cols;
                this.h = vdots;
                this.w = hdots;
            }

            @Override
            public String toString() {
                return "Rows: " + rows + " Cols: " + cols + " High: " + h + " Width: " + w;
            }
        }

        Scanner scanner = new Scanner(System.in);

        List<Coordinate> coords = new ArrayList<>();


        int tcs = scanner.nextInt();
        for (int i = 0; i < tcs; i++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int hv = scanner.nextInt();
            int hc = scanner.nextInt();
            coords.add(new Coordinate(rows, cols, hv, hc));
        }

        for (Coordinate c : coords) {
            List<String> result = new ArrayList<>(c.rows * (c.h + 1));
            for (int row = 0; row < c.rows; row++) {
                for (int col = 0; col < c.cols; col++) {
                    int initRow = row * (c.h+1);
                    for (int high = initRow; high <= initRow + c.h; high++) {
                        String current = high >= result.size() ? "" : result.get(high);
                        for (int width = 0; width < c.w + 1; width++) {
                            if (high % (c.h+1) == 0 || width % (c.w+1) == 0) current = current + "*";
                            else current = current + ".";
                        }
                        if(high < result.size()){
                            result.set(high,current);
                        }else {
                            result.add(high,current);
                        }
                    }
                }
            }

            for (String rs : result) {
                System.out.println(rs + "*");
            }

            System.out.println(result.get(0) + "*");

            System.out.println();
        }


    }
}
