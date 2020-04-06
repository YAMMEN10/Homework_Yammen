package com.alyndroid.architecturepatternstutorialshomework.model;

public class NumberModel {
    private int firstNum, secondNum;

    public NumberModel(int firstNum, int secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }

    public int getFirstNum() {
        return firstNum;
    }

    public int getSecondNum() {
        return secondNum;
    }

    public String applyOperation(String operation) {
        switch (operation) {
            case "+":
                return String.valueOf(this.firstNum + this.secondNum);
            case "*":
                return String.valueOf(this.firstNum * this.secondNum);
            case "/":
                return String.valueOf(this.firstNum / this.secondNum);
            default:
                return null;
        }
    }
}
