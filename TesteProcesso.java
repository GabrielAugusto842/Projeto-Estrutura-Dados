import java.util.Scanner;

public class TesteProcesso {
    public static void main(String[] args) {
        VetorDinamico vetor = new VetorDinamico();
        Scanner scanner = new Scanner(System.in);
        String solicitante, entrada;
        int opcao = -1;
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
                    Processo processo = new Processo(solicitante);
                    vetor.adiciona(processo);
                    System.out.println("A capacidade atual do vetor é " + vetor.getCapacidade());
                    System.out.println("Você ocupou " + vetor.getOcupacao() + " posições do vetor.");
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
            // System.out.print("Deseja cadastrar outro processo? (S/N): ");
            // continuar = scanner.nextLine();

            // if (continuar.isEmpty() || !continuar.equalsIgnoreCase("S")) {
            //     break;
            // } 
        } while (opcao != 0);
        scanner.close();
    }
}
