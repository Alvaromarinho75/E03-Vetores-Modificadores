public class Conta {

    Operacao[] operacoes = new Operacao[1000];
    Cliente cliente = new Cliente();
    double saldo;
    int ops = 0;
    int numero;
    double limite;
    String agencia;


    boolean depositar(double valor) {
        if(valor > 0.0) {
            this.saldo += valor;
            this.ops++;
            this.operacoes[this.ops] = new Operacao('d', valor);
            return true;
        } else {
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

    void imprimir(){
        System.out.println("Nome: " + this.cliente.nome);
        System.out.println("Cpf: " + this.cliente.cpf);
        System.out.println("Numero: " + this.numero);
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Limite: " + this.limite);
        System.out.println("Endereço: " + this.cliente.endereco);
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Numero de operacoes :" + this.ops);
    }

    void imprimirExtrato(){
        for (int i = 1; i <= this.ops; i++) {
            System.out.println("Operacao " + i + ":");
            System.out.println("Data: " + this.operacoes[i].data);
            System.out.println("Tipo: " + this.operacoes[i].tipo);
            System.out.println("Valor: " + this.operacoes[i].valor);
        }
    }
}
