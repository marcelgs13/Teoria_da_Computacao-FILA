import java.util.ArrayList; 

// Aluno: Marcel Gustavo de Barros Araujo e Marcelo Augusto de Barros Araujo

public class Main { 
    public static void main(String[] args) { 
        Queue queue = new Queue(); // Cria um objeto da classe Queue
        queue.enqueue(1); 
        queue.enqueue(2); 
        queue.enqueue(3); 
        queue.dequeue(); // Remove o primeiro elemento da fila
        queue.showQueue(); // Exibe a fila atual
    }

    public static class Queue { // Declaração da classe interna Queue
        private ArrayList<Integer> e; // Declaração de uma lista privada de inteiros

        public Queue() { // Construtor da classe Queue
            e = new ArrayList<>(); // Inicializa a lista de inteiros
        }

        public void enqueue(int valor) { // Método para adicionar um elemento à fila
            e.add(valor); 
            System.out.println("Adicionado: " + valor); 
        }

        public void dequeue() { // Método para remover um elemento da fila
            int i = e.remove(1); 
            System.out.println("Removido: " + i); 
        }

        public void showQueue() { // Método para exibir a fila
            System.out.println("Fila completa: " + e.toString()); 
        }
    }
}
