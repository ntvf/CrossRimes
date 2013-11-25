package com.temasoft.model;


import com.temasoft.Minning;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: tymur
 * Date: 20.11.13
 * Time: 11:23
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="words")
@NamedQueries({
        @NamedQuery(name="Word.getRimes", query = "select w from Word w where w.value like :pattern")
})
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "word")
    private String value;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "word_id", nullable = true)
    private Set<Meaning> meanings = new HashSet<Meaning>();

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "word_id", nullable = true)
    private Set<Synonym> synonyms = new HashSet<Synonym>();

    public Word() {

    }

    public Word(String value) {
        setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString() {
        return "word " + value + System.lineSeparator()+ "synonyms: " + synonyms.toString() + System.lineSeparator() + "meaning: " + meanings.toString() + System.lineSeparator()  ;
    }

    public int hashCode() {
        return value.hashCode();
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof Word))return false;
        Word other = (Word) o;
        return value.equals(other.value);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Meaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(Set<Meaning> meanings) {
        this.meanings = meanings;
    }

    public Set<Synonym> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(Set<Synonym> synonyms) {
        this.synonyms = synonyms;
    }
}
