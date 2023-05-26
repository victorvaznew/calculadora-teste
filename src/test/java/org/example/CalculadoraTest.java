package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {
    private final Calculadora calculadoraSobTeste = new Calculadora();

    @Test
    void deveSomarNumerosInteiros() {
        // DADO
        int a = 1;
        int b = 2;
        int saidaEsperada = 3;

        // QUANDO
        int resultado = calculadoraSobTeste.somar(a, b);

        // ENTÃO
        assertEquals(saidaEsperada, resultado);
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 3", "2, 1, 3", "3, 2, 1", "-1, 1, 0", "-1, -1, -2"})

    void deveSomarNumerosInteiros(int a, int b, int saidaEsperada) {
        // QUANDO
        int resultado = calculadoraSobTeste.somar(a, b);

        // ENTÃO
        assertEquals(saidaEsperada, resultado);
    }

    @Test
    void deveLancarExcecaoAritimeticaQuandoDividirPorZero() {
        // DADO
        double a = 4.5;
        double b = 0;
        String saidaEsperada = "Impossível dividir por zero!";

        // QUANDO
        Exception excecao = assertThrows(ArithmeticException.class, () -> calculadoraSobTeste.dividir(a, b));

        // ENTÃO
        assertEquals(saidaEsperada, excecao.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -2, -1, 0, 1, 2, Integer.MAX_VALUE})
    void deveRetornarFalsoSeUmNumeroInteiroForImpar(int numero) {
        // QUANDO
        boolean eNumeroPar = calculadoraSobTeste.ePar(numero);

        // ENTÃO
        assertFalse(eNumeroPar);
    }
}