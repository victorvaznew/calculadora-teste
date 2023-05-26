package org.example;

public class Calculadora {
    public Calculadora() {
    }

    public int somar(int a, int b) {
        return a + b;
    }

    public int subtrair(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        if (b == 0)
            throw new ArithmeticException("Impossível dividir por zero!");

        return a / b;
    }

    boolean ePar(int a) {
        return (a % 2) == 0;
    }
}
