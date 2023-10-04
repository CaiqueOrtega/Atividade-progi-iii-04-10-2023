package br.edu.umfg.estrategia;

public class MeioPagamentoCieloDebitoEstrategia extends MeioPagamentoCieloEstrategia{

    public MeioPagamentoCieloDebitoEstrategia(String numeroCartao, String cpf, String cvv, String dataValidade) throws Exception {
        super(numeroCartao, cpf, cvv, dataValidade);


    }
    @Override
    public void pagar(Double valor) {
        System.out.printf("Pagamento via Cielo Debito no valor: " +
                valor + ", realizado com sucesso \n");
    }

}
