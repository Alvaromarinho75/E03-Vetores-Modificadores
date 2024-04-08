import java.util.Scanner;

public class Conta {

    public static Scanner sc = new Scanner(System.in);

    Operacao[] operacoes = new Operacao[1000];

    private String nome;
    private double saldo = 0;
    private int ops = 0;
    private int numero;
    private double limite;

    public static int totalContas;

    public void setNumero(int valor) {
        this.numero = valor;
    }

    public void setConta(){

        System.out.println("Digite o nome da conta: ");
        String nome = sc.nextLine();
        this.setNome(nome);

        System.out.println("Digite o numero da conta: ");
        int numero = sc.nextInt();
        this.setNumero(numero);

        System.out.println("Digite o saldo inicial da conta: ");
        double saldoInicial = sc.nextDouble();
        this.depositar(saldoInicial);

        this.setLimite(10000);

        System.out.println("Conta atualizada com sucesso!");

        totalContas++;

        System.out.println("Nome: " + this.getNome() + "\n"
                + "Saldo: " + this.getSaldo() + "\n"
                + "Numero: " + this.getNumero() + "\n"
                + "Limite: " + this.getLimite());

        sc.nextLine();
    }

    public void setLimite(double valor) {
        if (valor > 0) {
            this.limite = valor;
        }
    }

    public void setNome(String texto) {
        this.nome = texto;
    }

    boolean depositar(double valor) {
        if(valor > 0.0) {
            this.saldo += valor;
            this.ops++;
            this.operacoes[this.ops] = new Operacao('d', valor);
            return true;
        } else {
            System.out.println("Valor invalido");
            return false;
        }
    }


    boolean sacar(double valor) {
        if(valor > 0.0 && valor <= this.saldo) {
            this.saldo -= valor;
            this.ops++;
            this.operacoes[this.ops] = new Operacao('s', valor);
            return true;
        } else {
            System.out.println("Saldo insuficiente");
            return false;
        }
    }


    boolean transferir(Conta contaDestino, double valor) {
        boolean saqueRealizado = this.sacar(valor);
        if(saqueRealizado) {
            boolean depositoRealizado = contaDestino.depositar(valor);
            return depositoRealizado;
        } else {
            return false;
        }
    }

    String getNome(){
        return this.nome;
    }

    int getNumero(){
        return this.numero;
    }

    double getSaldo(){
        return this.saldo;
    }

    double getLimite(){
        return this.limite;
    }


    void imprimirExtrato(){
        for (int i = 1; i <= this.ops; i++) {
            System.out.println(this.operacoes[i].getData() + "\t" + this.operacoes[i].getTipo() + "\t" + this.operacoes[i].getValor());
        }
    }
}
