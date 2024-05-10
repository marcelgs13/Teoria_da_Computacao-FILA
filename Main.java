import java.util.Scanner; 
import java.util.ArrayList;  
 
public class Main {  
    public static void main(String[] args) {  
        Queue queue = new Queue();  
        Scanner scanner = new Scanner(System.in); 
 
        int escolha; 
        do { 
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
                    System.out.print("Digite o valor ou valores separados por vírgula a adicionar: "); 
                    String inputAdd = scanner.nextLine(); 
                    String[] valoresAdd = inputAdd.split(","); 
                    for (String valor : valoresAdd) { 
                        queue.enqueue(Integer.parseInt(valor.trim())); 
                    } 
                    break; 
                case 2: 
                    System.out.print("Digite o valor ou valores separados por vírgula a remover: "); 
                    String inputRemove = scanner.nextLine(); 
                    String[] valoresRemove = inputRemove.split(","); 
                    for (String valor : valoresRemove) { 
                        queue.dequeue(Integer.parseInt(valor.trim())); 
                    } 
                    break; 
                case 3: 
                    queue.showQueue(); 
                    break; 
                case 4: 
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
        private ArrayList<Integer> e;  
 
        public Queue() {  
            e = new ArrayList<>();  
        } 
 
        public void enqueue(int valor) {  
            e.add(valor);  
            System.out.println("Adicionado: [" + valor +"]");  
        } 
 
        public void dequeue(int valor) {  
            if (e.isEmpty()) { 
                System.out.println("A fila está vazia, adicione um novo valor."); 
                return; 
            } else { 
                if (e.contains(valor)) { 
                    e.remove(e.indexOf(valor)); 
                    System.out.println("Removido: " + valor); 
                } else { 
                    System.out.println("Valor " + valor + " não encontrado na fila."); 
                } 
            } 
        } 
 
        public void showQueue() {  
            if (e.isEmpty()) { 
                System.out.println("A fila está vazia."); 
            } else { 
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