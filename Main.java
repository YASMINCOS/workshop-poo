import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lojas.Loja;
import produtos.Calcado;
import produtos.Produto;
import produtos.Vestuario;

public class Main {
    private static List<String> codigosExistentes = new ArrayList<>();

    public static void main(String[] args) {
        // Criando uma instância da loja
        Loja loja = new Loja();

        // Exemplo de instâncias de produtos com códigos sequenciais
        Produto calcado = new Calcado(gerarProximoCodigo(), "Tênis", 99.99, 20, 40);
        Produto vestuario = new Vestuario(gerarProximoCodigo(), "Camiseta", 29.99, 30, "M");

        // Adicionando produtos pré-definidos à loja
        loja.adicionarProduto(calcado);
        loja.adicionarProduto(vestuario);

        // Adicionando os códigos dos produtos pré-definidos à lista de códigos existentes
        codigosExistentes.add(calcado.getCodigo());
        codigosExistentes.add(vestuario.getCodigo());

        // Interagindo com o usuário
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Remover Produto");
            System.out.println("3. Listar Produtos");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após o número

            switch (opcao) {
                case 1:
                    // Gerar código sequencial para o novo produto
                    String codigo = gerarProximoCodigo();
                    System.out.println("Código gerado para o produto: " + codigo);
                    System.out.println("Digite o nome do produto:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o preço do produto:");
                    double preco = scanner.nextDouble();
                    System.out.println("Digite a quantidade do produto:");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha após o número

                    System.out.println("Escolha o tipo de produto:");
                    System.out.println("1. Vestuário");
                    System.out.println("2. Calçado");
                    int tipo = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha após o número
                    Produto novoProduto;

                    if (tipo == 1) {
                        System.out.println("Digite o tamanho do vestuário:");
                        String tamanho = scanner.nextLine();
                        novoProduto = new Vestuario(codigo, nome, preco, quantidade, tamanho);
                    } else if (tipo == 2) {
                        System.out.println("Digite o número do calçado:");
                        int numero = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha após o número
                        novoProduto = new Calcado(codigo, nome, preco, quantidade, numero);
                    } else {
                        System.out.println("Tipo de produto inválido.");
                        continue;
                    }
                    loja.adicionarProduto(novoProduto);
                    codigosExistentes.add(codigo);
                    break;
                case 2:
                    System.out.println("Digite o código do produto a ser removido:");
                    String codigoRemover = scanner.nextLine();
                    loja.removerProduto(codigoRemover);
                    codigosExistentes.remove(codigoRemover);
                    break;
                case 3:
                    System.out.println("Escolha o tipo de produto para listar:");
                    System.out.println("1. Vestuário");
                    System.out.println("2. Calçado");
                    int tipoListar = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha após o número

                    if (tipoListar == 1) {
                        loja.listarProdutosPorTipo(Vestuario.class);
                    } else if (tipoListar == 2) {
                        loja.listarProdutosPorTipo(Calcado.class);
                    } else {
                        System.out.println("Tipo de produto inválido.");
                    }
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }

    private static String gerarProximoCodigo() {
        int novoCodigo = codigosExistentes.size() + 1;
        return String.format("%03d", novoCodigo); // Formata com 3 dígitos, ex: 001, 002
    }
}
