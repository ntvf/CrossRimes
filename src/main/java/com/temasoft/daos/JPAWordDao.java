package com.temasoft.daos;

import com.temasoft.model.Word;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: tymur
 * Date: 20.11.13
 * Time: 12:01
 * To change this template use File | Settings | File Templates.
 */
@Service("wordService")
public class JPAWordDAO implements WordDAO{

    @PersistenceUnit()
    private EntityManagerFactory emf;

    @Override
    public void saveAll(Collection<Word> words) {
        EntityManager manager = emf.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        for(Word word : words) {
            manager.merge(word);
        }
        transaction.commit();
        manager.close();

    }

    @Override
    public Set<Word> getRimes(Word word) {
        String wordForRimes = word.getValue();
        String pattern = "%" + wordForRimes.substring(wordForRimes.length()-4);
        EntityManager manager = emf.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        List<Word> resultList =  manager.createNamedQuery("Word.getRimes").setParameter("pattern", pattern).setMaxResults(50).getResultList();
        transaction.commit();
        manager.close();
        Set<Word> rimes = new HashSet<Word>();
        rimes.addAll(resultList);
        return rimes;

        //To change body of implemented methods use File | Settings | File Templates.
    }
}
