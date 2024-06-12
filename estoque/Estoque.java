package estoque;

import produtos.Produto;

public interface Estoque {
    void adicionarProduto(Produto produto);
    void removerProduto(String codigo);
    void listarProdutosPorTipo(Class<?> tipoProduto);
}
