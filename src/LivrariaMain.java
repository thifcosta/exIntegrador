import java.util.Scanner;

public class LivrariaMain {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();

        boolean sair = false;
        boolean menuSecreto = false;

        System.out.println("BEM VINDO AO SISTEMA!");

        while(!sair){
            Scanner scn = new Scanner(System.in);
            showMenu(menuSecreto);
            String opt = scn.next();
            opt = opt.trim().toLowerCase();
            switch(opt){
                case "1":
                    catalogo.listaDeLivros("LISTA COMPLETA DE ESTOQUE", true);
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
                    catalogo.novaColecao();
                    if(!menuSecreto){
                        menuSecreto=true;
                        System.out.println("\n\n"+
                                "            ★.＼｜／.★            ★.＼｜／.★            ★.＼｜／.★            \n"+
                                "******************************************************************************\n"+
                                "           PARABÉNS, VOCÊ DESBLOQUEOU O MENU SECRETO DAS COLEÇÕES!!           \n" +
                                "******************************************************************************\n" +
                                "            ★.／｜＼.★            ★.／｜＼.★            ★.／｜＼.★            \n\n" +
                                "A partir de agora você pode utilizar os números de 6 e 7 no menu principal!");
                    }else {
                        System.out.println("\n\nPosso ajudar em algo mais?");
                    }
                    break;
                case "6":
                    if(menuSecreto) {
                        catalogo.todasColecoes();
                        System.out.println("\n\nPosso ajudar em algo mais?");
                    }else{
                        System.out.println("Este é um ítem secreto! :)\nContinue procurando no sistema até conseguir desbloqueá-lo.\n");
                        System.out.println("\n\nPosso ajudar em algo mais?");
                    }
                    break;
                case "7":
                    if(menuSecreto) {
                        catalogo.userBuscarColecao();
                    }else{
                        System.out.println("Este é um ítem secreto! :)\nContinue procurando no sistema até conseguir desbloqueá-lo.\n");
                        System.out.println("\n\nPosso ajudar em algo mais?");
                    }
                    break;
                case "sair":
                    System.out.println("Obrigado pela visita! Até a próxima!");
                    sair = true;
                    break;
                default:
                    System.out.println("Digite apenas as opções do Menu:");
            }
        }
    }

    public static void showMenu(boolean tOrF){
        String sair = "\nDigite \"Sair\" para fechar o programa.";
        String normal = "\nMENU PRINCIPAL:\n" +
                "Digite \"1\" para exibir a lista completa de estoque;\n" +
                "Digite \"2\" para cadastrar um novo livro;\n" +
                "Digite \"3\" para buscar um livro pelo código;\n" +
                "Digite \"4\" para efetuar uma venda pelo código;\n" +
                "Digite \"5\" para criar uma nova coleção.";
        String secreto = "\n\n>>>> MENU DE COLEÇÕES: <<<<\n"+
                "Digite \"6\" para exibir todas as coleções;\n" +
                "Digite \"7\" buscar uma coleção pelo nome.";

        if(tOrF){
            System.out.println(normal+secreto+sair);
        }else {
            System.out.println(normal+sair);
        }
    }
}
