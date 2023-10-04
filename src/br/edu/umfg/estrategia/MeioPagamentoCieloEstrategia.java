package br.edu.umfg.estrategia;

import java.util.Calendar;

public abstract class MeioPagamentoCieloEstrategia implements
        MeioPagamentoEstrategia{

    private String numeroCartao;
    private String cpf;
    private String cvv;
    private String dataValidade;

    public MeioPagamentoCieloEstrategia(String numeroCartao,
                                        String cpf, String cvv,
                                        String dataValidade) {

        setNumeroCartao(numeroCartao);
        setCvv(cvv);
        setDataValidade(dataValidade);
        setCPF(cpf);
    }

    public void setNumeroCartao(String numeroCartao) {
        if (!numeroCartao.matches("^[0-9]{16}$")) {
            throw new IllegalArgumentException("Número do cartão  inválido");
        }else
            this.numeroCartao = numeroCartao;
    }

    public void setCvv(String cvv) {
        if (!cvv.matches("^[0-9]{3}$")) {
            throw new IllegalArgumentException("Número do CVV é inválido");
        }else
            this.cvv = cvv;
    }

    public void  setDataValidade(String dataValidade) {

        if (!dataValidade.matches("[0-9]{2}[/][0-9]{2}")) {
            throw new IllegalArgumentException("Data Invalida");
        }

        int mes = Integer.parseInt(dataValidade.substring(0, 2));
        int ano = Integer.parseInt(dataValidade.substring(3));

        Calendar dataVigente = Calendar.getInstance();
        int mesVigente = dataVigente.get(Calendar.MONTH) + 1;
        int anoVigente = dataVigente.get(Calendar.YEAR);


        if (mes > mesVigente || (mes == mesVigente && ano > anoVigente)) {
            this.dataValidade = dataValidade;
        }



    }

    public void setCPF(String cpf) {

        if (!cpf.matches("[0-9]{11}")) {
            throw new IllegalArgumentException("CPF Invalido");
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (i + 1) * Integer.parseInt(cpf.substring(i, i + 1));
        }
        int resto = soma % 11;
        int primeiroDigitoVerificador = 11 - resto;

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (i + 2) * Integer.parseInt(cpf.substring(i, i + 1));
        }
        resto = soma % 11;
        int segundoDigitoVerificador = 11 - resto;


        if (primeiroDigitoVerificador == Integer.parseInt(cpf.substring(9, 10)) &&
                segundoDigitoVerificador == Integer.parseInt(cpf.substring(10, 11))) {
            this.cpf = cpf;


        }
    }

    @Override
    public void pagar(Double valor) {
        System.out.printf("Pagamento via Cielo no valor," +
                valor + ", realizado com sucesso \n");
    }
}
