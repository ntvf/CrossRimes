package com.temasoft.model;


import javax.persistence.*;

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
    @Column(name = "word_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "word")
    private String value;

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
        return value;
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


}
