import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Conta[] contas = new Conta[1000];

        for (int i = 0; i < contas.length; i++) {
            contas[i] = new Conta();
            contas[i].setConta();

            System.out.println("Deseja adicionar outra conta? s/n");
            char op = sc.next().charAt(0);
            if (op == 'n') {
                break;
            }
        }

        int totalContas = Conta.totalContas;
        System.out.println("Total de contas criadas: " + totalContas);

        int totalOperacoes = Operacao.totalOperacoes;
        System.out.println("Total de operações realizadas: " + totalOperacoes);

        double mediaOperacoesPorConta = (double) totalOperacoes / totalContas;
        System.out.println("Média de operações por conta: " + mediaOperacoesPorConta);


    }
}
