package lojas;
import java.util.ArrayList;
import java.util.List;
import produtos.Produto;
import estoque.Estoque; 

public class Loja implements Estoque {
    private List<Produto> estoque;

    public Loja() {
        this.estoque = new ArrayList<>();
    }

    @Override
    public void adicionarProduto(Produto produto) {
        estoque.add(produto);
        System.out.println("Produto adicionado ao estoque: " + produto.getNome());
    }

    @Override
    public void removerProduto(String codigo) {
        Produto produtoRemover = null;
        for (Produto produto : estoque) {
            if (produto.getCodigo().equals(codigo)) {
                produtoRemover = produto;
                break;
            }
        }
        if (produtoRemover != null) {
            estoque.remove(produtoRemover);
            System.out.println("Produto removido do estoque: " + codigo);
        } else {
            System.out.println("Produto não encontrado no estoque: " + codigo);
        }
    }

    @Override
    public void listarProdutosPorTipo(Class<?> tipoProduto) {
        System.out.println("Produtos do tipo " + tipoProduto.getSimpleName() + " em estoque:");
        for (Produto produto : estoque) {
            if (tipoProduto.isInstance(produto)) {
                produto.exibirInformacoes();
                System.out.println("-----------------------");
            }
        }
    }
}
