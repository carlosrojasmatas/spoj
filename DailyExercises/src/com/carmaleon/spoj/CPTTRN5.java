package com.carmaleon.spoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by carlosrojasmatas on 3/22/16.
 */
public class CPTTRN5 {

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
            List<String> result = new ArrayList<>(c.r * (c.w + 1));
            for (int row = 0; row < c.r; row++) {
                for (int col = 0; col < c.c; col++) {
                    int initRow = row * (c.w + 1);
                    for (int high = initRow; high <= initRow + c.w; high++) {
                        String current = high >= result.size() ? "" : result.get(high);
                        for (int width = 0; width < c.w + 1; width++) {
                            int effRow = high - initRow;

                            if (high % (c.w + 1) == 0 || width % (c.w + 1) == 0) current = current + "*";

                            else if (row % 2 == 0) {

                                if (c.w == 1) {
                                    if(col % 2 == 0){
                                        current = current + "\\";
                                    }else{
                                        current = current + "/";
                                    }
                                } else if (col % 2 == 0) {
                                    if (width == effRow) {
                                        current = current + "\\";
                                    }
                                    else {
                                        current = current + ".";
                                    }

                                } else {
                                    if ((width + effRow) != c.w  + 1 ) {
                                        current = current + ".";
                                    }
                                    else {
                                        current = current + "/";
                                    }

                                }


                            } else {
                                if (c.w == 1) {
                                    if(col % 2 == 0){
                                        current = current + "/";
                                    }else{
                                        current = current + "\\";
                                    }
                                } else if (col % 2 == 0) {
                                    if ((width + effRow) != c.w  + 1 )
                                        current = current + ".";
                                    else
                                        current = current + "/";

                                } else {

                                    if (width == effRow)
                                        current = current + "\\";
                                    else
                                        current = current + ".";
                                }


                            }

                        }
                        if (high < result.size()) {
                            result.set(high, current);
                        } else {
                            result.add(high, current);
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
