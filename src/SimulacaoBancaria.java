import java.util.Scanner;

public class SimulacaoBancaria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 0;
        System.out.println("Escolha uma opção: \n1 - Depositar; \n2 - Sacar; \n3 - Consultar saldo; \n4 - Encerrar");
        // Loop infinito para manter o programa em execução até que o usuário decida sair
        boolean executando = true;
        while (executando) {

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    saldo = depositar(saldo);
                    break;

                case 2:
                    saldo = sacar(saldo);
                    break;

                case 3:
                    consultarSaldo(saldo);
                    break;

                case 4:
                    System.out.println("Encerrando operação...");
                    executando = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente: ");
            }
        }
    }

    static double depositar(double saldoAtual) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quanto deseja depositar? ");
        double deposito = scanner.nextDouble();
        double novoSaldo = saldoAtual + deposito;

        System.out.println("Saldo atual: " + novoSaldo);
        return novoSaldo;
    }

    static double sacar(double saldoAtual) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quanto deseja sacar? ");
        double saque = scanner.nextDouble();

        if (saque > saldoAtual) {
            System.out.println("Saldo insuficiente.");
            return saldoAtual;
        } else {
            double novoSaldo = saldoAtual - saque;
            System.out.println("Saque realizado com sucesso. Novo saldo: " + novoSaldo);
            return novoSaldo;
        }
    }

    static void consultarSaldo(double saldoAtual) {
        System.out.println("Saldo atual: " + saldoAtual);
    }
}