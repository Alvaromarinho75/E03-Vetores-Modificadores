public class Main {

    public static void main(String[] args) {
        Conta conta1 = new Conta();


        conta1.setNome("Alvaro");
        conta1.setNumero(1234);
        conta1.depositar(2000);
        conta1.setLimite(10000);

        conta1.sacar(100);

        conta1.depositar(100);

        System.out.println("Nome: " + conta1.getNome() + "\n"
                + "Saldo: " + conta1.getSaldo() + "\n"
                + "Numero: " + conta1.getNumero() + "\n"
                + "Limite: " + conta1.getLimite());


        conta1.imprimirExtrato();
    }
}
