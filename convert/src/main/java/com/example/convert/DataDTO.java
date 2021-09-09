package com.example.convert;

public class DataDTO {

    String input;

    public DataDTO(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "DataDTO{" +
                "input='" + input + '\'' +
                '}';
    }
}
