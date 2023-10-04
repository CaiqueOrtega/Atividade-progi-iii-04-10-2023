package br.edu.umfg.estrategia;

public class MeioPagamentoCieloCreditoEstrategia extends MeioPagamentoCieloEstrategia{
    public MeioPagamentoCieloCreditoEstrategia(String numeroCartao, String cpf, String cvv, String dataValidade)  {
        super(numeroCartao, cpf, cvv, dataValidade);

    }

    @Override
    public void pagar(Double valor) {
        System.out.printf("Pagamento via Cielo Credito no valor: " +
                valor + ", realizado com sucesso \n");
    }

}
