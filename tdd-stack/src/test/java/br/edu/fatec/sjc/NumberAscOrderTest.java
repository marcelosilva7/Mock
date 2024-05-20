package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NumberAscOrderTest {
    private NumberAscOrder<Integer> pilhaOrdenada;
    private Integer[] numeros = {6, 2, 1, 4, 3, 5};
    private List<Integer> listaOrdenada = Arrays.asList(1, 2, 3, 4, 5, 6);
    private List<Integer> listaVazia = new ArrayList<>();
    private int index = 0;

    @Mock
    private CustomStack<Integer> pilha;

    @BeforeEach
    public void setup() {
        pilhaOrdenada = new NumberAscOrder<>(pilha);
        index = 0; // Reset index to zero before each test
        Mockito.when(pilha.isEmpty()).thenAnswer(invocation -> index >= numeros.length);
        Mockito.when(pilha.pop()).thenAnswer(invocation -> numeros[index++]);
    }

    @Test
    public void validarOrdenacao() throws StackEmptyException {
        List<Integer> resultado = pilhaOrdenada.sort();
        assertEquals(listaOrdenada, resultado, "A lista ordenada deve corresponder aos números ordenados.");
    }

    @Test
    public void validarPilhaVazia() throws StackEmptyException {
        index = numeros.length; // Define o índice para simular pilha vazia
        List<Integer> resultado = pilhaOrdenada.sort();
        assertEquals(listaVazia, resultado, "A lista resultante deve estar vazia quando a pilha também está.");
    }
}