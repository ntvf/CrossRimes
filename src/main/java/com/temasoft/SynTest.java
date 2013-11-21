package com.temasoft;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: tymur
 * Date: 20.11.13
 * Time: 16:08
 * To change this template use File | Settings | File Templates.
 */
public class SynTest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("synonyms.txt"));
        String wordForFind = "новый";
        String line;
        long timeStart = System.currentTimeMillis();
        while((line = reader.readLine()) != null) {
            String[] chunks = line.split("#");
            if(chunks[0].equals(wordForFind)) {
                System.out.println(chunks[1]);
                break;
            }
        }
        reader.close();
        System.out.println(System.currentTimeMillis() - timeStart);
    }

}
