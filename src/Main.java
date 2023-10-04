import br.edu.umfg.estrategia.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Produto("0001",
                "Cola cola 350ml",3.59);
        Produto produto2 = new Produto("0002",
                "X-salada",15.99);
        Carrinho carrinho = new Carrinho();

        carrinho.adicionarProduto(produto1);
        carrinho.adicionarProduto(produto2);

        //carrinho.pagar(new MeioPagamentoCieloEstrategia("0202", "785247893", "699", "10/2032" ));
        carrinho.pagar(new MeioPagamentoCieloDebitoEstrategia("1234567891234567", "12203063980", "123", "07/24"));
        carrinho.pagar(new MeioPagamentoCieloCreditoEstrategia("1234567891234567", "12203063980", "123", "09/21"));

        carrinho.pagar(new MeioPagamentoDinheiroEstrategia());
    }
}