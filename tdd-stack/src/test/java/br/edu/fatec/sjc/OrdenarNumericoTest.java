package br.edu.fatec.sjc;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class OrdenarNumericoTest {

    @Mock
    private CustomStack<Integer> mockStack;

    private OrdenarNumerico ordenar;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ordenar = new OrdenarNumerico(mockStack);
    }

    @Test
    public void testSortWithNumbers() throws StackFullException, StackEmptyException {
        // Configurando o comportamento do mock
        when(mockStack.isEmpty()).thenReturn(false, false, false, false, false, false, true);
        when(mockStack.pop()).thenReturn(34, 12, 45, 32, 23, 5);

        List<Integer> expected = Arrays.asList(5, 12, 23, 32, 34, 45);
        assertEquals(expected, ordenar.sort());

        // Verifique se os métodos foram chamados corretamente
        verify(mockStack, times(7)).isEmpty();
        verify(mockStack, times(6)).pop();
    }

    @Test
    public void testSortEmptyStack() throws StackEmptyException {
        when(mockStack.isEmpty()).thenReturn(true);

        assertTrue(ordenar.sort().isEmpty());

        verify(mockStack).isEmpty();
        verify(mockStack, never()).pop();
    }
}