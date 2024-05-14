package br.edu.fatec.sjc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;

@ExtendWith(MockitoExtension.class)
public class NumberAscOrderTest {

    @Mock
    private CustomStack<Integer> customStack;

    private NumberAscOrder numberAscOrder;

    @BeforeEach
    public void setUp() {
        numberAscOrder = new NumberAscOrder(customStack);
    }

    @Test
    public void testSortWithSixRandomNumbers() throws StackEmptyException {
        List<Integer> randomNumbers = new ArrayList<>();

        Random rand = new Random();
        while (randomNumbers.size() < 6) {
            int randomNumber = rand.nextInt(100);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        Mockito.when(customStack.isEmpty()).thenReturn(false, false, false, false, false, false, true);
        for (Integer number : randomNumbers) {
            Mockito.when(customStack.pop()).thenReturn(number);
        }

        List<Integer> expectedList = new ArrayList<>(randomNumbers);
        Collections.sort(expectedList);

        List<Integer> sortedList = numberAscOrder.sort();
        Assertions.assertEquals(expectedList, sortedList, "A lista ordenada deve ser igual à lista esperada.");
    }

    @Test
    public void testSortWithEmptyStack() throws StackEmptyException {
        Mockito.when(customStack.isEmpty()).thenReturn(true);
        Assertions.assertThrows(StackEmptyException.class, () -> numberAscOrder.sort(),
                "Deve lançar StackEmptyException porque a pilha está vazia.");

        Mockito.verify(customStack, Mockito.never()).pop();
    }
}