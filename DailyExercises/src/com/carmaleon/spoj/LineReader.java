package com.carmaleon.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by carlosrojasmatas on 5/27/16.
 */
public class LineReader {

    public static class Point {

        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static class Circle {

        private final Point center;
        private final int radius;

        public Circle(Point center, int radius) {
            this.center = center;
            this.radius = radius;
        }

        public Point getCenter() {
            return center;
        }

        public int getRadius() {
            return radius;
        }

        public boolean has(Point point) {
            return Math.pow(point.getX() - center.getX(), 2)
                    + Math.pow(point.getY() - center.getY(), 2)
                    <= Math.pow(radius, 2);

        }

        public List<Point> bounds() {
            List<Point> b = new ArrayList<>();
            b.add(center);
            b.add(new Point(center.getX() + radius, center.getY()));
            b.add(new Point(center.getX() - radius, center.getY()));
            b.add(new Point(center.getX(), center.getY() + radius));
            b.add(new Point(center.getX(), center.getY() - radius));

            return b;
        }
    }

    public static class Line {
        private final Point start;
        private final Point end;

        public Line(Point start, Point end) {
            this.start = start;
            this.end = end;
        }

        public Point getStart() {
            return start;
        }

        public Point getEnd() {
            return end;
        }

        public boolean has(Point point) {
            double px = point.getX() - start.getX() / end.getX() - start.getX();
            double py = point.getY() - start.getY() / end.getY() - start.getY();
            return px == py;
        }
    }


    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            int testCases = Integer.valueOf(br.readLine());
            List<String> result = new ArrayList<>();

            for (int i = 0; i < testCases; i++) {
                List<Integer> xs = new ArrayList<>();
                List<Integer> ys = new ArrayList<>();
                int elems = Integer.valueOf(br.readLine());
                for (int el = 0; el < elems; el++) {
                    String poly = br.readLine();
                    String[] desc = poly.split(" ");
                    if (desc[0].equals("c")) {
                        Circle c = new Circle(new Point(Integer.valueOf(desc[1]), Integer.valueOf(desc[2])), Integer.valueOf(desc[3]));
                        c.bounds().forEach(b -> {
                            xs.add(b.getX());
                            ys.add(b.getY());
                        });

                    } else if (poly.startsWith("p")) {
                        Point point = new Point(Integer.valueOf(desc[1]), Integer.valueOf(desc[2]));
                        xs.add(point.getX());
                        ys.add(point.getY());
                    } else if (poly.startsWith("l")) {
                        Point start = new Point(Integer.valueOf(desc[1]), Integer.valueOf(desc[2]));
                        Point end = new Point(Integer.valueOf(desc[3]), Integer.valueOf(desc[4]));

                        xs.add(start.getX());
                        xs.add(end.getX());
                        ys.add(start.getY());
                        ys.add(end.getY());
                    }
                }
                //read the enter
                if (i < testCases - 1) {
                    String nevermind = br.readLine();
                }

                int lx = xs.stream().min(Integer::compareTo).get();
                int ly = ys.stream().min(Integer::compareTo).get();
                int ux = xs.stream().max(Integer::compareTo).get();
                int uy = ys.stream().max(Integer::compareTo).get();

                result.add(String.format("%d %d %d %d", lx, ly, ux, uy));
            }

            result.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



