import java.util.InputMismatchException;
import java.util.Scanner;

public class TesteProcesso {
    public static void main(String[] args) {
        VetorDinamico vetor = new VetorDinamico();
        Scanner scanner = new Scanner(System.in);
        String solicitante, entrada, tipoServico; //entrada recebe o valor do menu para ser convertido para opção
        int opcao = -1, prioridade; //declarando opção como -1 porque 0 sai do menu
        do {
            System.out.print("\nDigite:\n1 para inserir\n2 para remover\n0 para sair\n--> ");
            entrada = scanner.nextLine();
            try {
                opcao = Integer.parseInt(entrada);
                switch (opcao) {
                    case 1:
                        System.out.print("Informe o nome do solicitante: ");
                        solicitante = scanner.nextLine();
                        if (!solicitante.trim().isEmpty()) {//verifica vazio
                            System.out.print("Qual o tipo de atendimento? (Saúde, financeiro, ...): ");
                            tipoServico = scanner.nextLine();
                            if (!tipoServico.trim().isEmpty()) { //verifica vazio
                                try {
                                    System.out.print("Qual a prioridade? (1 = baixa, 2 = normal, 3 = urgente): ");
                                    prioridade = scanner.nextInt();
                                    scanner.nextLine(); //limpa o scanner e previne bug de pular o próximo campo
                                    if (prioridade == 1 || prioridade == 2 || prioridade == 3) {
                                        Processo processo = new Processo(solicitante, tipoServico, prioridade);
                                        vetor.adiciona(processo);
                                        //Sempre informando capacidade e ocupação
                                        System.out.println("A capacidade atual do vetor é " + vetor.getCapacidade());
                                        System.out.println("Você ocupou " + vetor.getOcupacao() + " posições do vetor.");
                                    } else {
                                        System.out.println("Informe um número de 1 a 3 para prioridade!");
                                    }
                                } catch (InputMismatchException e) {
                                    scanner.nextLine(); //limpa o scanner e previne bug de pular o próximo campo
                                    System.out.println("Você deve informar um número de 1 a 3!");
                                }
                            } else {
                                System.out.println("Campo Tipo de serviço é obrigatório!\n");
                            }
                        } else {
                            System.out.println("Campo solicitante é obrigatório!");
                        }
                        break;
                    case 2:
                        vetor.remove();
                        //Sempre informando capacidade e ocupação
                        System.out.println("A capacidade atual do vetor é " + vetor.getCapacidade());
                        System.out.println("Você ocupou " + vetor.getOcupacao() + " posições do vetor.");
                        break;
                    default:
                        Processo[] listaProcessos = vetor.listar();
                        System.out.println("Seus processos:");
                        for (Processo process : listaProcessos) {
                            if (process != null) {
                                System.out.println(process);
                            }
                        }
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite apenas números!");
            }
        } while (opcao != 0);
        scanner.close();
    }
}
