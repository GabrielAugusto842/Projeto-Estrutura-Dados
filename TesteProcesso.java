import java.util.InputMismatchException;
import java.util.Scanner;

public class TesteProcesso {
    public static void main(String[] args) {
        VetorDinamico vetor = new VetorDinamico();
        Scanner scanner = new Scanner(System.in);
        String solicitante, entrada;
        int opcao = -1, prioridade;
        do {
            System.out.print("\nDigite:\n1 para inserir\n2 para remover\n0 para sair\n--> ");
            entrada = scanner.nextLine();
            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite apenas números!");
            }
            
            switch (opcao) {
                case 1:
                    System.out.print("Informe o nome do solicitante: ");
                    solicitante = scanner.nextLine();
                    if (!solicitante.trim().isEmpty()) {
                        try {
                            System.out.print("Qual a prioridade? (1 = baixa, 2 = normal, 3 = urgente): ");
                            prioridade = scanner.nextInt();
                            scanner.nextLine();
                            if (prioridade == 1 || prioridade == 2 || prioridade == 3) {
                                Processo processo = new Processo(solicitante, prioridade);
                                vetor.adiciona(processo);
                                System.out.println("A capacidade atual do vetor é " + vetor.getCapacidade());
                                System.out.println("Você ocupou " + vetor.getOcupacao() + " posições do vetor.");
                            } else {
                                System.out.println("Informe um número de 1 a 3 para prioridade!");
                            }
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("Você deve informar um número de 1 a 3!");
                        }
                    } else {
                        System.out.println("Campo obrigatório!");
                    }
                    break;
                case 2:
                    vetor.remove();
                    System.out.println("A capacidade atual do vetor é " + vetor.getCapacidade());
                    System.out.println("Você ocupou " + vetor.getOcupacao() + " posições do vetor.");
                    break;
                default:
                    Processo[] listaProcessos = vetor.listar();
                    for (Processo process : listaProcessos) {
                        if (process != null) {
                            System.out.println("Seus processos:\n" + process);
                        }
                    }
                    break;
            }
        } while (opcao != 0);
        scanner.close();
    }
}
