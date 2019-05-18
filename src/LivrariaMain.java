import java.util.Scanner;

public class LivrariaMain {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();

        boolean sair = false;
        System.out.println("BEM VINDO AO SISTEMA!");

        while(!sair){
            Scanner scn = new Scanner(System.in);
            System.out.println("\nDigite \"1\" para exibir a lista completa de estoque;\n"+
                    "Digite \"2\" para cadastrar um novo livro;\n"+
                    "Digite \"3\" para buscar um livro pelo código;\n"+
                    "Digite \"4\" para efetuar uma venda pelo código.\n"+
                    "Digite \"5\" para fechar o programa.\n");

            String opt = scn.next();
            switch(opt){
                case "1":
                    catalogo.listaDeLivros();
                    System.out.println("\n\nPosso ajudar em algo mais?");
                    break;
                case "2":
                    catalogo.userCadastrarLivro();
                    System.out.println("\n\nPosso ajudar em algo mais?");
                    break;
                case "3":
                    catalogo.userConsultarLivroPorCodigo();
                    System.out.println("\n\nPosso ajudar em algo mais?");
                    break;
                case "4":
                    catalogo.userEfetuarVendaPorCodigo();
                    System.out.println("\n\nPosso ajudar em algo mais?");
                    break;
                case "5":
                    System.out.println("Obrigado pela visita! Até a próxima!");
                    sair = true;
                    break;
                default:
                    System.out.println("Digite apenas os números de 1 a 5:");
            }
        }
    }
}
