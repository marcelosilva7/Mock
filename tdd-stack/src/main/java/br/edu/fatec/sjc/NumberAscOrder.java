package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.List;

public class NumberAscOrder<T extends Number & Comparable<T>> {
    private CustomStack<T> pilhaRecebida;
    private List<T> ordenar;

    public NumberAscOrder(CustomStack<T> pilha) {
        this.pilhaRecebida = pilha;
        this.ordenar = new ArrayList<>();
    }

    public List<T> sort() {
        // Extrai todos os elementos da pilha e os adiciona na lista
        while (!pilhaRecebida.isEmpty()) {
            T valor = pilhaRecebida.pop();
            ordenar.add(valor);
        }

        // Implementação do Insertion Sort
        for (int i = 1; i < ordenar.size(); i++) {
            T chave = ordenar.get(i);
            int j = i - 1;

            // Move os elementos de ordenar[0..i-1], que são maiores que a chave, para uma posição à frente
            // da sua posição atual
            while (j >= 0 && ordenar.get(j).compareTo(chave) > 0) {
                ordenar.set(j + 1, ordenar.get(j));
                j = j - 1;
            }
            ordenar.set(j + 1, chave);
        }

        return ordenar;
    }
}
