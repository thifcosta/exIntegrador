import java.util.*;

public class Catalogo {

    private Map<String, Livro> estoque;

    public Catalogo(){
        estoque = new HashMap<>();
        Livro livro01 = new Livro("001", "Titulo 01", "Autor 01", 2001, "ISBN-01", 1, 1.5F);
        Livro livro02 = new Livro("002", "Titulo 02", "Autor 02", 2002, "ISBN-02", 2, 2.5F);
        Livro livro03 = new Livro("003", "Titulo 03", "Autor 03", 2003, "ISBN-03", 3, 3.5F);
        Livro livro04 = new Livro("004", "Titulo 04", "Autor 04", 2004, "ISBN-04", 4, 4.5F);
        Livro livro05 = new Livro("005", "Titulo 05", "Autor 05", 2005, "ISBN-05", 5, 5.5F);
        Livro livro06 = new Livro("006", "Titulo 06", "Autor 06", 2006, "ISBN-06", 6, 6.5F);
        Livro livro07 = new Livro("007", "Titulo 07", "Autor 07", 2007, "ISBN-07", 7, 7.5F);
        Livro livro08 = new Livro("008", "Titulo 08", "Autor 08", 2008, "ISBN-08", 8, 8.5F);
        Livro livro09 = new Livro("009", "Titulo 09", "Autor 09", 2009, "ISBN-09", 9, 9.5F);
        Livro livro10 = new Livro("010", "Titulo 10", "Autor 10", 2010, "ISBN-10", 10, 10.5F);

        estoque.put(livro01.getCodigo(), livro01);
        estoque.put(livro02.getCodigo(), livro02);
        estoque.put(livro03.getCodigo(), livro03);
        estoque.put(livro04.getCodigo(), livro04);
        estoque.put(livro05.getCodigo(), livro05);
        estoque.put(livro06.getCodigo(), livro06);
        estoque.put(livro07.getCodigo(), livro07);
        estoque.put(livro08.getCodigo(), livro08);
        estoque.put(livro09.getCodigo(), livro09);
        estoque.put(livro10.getCodigo(), livro10);
    }

    /////////////////////////////////////////////////////// MÉTODOS SEM INTERAÇÃO DO USUÁRIO

    public void cadastrarLivro(String codigo, String titulo, String autor, Integer anoLancamento, String isbn, Integer qtdEstoque, float preco){
        Livro criarLivro = new Livro(codigo, titulo, autor, anoLancamento, isbn, qtdEstoque, preco);
        estoque.put(criarLivro.getCodigo(), criarLivro);
    }

    public void consultarLivroPorCodigo(String codigo){
        Livro consultaAtual = estoque.get(codigo);
        System.out.println("\n****************************************\n");
        System.out.println("Código: "+consultaAtual.getCodigo());
        System.out.println("Título: "+consultaAtual.getTitulo()+"\n" +
                "Autor: "+consultaAtual.getAutor()+"\n" +
                "Ano de Lançamento: "+consultaAtual.getAnoLancamento()+"\n" +
                "ISBN: "+consultaAtual.getIsbn()+"\n" +
                "Quantidade em Estoque: "+consultaAtual.getQtdEstoque()+"\n" +
                "Preço: R$ "+consultaAtual.getPreco()+"\n\n" +
                "****************************************");
    }

    public void listaDeLivros(){

        System.out.println("|---------------|---------------|---------------|---------------|---------------|---------------|---------------|\n"+
                "|                                           LISTA COMPLETA DE ESTOQUE                                           |\n"+
                "|---------------|---------------|---------------|---------------|---------------|---------------|---------------|\n"+
                "|CÓDIGO         |TÍTULO         |AUTOR          |LANÇAMENTO     |ISBN           |ESTOQUE        |PREÇO          |\n"+
                "|---------------|---------------|---------------|---------------|---------------|---------------|---------------|");
        for (String code :estoque.keySet()){
            Livro livro = estoque.get(code);
            catalogoFormatado(livro);
        }
        System.out.println("|---------------|---------------|---------------|---------------|---------------|---------------|---------------|");

    }

    public void catalogoFormatado(Livro liv){

        List<String> listaDeAtributos = new ArrayList<>();

        String codigo = liv.getCodigo();
        String titulo = liv.getTitulo();
        String autor = liv.getAutor();
        String anoLancamento = liv.getAnoLancamento().toString();
        String isbn = liv.getIsbn();
        String qtdEstoque = liv.getQtdEstoque().toString();
        String preco = "R$ "+Float.toString(liv.getPreco());

        listaDeAtributos.add(codigo);
        listaDeAtributos.add(titulo);
        listaDeAtributos.add(autor);
        listaDeAtributos.add(anoLancamento);
        listaDeAtributos.add(isbn);
        listaDeAtributos.add(qtdEstoque);
        listaDeAtributos.add(preco);

        String linhaFormatada = "";

        for (String string :listaDeAtributos){
            if(string.length()>12){
                string = string.substring(0,12)+"...";
            } else {
                int theLen = 15-(string.length());
                for(int i = 0; i<theLen; i++){
                    string = string+" ";
                }
            }
            string = string+"|";
            linhaFormatada = linhaFormatada+string;
        }

        System.out.println("|"+linhaFormatada);

    }


