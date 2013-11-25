package com.temasoft.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: tymur
 * Date: 25.11.13
 * Time: 16:30
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="synonyms")
public class Synonym {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String value;

    public Synonym() {

    }

    public Synonym(String value) {
        this.value = value;
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
        if (!(o instanceof Meaning))return false;
        Synonym other = (Synonym) o;
        return value.equals(other.value);
    }
}
