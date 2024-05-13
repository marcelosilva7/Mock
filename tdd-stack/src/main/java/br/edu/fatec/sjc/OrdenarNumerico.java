package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenarNumerico {

    private CustomStack<Integer> stack;

    public OrdenarNumerico(CustomStack<Integer> stack) {
        this.stack = stack;
    }

    public List<Integer> sort() throws StackEmptyException {
        List<Integer> sortedList = new ArrayList<>();
        while (!stack.isEmpty()) {
            sortedList.add(stack.pop());
        }
        Collections.sort(sortedList);
        return sortedList;
    }
}
