package com.temasoft;

import com.temasoft.daos.JPAWordDAO;
import com.temasoft.daos.WordDAO;
import com.temasoft.model.Meaning;
import com.temasoft.model.Synonym;
import com.temasoft.model.Word;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tymur
 * Date: 25.11.13
 * Time: 14:57
 * To change this template use File | Settings | File Templates.
 */
public class IntegrTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        WordDAO dao = context.getBean("wordService", JPAWordDAO.class);
        List<Word> words = new ArrayList<Word>();

//        Word word= new Word("любовь");
//        word.addSynonym(new Synonym("страсть"));
//        word.addSynonym(new Synonym("доброта"));
//        words.add(word);
//
//        word = new Word("вечность");
//        word.addSynonym(new Synonym("forewer"));
//
//        word.addMeaning(new Meaning("что-то прекрасное"));
//        word.addMeaning(new Meaning("и очень долгое"));
//        words.add(word);

        dao.saveAll(words);
    }
}
