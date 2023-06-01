import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Acoes acoes = new Acoes();

        System.out.println("\nOlá, bem vindo(a) a sua conta bancária!");

        System.out.print("Digite seu nome: ");
        acoes.setNome(scanner.next());

        System.out.print("Digite o número da sua conta: ");
        acoes.setNumeroConta(scanner.next());

        System.out.print("Digite seu saldo inicial: R$");
        acoes.setSaldoInicial(scanner.nextDouble());

        System.out.println("\nConta bancária criada com sucesso.");

        System.out.println("Escolha a operação que deseja realizar: \n1 - Depositar \n2 - Sacar \n3 - Consultar saldo diponível \n----------------------------------");
        int operation = scanner.nextInt();

        switch (operation) {
            case 1:
                System.out.print("Digite o valor do depósito:");
                acoes.setValorDepositar(scanner.nextDouble());
                acoes.depositar(acoes.getValorDepositar());
                System.out.printf("Depósito de %.2f realizado com sucesso.", acoes.getValorDepositar());
                break;

            case 2:
                System.out.print("Digite o valor do saque:");
                acoes.setValorSacar(scanner.nextDouble());

                if (acoes.getValorSacar() > acoes.getSaldo()) {
                    System.out.println(("Saldo insuficiente para realizar a operação."));
                } 
                
                else if (acoes.getValorSacar() > 5000) {
                    System.out.println("Valor do saque acima do permitido (R$5000,00).");
                } 
                
                else {
                    acoes.sacar(acoes.getValorSacar());
                    System.out.printf("Saque de %.2f realizado com sucesso.", acoes.getValorSacar());
                }

                break;

            case 3:
                System.out.print("O seu saldo atual é de:" + acoes.getSaldo());
                break;

            default:
                System.out.println("Operação inválida, tente novamente.");
        }
        scanner.close();
    }
}
