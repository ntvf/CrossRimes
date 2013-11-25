package com.temasoft;

import com.temasoft.daos.JPAWordDAO;
import com.temasoft.daos.WordDAO;
import com.temasoft.model.Word;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: tymur
 * Date: 25.11.13
 * Time: 15:57
 * To change this template use File | Settings | File Templates.
 */
public class FillTheDB {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        WordDAO dao = context.getBean("wordService", JPAWordDAO.class);
        Collection<Word> words = MysqlTest.getWords();
        for(Word word : words) {
            word.setSynonyms(SynTest.getSynonymsForWord(word.getValue()));
            word.setMeanings(Minning.getMinnings(word.getValue()));
            System.out.println(word);
        }
    }
}
