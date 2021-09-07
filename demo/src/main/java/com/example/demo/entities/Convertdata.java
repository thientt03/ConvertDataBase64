package com.example.demo.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Convertdata {
    private int id;
    private String inputdata;
    private String outputdata;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "inputdata", nullable = false, length = 100)
    public String getInputdata() {
        return inputdata;
    }

    public void setInputdata(String inputdata) {
        this.inputdata = inputdata;
    }

    @Basic
    @Column(name = "outputdata", nullable = false, length = 100)
    public String getOutputdata() {
        return outputdata;
    }

    public void setOutputdata(String outputdata) {
        this.outputdata = outputdata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Convertdata that = (Convertdata) o;

        if (id != that.id) return false;
        if (inputdata != null ? !inputdata.equals(that.inputdata) : that.inputdata != null) return false;
        if (outputdata != null ? !outputdata.equals(that.outputdata) : that.outputdata != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (inputdata != null ? inputdata.hashCode() : 0);
        result = 31 * result + (outputdata != null ? outputdata.hashCode() : 0);
        return result;
    }
}
