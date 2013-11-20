package com.temasoft;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: tymur
 * Date: 19.11.13
 * Time: 17:47
 * To change this template use File | Settings | File Templates.
 */
public class fileTest2 {
    public static void main(String[] args) throws IOException {
//        generateBase();
        System.out.println(findRimes("корова"));


    }

    private static List<String> findRimes(String word) throws IOException {
        word = word.toLowerCase();
        BufferedReader reader = new BufferedReader(new FileReader("dictionary_transformed.txt"));
        List<String> rimes  = new ArrayList<String>();
        String line;
        String last4Chars = word.substring(word.length() - 4);
        String last3Chars = word.substring(word.length() - 3);
        String last2Chars = word.substring(word.length() - 2);
        String lastChar = word.substring(word.length() - 1);

        while((line = reader.readLine()) != null) {
            if(line.length() < 3 ) continue;
            if(line.length() >= 4){
                if (reverseWord(line.substring(0,4)).equals(last4Chars)){
                    rimes.add(reverseWord(line));
                    continue;
                }
            }
            if(reverseWord(line.substring(0,3)).equals(last3Chars)){
                rimes.add(reverseWord(line));
                continue;
            }
//            if(reverseWord(line.substring(0,2)).equals(last2Chars)){
//                rimes.add(reverseWord(line));
//                continue;
//            }
//            if(line.substring(0,1).equals(lastChar)){
//                rimes.add(reverseWord(line));
//                continue;
//            }
        }
        reader.close();
        return rimes;
    }

    private static String reverseWord(String line) {
        return new StringBuilder(line).reverse().toString();
    }

    private static void generateBase() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("dictionary2.txt"));
        String line = null;
        StringBuilder builder = null;
        Pattern pattern = Pattern.compile("\\s");
        while((line = reader.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            line = matcher.replaceAll("");
            if(Character.isUpperCase(line.charAt(0))) continue;
            builder = new StringBuilder(line).reverse().append(System.lineSeparator());

            write(builder.toString());
//            System.out.println(builder.toString());
        }

        reader.close();
    }

    private static void write(String s) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("res\\" + s.substring(0,1).hashCode() + s.substring(1,2).hashCode(),true));
        writer.write(s);
        writer.close();

    }
}
