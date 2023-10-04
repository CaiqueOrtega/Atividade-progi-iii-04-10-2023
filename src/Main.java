import br.edu.umfg.estrategia.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        Produto produto1 = new Produto("0001",
                "Cola cola 350ml",3.59);
        Produto produto2 = new Produto("0002",
                "X-salada",15.99);
        Carrinho carrinho = new Carrinho();

        carrinho.adicionarProduto(produto1);
        carrinho.adicionarProduto(produto2);


        carrinho.pagar(new MeioPagamentoCieloDebitoEstrategia("1111111111111111", "10623957995", "123", "07/24"));
        carrinho.pagar(new MeioPagamentoCieloCreditoEstrategia("2222222222222222", "11785712977", "123", "09/25"));

        carrinho.pagar(new MeioPagamentoDinheiroEstrategia());
    }
}