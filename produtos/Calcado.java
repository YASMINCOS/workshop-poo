package produtos;
public class Calcado extends Produto {
    // Atributos específicos de Calcado
    private int numero;

    // Construtor
    public Calcado(String codigo, String nome, double preco, int quantidade, int numero) {
        super(codigo, nome, preco, quantidade);
        this.numero = numero;
    }

    // Método para exibir informações do calçado
    @Override
    public void exibirInformacoes() {
        System.out.println("Tipo: Calçado");
        System.out.println("Código: " + getCodigo());
        System.out.println("Nome: " + getNome());
        System.out.println("Preço: " + getPreco());
        System.out.println("Quantidade: " + getQuantidade());
        System.out.println("Número: " + numero);
    }
}
