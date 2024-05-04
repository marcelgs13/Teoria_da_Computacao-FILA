import java.util.ArrayList;
//Aluno:Marcel Gustavo de Barros Araujo e Marcelo Augusto de Barros Araujo
public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.showQueue();
    }

    public static class Queue {
        private ArrayList<Integer> e;

        public Queue() {
            e = new ArrayList<>();
        }

        public void enqueue(int valor) {
            e.add(valor);
            System.out.println("Adicionado: " + valor);
        }

        public void dequeue() {
            int i = e.remove(1);
            System.out.println("Removido: " + i);
        }

        public void showQueue() {
            System.out.println("Fila completa: " + e.toString());
        }
    }
}
