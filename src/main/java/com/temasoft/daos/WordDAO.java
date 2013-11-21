package com.temasoft.daos;

import com.temasoft.model.Word;

import java.util.Collection;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: tymur
 * Date: 20.11.13
 * Time: 11:58
 * To change this template use File | Settings | File Templates.
 */
public interface WordDAO {
    public void saveAll(Collection<Word> words);
    public Set<Word> getRimes(Word word);
}
