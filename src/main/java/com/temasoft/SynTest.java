package com.temasoft;

import com.temasoft.model.Synonym;
import com.temasoft.model.Word;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class SynTest {
    private static Pattern pProb = Pattern.compile("\\ +"); //проверка пробелов
    private static Pattern pProst = Pattern.compile("\\(простор\\.\\):");
    public static void main(String[] args) throws IOException {
//        String wordForFind = "наполнять";
        long timeStart = System.currentTimeMillis();
        HashMap<Synonym, Set<Synonym>> synonymVocabulary;
//        synonyms = getSimilarWordsWithSynonyms(wordForFind);
        synonymVocabulary = generateWocabulary();
        System.out.println(System.currentTimeMillis() - timeStart);
    }

    private static HashMap<Synonym, Set<Synonym>> generateWocabulary() throws IOException {
        HashMap<Synonym, Set<Synonym>> synonyms = new HashMap<Synonym, Set<Synonym>>();
        BufferedReader reader = new BufferedReader(new FileReader("synonyms.txt"));
        String line;
        int i = 0;
        long timeStart = System.currentTimeMillis();
        while((line = reader.readLine()) != null) {
            line = pProst.matcher(line).replaceAll("");
            line = pProb.matcher(line).replaceAll("\\ ");//проверка пробелов
            String word = line.split("#")[0];
            synonyms.put(new Synonym(word),getSynonymsForWord(word));
            i++;
            if(i == 1000) {
                System.out.print("1000 words counted!");
                System.out.println(System.currentTimeMillis() - timeStart);
                timeStart = System.currentTimeMillis();
            }

            if(i == 2000)  {
                System.out.println("2000 words counted!");
                System.out.println(System.currentTimeMillis() - timeStart);
                timeStart = System.currentTimeMillis();
            }
            if(i == 3000)  {
                System.out.println("3000 words counted!");
                System.out.println(System.currentTimeMillis() - timeStart);
                timeStart = System.currentTimeMillis();
            }
            if(i == 4000)  {
                System.out.println("3000 words counted!");
                System.out.println(System.currentTimeMillis() - timeStart);
                timeStart = System.currentTimeMillis();
            }
            if(i == 5000)  {
                System.out.println("3000 words counted!");
                System.out.println(System.currentTimeMillis() - timeStart);
                timeStart = System.currentTimeMillis();
            }
            if(i == 6000)  {
                System.out.println("3000 words counted!");
                System.out.println(System.currentTimeMillis() - timeStart);
                timeStart = System.currentTimeMillis();
            }
            if(i == 7000)  {
                System.out.println("3000 words counted!");
                System.out.println(System.currentTimeMillis() - timeStart);
                timeStart = System.currentTimeMillis();
            }
            if(i == 8000)  {
                System.out.println("3000 words counted!");
                System.out.println(System.currentTimeMillis() - timeStart);
                timeStart = System.currentTimeMillis();
            }
            if(i == 9000)  {
                System.out.println("3000 words counted!");
                System.out.println(System.currentTimeMillis() - timeStart);
                timeStart = System.currentTimeMillis();
            }
        }
        reader.close();
        return synonyms;
    }

    private static HashMap<Synonym, Set<Synonym>> getSimilarWordsWithSynonyms(String wordForFind) throws IOException {
        HashMap<Synonym, Set<Synonym>> synonyms = new HashMap<Synonym, Set<Synonym>>();
        BufferedReader reader = new BufferedReader(new FileReader("synonyms.txt"));
        String line;
        while((line = reader.readLine()) != null) {
            line = pProb.matcher(line).replaceAll("\\ ");//проверка пробелов
            String[] chunks = line.split("#");
            if(chunks[0].contains(wordForFind)) {
                synonyms.put(new Synonym(chunks[0]), getSynonymsForWord(chunks[0]));
            }

        }
        reader.close();
        return synonyms;
    }
    public static Set<Synonym> getSynonymsForWord(String wordForFind) throws IOException {
        Set<Synonym> foundWords = new HashSet<Synonym>();
        BufferedReader reader = new BufferedReader(new FileReader("synonyms.txt"));
        String line;
        String[] synonyms ;
        while((line = reader.readLine()) != null) {
            line = pProst.matcher(line).replaceAll("");
            line = pProb.matcher(line).replaceAll("\\ ");//проверка пробелов
            String[] chunks = line.split("#");
            if(chunks[0].equals(wordForFind)) {
                chunks = chunks[1].split("\\|\\|");
//                System.out.println(chunks[0]);//chunks[1] - выражения со словом
                chunks = chunks[0].replaceAll("(\\[(.*)\\])", "").split("\\.");//вычитаем дополнительные обьяснения
                if(chunks[0].length() < 3) continue;//не нужны нам короткие слова
                if(chunks[0].substring(0,3).contains("см")) {//проверить ссылкы
                    foundWords.addAll(discoverLinks(chunks[1]));
                    break;
                } else if(chunks[0].contains(",")){//выбрать синонимы
                    chunks[0] = chunks[0].substring(1);
                    synonyms = chunks[0].replaceAll("(\\((.*)\\))", "").split(";");//будем без уточнений и дополнений
                    for(String syn : synonyms) {
                        foundWords.addAll(parseSynonyms(syn));
                    }
                    break;
                }
            }

        }
        reader.close();
        return foundWords;
    }

    private static Set<Synonym> parseSynonyms(String synonyms) {
        Set<Synonym> buffer = new HashSet<Synonym>();
        for(String syn : synonyms.split(",")) {
            if(!syn.isEmpty()) buffer.add(new Synonym(syn.trim()));
        }
        return buffer;
    }

    private static Set<Synonym> discoverLinks(String chunk) throws IOException {
        Set<Synonym> buffer = new HashSet<Synonym>();
        String[] words = chunk.split(",");
        for(String word : words) {
            buffer.add(new Synonym(word));
            buffer.addAll(getSynonymsForWord(word.trim()));
        }
        return buffer;
    }


}
