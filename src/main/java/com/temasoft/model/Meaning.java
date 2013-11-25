package com.temasoft.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: tymur
 * Date: 25.11.13
 * Time: 12:19
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="meanings")
public class Meaning {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String value;

    public Meaning() {

    }

    public Meaning(String value) {
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
        Meaning other = (Meaning) o;
        return value.equals(other.value);
    }

}
