package produtos;

public class Vestuario extends Produto {
    // Atributos específicos de Vestuario
    private String tamanho;

    // Construtor
    public Vestuario(String codigo, String nome, double preco, int quantidade, String tamanho) {
        super(codigo, nome, preco, quantidade);
        this.tamanho = tamanho;
    }

    // Método para exibir informações do vestuário
    @Override
    public void exibirInformacoes() {
        System.out.println("Tipo: Vestuário");
        System.out.println("Tamanho: " + tamanho);
    }
}