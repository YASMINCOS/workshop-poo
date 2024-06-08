import java.util.Scanner;

import lojas.Loja;
import produtos.Calcado;
import produtos.Produto;
import produtos.Vestuario;

public class Main {
    public static void main(String[] args) {
        // Criando uma instância da loja
        Loja loja = new Loja();

        // Exemplo de instâncias de produtos
        Produto calcado = new Calcado("001", "Tênis", 99.99, 20, 40);
        Produto vestuario = new Vestuario("002", "Camiseta", 29.99, 30, "M");

        // Adicionando produtos pré-definidos à loja
        loja.adicionarProduto(calcado);
        loja.adicionarProduto(vestuario);

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
                    System.out.println("Digite o código do produto:");
                    String codigo = scanner.nextLine();
                    System.out.println("Digite o nome do produto:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o preço do produto:");
                    double preco = scanner.nextDouble();
                    System.out.println("Digite a quantidade do produto:");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha após o número

                    System.out.println("Escolha o tipo de produto (Calçado/Vestuário):");
                    String tipo = scanner.nextLine();
                    Produto novoProduto;
                    if (tipo.equalsIgnoreCase("Calçado")) {
                        System.out.println("Digite o número do calçado:");
                        int numero = scanner.nextInt();
                        novoProduto = new Calcado(codigo, nome, preco, quantidade, numero);
                    } else if (tipo.equalsIgnoreCase("Vestuário")) {
                        System.out.println("Digite o tamanho do vestuário:");
                        String tamanho = scanner.nextLine();
                        novoProduto = new Vestuario(codigo, nome, preco, quantidade, tamanho);
                    } else {
                        System.out.println("Tipo de produto inválido.");
                        continue;
                    }
                    loja.adicionarProduto(novoProduto);
                    break;
                case 2:
                    System.out.println("Digite o código do produto a ser removido:");
                    String codigoRemover = scanner.nextLine();
                    loja.removerProduto(codigoRemover);
                    break;
                case 3:
                    loja.listarProdutos();
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
}
