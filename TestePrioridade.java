import java.util.InputMismatchException;
import java.util.Scanner;

public class TestePrioridade {
    public static void main(String[] args) {
        CentralAtendimentoPrioridade central = new CentralAtendimentoPrioridade();
        Scanner scanner = new Scanner(System.in);
        String solicitante, entrada;
        int opcao = -1, prioridade;
        System.out.println("CENTRAL DE ATENDIMENTO");
        do {
            System.out.print("1 - Abrir novo processo\n" +
                "2 - Atender o próximo\n" +
                "3 - Desfazer o último atendimento\n" +
                "4 - Listar atendimentos pendentes\n" +
                "5 - Listar histórico de atendimentos\n" +
                "0 - sair\n" +
                "Escolha uma opção: "
            );
            try {
                entrada = scanner.nextLine();
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite apenas números entre 0 e 5!\n");
                continue;
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
                                central.abrirProcesso(processo);
                                System.out.println("Processo adicionado à fila.\n");
                            } else {
                                System.out.println("Informe um número de 1 a 3 para prioridade!\n");
                            }
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.out.println("Você deve informar um número de 1 a 3!\n");
                        }
                    } else {
                        System.out.println("Campo obrigatório!\n");
                    }
                    break;
                case 2:
                    System.out.println(central.atenderProximo());
                    break;
                case 3:
                    System.out.println(central.desfazerUltimoAtendimento());
                    break;
                case 4:
                    System.out.println(central.listarPendentes());
                    break;
                case 5:
                    System.out.println(central.listarHistorico());
                    break;
                case 0:
                    System.out.println("Finalizando sistema");
                    break;
                default:
                    System.out.println("Opção inválida!\n");
            }
        } while (opcao != 0);
        scanner.close();
    }
}


