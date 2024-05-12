import java.util.Scanner;
import java.util.ArrayList;
//Alunos: Marcel Gustavo e Marcelo Augusto
public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(); // Instanciação da fila
        Scanner scanner = new Scanner(System.in);

        int escolha;
        do {
            // Menu de opções
            System.out.println("\n--- Selecione a Opção Desejada ---");
            System.out.println("1. Adicionar");
            System.out.println("2. Remover");
            System.out.println("3. Imprimir lista");
            System.out.println("4. Limpar tela");
            System.out.println("5. Sair");
            System.out.print("Digite a Opção=> ");
            escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada

            switch (escolha) {
                case 1:
                    // Adicionar elemento(s) à fila
                    System.out.print("Digite o valor ou valores separados por vírgula a adicionar: ");
                    String inputAdd = scanner.nextLine();
                    String[] valoresAdd = inputAdd.split(",");
                    for (String valor : valoresAdd) {
                        queue.enqueue(Integer.parseInt(valor.trim()));
                    }
                    break;
                case 2:
                    // Remover elemento da fila
                    queue.dequeue();
                    break;
                case 3:
                    // Mostrar a fila
                    queue.showQueue();
                    break;
                case 4:
                    // Limpar a tela do console
                    clearScreen();
                    break;
                case 5:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (escolha != 5);

        scanner.close();
    }

    public static class Queue {
        private ArrayList<Integer> e; // Lista para armazenar os elementos da fila

        public Queue() {
            e = new ArrayList<>(); // Inicialização da lista
        }

        public void enqueue(int valor) {
            e.add(valor); // Adiciona um elemento ao final da fila
            System.out.println("Adicionado: [" + valor + "]");
        }

        public void dequeue() {
            if (e.isEmpty()) {
                // Se a fila estiver vazia, não há nada para remover
                System.out.println("A fila está vazia, não há nada para remover.");
            } else {
                // Remove o primeiro elemento da fila (FIFO)
                int removedValue = e.remove(0);
                System.out.println("Removido: " + removedValue);
            }
        }

        public void showQueue() {
            if (e.isEmpty()) {
                // Se a fila estiver vazia, exibe uma mensagem
                System.out.println("A fila está vazia.");
            } else {
                // Mostra todos os elementos da fila
                System.out.print("Fila completa: [");
                for (int i = 0; i < e.size(); i++) {
                    System.out.print(e.get(i));
                    if (i < e.size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
            }
        }
    }

    public static void clearScreen() {
        // Implementação para limpar a tela no console do sistema operacional
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Em caso de erro, apenas ignore
        }
    }
}
