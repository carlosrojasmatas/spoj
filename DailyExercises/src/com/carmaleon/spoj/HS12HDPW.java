package com.carmaleon.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Created by carlosrojasmatas on 7/15/16.
 */
public class HS12HDPW {
    static class Pair {
        int blue;
        int green;

        public Pair(int blue, int green) {
            this.blue = blue;
            this.green = green;
        }
    }

    public static void main(String[] args) {


        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            int testCases = Integer.valueOf(br.readLine());
            String[] result = new String[testCases];
            for (int tc = 0; tc < testCases; tc++) {
                String nrTuples = br.readLine();
                String[] tuples = br.readLine().split(" ");
                String encripted = br.readLine();

                String word = Stream.of(tuples)
                        .map(t -> fromTuple(t))
                        .map(p -> String.valueOf(encripted.charAt(p.blue)) + String.valueOf(encripted.charAt(p.green)))
                        .reduce((s1, s2) -> s1 + s2).get();

                result[tc] = word;
                if (tc < testCases - 1) {
                    String nevermind = br.readLine();
                }

            }

            for(String w : result){
                System.out.println(w);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Pair fromTuple(String tuple) {
        String octet ="00000000";

        char[] chars = tuple.toCharArray();
        StringBuilder sBlue = new StringBuilder();
        StringBuilder sGreen = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            String binary = new StringBuilder(padOctect(Integer.toBinaryString(chars[i]))).reverse().toString();
            sBlue = sBlue.append(String.valueOf(binary.charAt(i)));
            int mod = (i + 3) % 6;
            sGreen = sGreen.append(String.valueOf(binary.charAt(mod)));
//            System.out.println("Character: " + chars[i]
//                    +" Binary: "+ binary
//                    + " mod " + mod
//                    + " pos blue: " + i
//                    + " pos green: " + mod
//                    + " char blue: " + binary.charAt(i)
//                    + " char green: " + binary.charAt(mod)
//                    );
        }


        String blueBinary = padOctect(sBlue.reverse().toString());
        String greenBinary = padOctect(sGreen.reverse().toString());
        int blueCode = Integer.parseInt(blueBinary , 2);
        int greenCode = Integer.parseInt(greenBinary, 2);

        return new Pair(blueCode, greenCode);
    }

    private static String padOctect(String unpadded) {
        String octet ="00000000";
        return octet.substring(unpadded.length()) + unpadded;
    }
}