    public void userCadastrarLivro(){
        String codigo;
        String titulo;
        String autor;
        int anoLancamento;
        String isbn;
        int qtdEstoque;
        float preco;

        Scanner scn = new Scanner( System.in );
        System.out.println("Vamos cadastrar um novo livro!\nDigite um novo código: ");
        codigo = scn.nextLine();

        for (String code : estoque.keySet()){
            while (codigo.equals(code)){
                System.out.println("Código já existente. Digite um código único:");
                codigo = scn.nextLine();
            }
        }

        System.out.println("Digite o título do Livro:");
        titulo = scn.nextLine();
        System.out.println("Digite o nome do Autor:");
        autor = scn.nextLine();
        System.out.println("Digite o ano de lançameto:");
        anoLancamento = scn.nextInt();
        System.out.println("Digite o ISBN:");
        isbn = scn.next();
        System.out.println("Qual a quantidade deste novo livro em estoque?");
        qtdEstoque = scn.nextInt();
        System.out.println("Qual o preço deste livro?");
        preco = scn.nextFloat();

        Livro criarLivro = new Livro(codigo, titulo, autor, anoLancamento, isbn, qtdEstoque, preco);
        estoque.put(criarLivro.getCodigo(), criarLivro);

        System.out.println("\n\n**** LIVRO CADASTRADO COM SUCESSO!! ****\n");
        System.out.println("Confira abaixo as informações:");
        consultarLivroPorCodigo(criarLivro.getCodigo());
    }

    public void userConsultarLivroPorCodigo(){
        System.out.println("Para fazer uma nova busca, digite o código do livro:");
        String codigo;
        Livro livro = null;
        Scanner scn = new Scanner (System.in);

        while (livro == null) {
            codigo = scn.next();
            livro = estoque.get(codigo);
            if (livro == null) {
                System.out.println("Este código não existe. Digite novamente: ");
            } else {
                System.out.println("****************************************\n");
                System.out.println("Resultado da busca:\n");
                System.out.println("Código: "+livro.getCodigo());
                System.out.println("Título: "+livro.getTitulo()+"\n" +
                        "Autor: "+livro.getAutor()+"\n" +
                        "Ano de Lançamento: "+livro.getAnoLancamento()+"\n" +
                        "ISBN: "+livro.getIsbn()+"\n" +
                        "Quantidade em Estoque: "+livro.getQtdEstoque()+"\n" +
                        "Preço: R$ "+livro.getPreco()+"\n\n" +
                        "****************************************");
            }
        }
    }

    public void userEfetuarVendaPorCodigo(){

        Scanner scn = new Scanner( System.in );
        Livro livro = null;
        Integer temosEstoque = null;

        System.out.println("Digite o código do livro que deseja vender: ");

        while (livro == null) {
            String codigo = scn.next();
            livro = estoque.get(codigo);
            if (livro == null) {
                System.out.println("Este código não existe. Digite novamente: ");
            } else {
                Integer estoqueAtual = livro.getQtdEstoque();
                System.out.println("O livro selecionado foi: "+livro.getTitulo()+", escrito por: "+livro.getAutor()+".");
                System.out.println("Temos "+livro.getQtdEstoque()+" unidades deste livro em estoque.\n");
                System.out.println("Quantas unidades serão vendidas?");
                Integer vendaAtual = scn.nextInt();
                while (estoqueAtual < vendaAtual) {
                    System.out.println("Temos apenas " + livro.getQtdEstoque() + " unidades deste livro :(\nDigite uma nova quantidade:");
                    vendaAtual = scn.nextInt();
                }

                System.out.println("O total da venda será de R$: "+vendaAtual*livro.getPreco()+"\nPara confirmar digite \"1\", cancelar digite \"2\":");
                boolean validate = false;
                while(!validate){
                    String resp = scn.next();
                    switch(resp){
                        case "1":
                            livro.setQtdEstoque(estoqueAtual - vendaAtual);
                            System.out.println("****************************************\n\nVENDA EFETUADA COM SUCESSO!\n\nConfira abaixo as informações atualizadas:");
                            consultarLivroPorCodigo(livro.getCodigo());
                            validate = true;
                            break;
                        case "2":
                            System.out.println("VENDA CANCELADA!\nNada mudou, o estoque continua igual.");
                            validate = true;
                            break;
                        default:
                            System.out.println("Digite apenas 1 ou 2:");
                            break;
                    }
                }


            }
        }
    }
}
