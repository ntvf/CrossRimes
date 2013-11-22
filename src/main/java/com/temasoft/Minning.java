package com.temasoft;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: tymur
 * Date: 22.11.13
 * Time: 14:44
 * To change this template use File | Settings | File Templates.
 */
public class Minning {
    private static Pattern tech = Pattern.compile("(Colloq|Lib|Spec|Primo|Non-st|Non-st\\.|Anti|Regio|Obs|Admin|Deprec|Arch\\.Pejor|Maxime)");
    public static void main(String[] args) throws IOException {
        long timeStart = System.currentTimeMillis();
        getMinnings("багульник");
        System.out.println("complited in " + (System.currentTimeMillis() - timeStart));

    }

    private static String getMinnings(String word) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("OZHEGOV.TXT"));
        String line;
        while((line = reader.readLine()) != null) {
            //убираем лишние слова Primo Non-st  Anti  Regio  Obs  Admin Deprec  Arch. Pejor  z - з Maxime
            String[] chunks = line.split("\\|");
            if(chunks[0].equals(word)) {
                System.out.println(tech.matcher(chunks[5]).replaceAll(""));
            }
        }
        reader.close();
        return null;
    }
}
