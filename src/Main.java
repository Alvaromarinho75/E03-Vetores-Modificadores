public class Main {

    public static void main(String[] args) {
        Conta conta1 = new Conta();


        conta1.cliente.nome = "Alvaro";
        conta1.cliente.sexo = 'm';
        conta1.cliente.idade = 16;
        conta1.cliente.cpf = "123456786-00";
        conta1.cliente.endereco = "Sabara";
        conta1.agencia = "222-2";
        conta1.numero = 1234;
        conta1.saldo = 2000;
        conta1.limite = 10000;

        conta1.sacar(100);

        conta1.depositar(100);

        conta1.imprimir();
        conta1.imprimirExtrato();
    }
}
