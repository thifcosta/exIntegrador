import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;

import static java.lang.Integer.getInteger;
import static java.lang.Integer.parseInt;

public class Catalogo {

    private Map<String, Livro> estoque;

    public Catalogo(){
        estoque = new HashMap<>();
        Livro livro01 = new Livro("001", "A Cinco Passos De Você", "Rachael Lippincott", 2019, "9788525067425", 35, 23.9F);
        Livro livro02 = new Livro("002", "A Garota do Lago", "Charlie Donlea", 2017, "9788562409882", 26, 11.9F);
        Livro livro03 = new Livro("003", "Eleanor & Park", "Rainbow Rowell", 2014, "9788542810394", 8, 9.9F);
        Livro livro04 = new Livro("004", "After", "Anna Todd", 2019, "9788584391370", 43, 35.9F);
        Livro livro05 = new Livro("005", "Trono De Vidro", "Sarah J. Maas", 2019, "9788501116307", 57, 79.9F);
        Livro livro06 = new Livro("006", "Admirável Mundo Novo", "Aldous Leonard Huxley", 2014, "9788525056009", 32, 27.9F);
        Livro livro07 = new Livro("007", "Um Casamento Conveniente", "Tessa Dare", 2019, "9788582355831", 106, 39.8F);
        Livro livro08 = new Livro("008", "1984", "George Orwell", 2009, "9788535914849", 27, 57.9F);
        Livro livro09 = new Livro("009", "O Diário de Anne Frank", "Anne Frank", 1995, "8501044458", 92, 31.9F);
        Livro livro10 = new Livro("010", "Os Miseráveis", "Victor Hugo", 2014, "9788544000007", 61, 56.9F);

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

    public Map<String, Map<String, Livro>> colecoes = new HashMap<>();
    public Map<String, Livro> curMap = null;

    ////////// Método para formatar os valores em R$ dos livros em duas casas decimais;
    DecimalFormat numberFormat = new DecimalFormat("#.00");

    ////////// Método para consultar o mapa estoque e apresentar o objeto livro através do seu código;
    public void consultarLivroPorCodigo(String codigo){
        Livro consultaAtual = estoque.get(codigo);
        System.out.println("\n****************************************\n");
        System.out.println("Código: "+consultaAtual.getCodigo());
        System.out.println("Título: "+consultaAtual.getTitulo()+"\n" +
                "Autor: "+consultaAtual.getAutor()+"\n" +
                "Ano de Lançamento: "+consultaAtual.getAnoLancamento()+"\n" +
                "ISBN: "+consultaAtual.getIsbn()+"\n" +
                "Quantidade em Estoque: "+consultaAtual.getQtdEstoque()+"\n" +
                "Preço: R$ "+numberFormat.format(consultaAtual.getPreco()).toString()+"\n\n" +
                "****************************************");
    }

    public String centralizarTitulo(String nomeDaLista, int spcAmt){
        String spc = "";
        for(int i=0; i<spcAmt;i++){
            spc = spc+" ";
        }
        String linhaDeTitulo;
        String subSpc = spc.substring(0,spc.length()-(nomeDaLista.length()/2));
        boolean divisaoIgual = false;

        if(nomeDaLista.length()%2==0){
            divisaoIgual=true;
        }

        if(divisaoIgual){
            linhaDeTitulo = "|"+subSpc+nomeDaLista+subSpc+"|";
            return linhaDeTitulo;
        }else{
            linhaDeTitulo = "|"+subSpc.substring(0,subSpc.length()-1)+nomeDaLista+subSpc+"|";
            return linhaDeTitulo;
        }
    }

    ////////// Teste de formatação de texto, para apresentar as informações de forma visualmente mais agradável,
    public void listaDeLivros(String nomeDaLista, boolean tOrF){
        String startEnd =     "+--------------------------------------------------------------------------------------------------------------------------------------------------+";
        String space =        "|                                                                                                                                                  |";
        String spaceLine =    "|--------------------------------------------------------------------------------------------------------------------------------------------------|";
        String spaceLineDiv = "|--------------------|--------------------|--------------------|--------------------|--------------------|--------------------|--------------------|";
        String categories =   "|CÓDIGO              |TÍTULO              |AUTOR               |LANÇAMENTO          |ISBN                |ESTOQUE             |PREÇO               |";

        System.out.println(startEnd+"\n"+
                space+"\n"+
                centralizarTitulo(nomeDaLista, 73)+"\n"+
                space+"\n"+
                spaceLine+"\n"+
                categories+"\n"+
                spaceLineDiv);
        if(tOrF){
            for (String code :estoque.keySet()){
                Livro livro = estoque.get(code);
                catalogoFormatado(livro);
            }
        }else{
            for (String code :curMap.keySet()){
                Livro livro = curMap.get(code);
                catalogoFormatado(livro);
            }
        }

        System.out.println(startEnd);
    }

    ////////// Método usado em listaDeLivros(), para puxar as informações de cada livro e apresentá-las em uma linha, com espaçamento e formatação correta;
    public void catalogoFormatado(Livro liv){
        List<String> listaDeAtributos = new ArrayList<>();

        String codigo = liv.getCodigo();
        String titulo = liv.getTitulo();
        String autor = liv.getAutor();
        String anoLancamento = liv.getAnoLancamento().toString();
        String isbn = liv.getIsbn();
        String qtdEstoque = liv.getQtdEstoque().toString();
        String preco = "R$ "+ numberFormat.format(liv.getPreco()).toString();

        listaDeAtributos.add(codigo);
        listaDeAtributos.add(titulo);
        listaDeAtributos.add(autor);
        listaDeAtributos.add(anoLancamento);
        listaDeAtributos.add(isbn);
        listaDeAtributos.add(qtdEstoque);
        listaDeAtributos.add(preco);

        String linhaFormatada = "";

        for (String string :listaDeAtributos){
            if(string.length()>17){
                string = string.substring(0,17)+"...";
            } else {
                int theLen = 20-(string.length());
                for(int i = 0; i<theLen; i++){
                    string = string+" ";
                }
            }
            string = string+"|";
            linhaFormatada = linhaFormatada+string;
        }

        System.out.println("|"+linhaFormatada);

    }

    ////////// Método usado em userCadastrarLivro(), para criar um novo scanner que recebe uma String e validar se não está em branco;
    private String validString(String userInput){
        Scanner scn = new Scanner (System.in);
        String theStr = scn.nextLine().trim();
        while(theStr.length()==0){
            System.out.println("O campo \""+userInput+"\" não deve ficar em branco. Digite novamente:");
            theStr = scn.nextLine().trim();
        }
        return theStr;
    }

    ////////// Método usado em userCadastrarLivro(), para criar um novo scanner que recebe um Integer e validar se não está em branco;
    private Integer validInt(String userInput) {
        boolean isParse = false;
        String str = "";
        while (!isParse) {
            str = validString(userInput);
            try {
                Integer.parseInt(str);
                isParse = true;
            } catch (Exception e) {
                System.out.println("O campo \"" + userInput + "\" não aceita texto e só recebe números inteiros. Digite novamente:");
            }
        }
        return Integer.parseInt(str);
    }

    ////////// Método usado em userCadastrarLivro(), para criar um novo scanner que recebe um Float e validar se não está em branco;
    private float validFloat(String userInput) {
        boolean isParse = false;
        String str = "";
        while (!isParse) {
            str = validString(userInput);
            try {
                Float.parseFloat(str);
                isParse = true;
            } catch (Exception e) {
                System.out.println("O campo \"" + userInput + "\" só recebe números.\nObs: Para valores quebrados, use o ponto (exemplo: \"29.90\").\nDigite novamente:");
            }
        }
        return Float.parseFloat(str);
    }

    ////////// Método utilizado para pedir ao usuário informações em sequência, para criar um novo livro e adicioná-lo ao mapa estoque;
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
        codigo = validString("Código");
        for (String code : estoque.keySet()){
            while(codigo.equals(code)) {
                System.out.println("Código já existente. Digite um código único:");
                codigo = validString("Código");
            }
        }
        System.out.println("Digite o título do Livro:");
        titulo = validString("Título");
        System.out.println("Digite o nome do Autor:");
        autor = validString("Autor");
        System.out.println("Digite o ano de lançameto:");
        anoLancamento = validInt("Ano de Lançamento");
        System.out.println("Digite o ISBN:");
        isbn = validString("ISBN");
        System.out.println("Qual a quantidade deste novo livro em estoque?");
        qtdEstoque = validInt("Quantidade de Estoque");
        System.out.println("Qual o preço deste livro?");
        preco = validFloat("Preço");

        Livro criarLivro = new Livro(codigo, titulo, autor, anoLancamento, isbn, qtdEstoque, preco);
        estoque.put(criarLivro.getCodigo(), criarLivro);

        System.out.println("\n\n**** LIVRO CADASTRADO COM SUCESSO!! ****\n");
        System.out.println("Confira abaixo as informações:");
        consultarLivroPorCodigo(criarLivro.getCodigo());
    }

    ////////// Método utilizado para pedir um código ao usuário e apresentar as informações do livro correspondente;
    public void userConsultarLivroPorCodigo(){
        System.out.println("Para fazer uma nova busca, digite o código do livro:");
        String codigo;
        Livro livro = null;
        Scanner scn = new Scanner (System.in);

        while (livro == null) {
            codigo = scn.nextLine();
            livro = estoque.get(codigo);
            if (livro == null) {
                System.out.println("Este código não existe. Digite novamente: ");
            } else {
                consultarLivroPorCodigo(livro.getCodigo());
            }
        }
    }

    ////////// Método usado para efetuar vendas, confirmando a quantidade, valor e alterando o estoque;
    public void userEfetuarVendaPorCodigo(){

        Scanner scn = new Scanner( System.in );
        Livro livro = null;
        Integer temosEstoque = null;

        System.out.println("Digite o código do livro que deseja vender: ");

        while (livro == null) {
            String codigo = scn.nextLine();
            livro = estoque.get(codigo);
            if (livro == null) {
                System.out.println("Este código não existe. Digite novamente: ");
            } else {
                Integer estoqueAtual = livro.getQtdEstoque();
                System.out.println("\nO livro selecionado foi:\n\n****************************************\nTítulo: "+livro.getTitulo()+";\nAutor : "+livro.getAutor()+".\n****************************************\n");
                System.out.println("Temos "+livro.getQtdEstoque()+" unidades deste livro em estoque.\nQuantas unidades serão vendidas?");
                Integer vendaAtual = scn.nextInt();
                while (estoqueAtual < vendaAtual) {
                    System.out.println("Temos apenas " + livro.getQtdEstoque() + " unidades deste livro :(\nDigite uma nova quantidade:");
                    vendaAtual = scn.nextInt();
                }

                System.out.println("\nO total da venda será de:\nR$ "+numberFormat.format(vendaAtual*livro.getPreco()).toString()+"\n\nPara confirmar digite \"1\", cancelar digite \"2\":");
                boolean validate = false;
                while(!validate){
                    String resp = scn.next();
                    switch(resp){
                        case "1":
                            livro.setQtdEstoque(estoqueAtual - vendaAtual);
                            System.out.println("****************************************\n\nVENDA EFETUADA COM SUCESSO!\nConfira abaixo as informações atualizadas:");
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

    ////////// Método usado para criar uma nova coleção, com interação do usuário;
    public void novaColecao(){
        System.out.println("Vamos criar uma nova coleção!\nDigite um nome único:");
        String nomeDaColecao = validString("Nome da Coleção");
        for (String code : colecoes.keySet()){
            while(nomeDaColecao.equals(code)) {
                System.out.println("Esta coleção já existe. Digite um nome único:");
                nomeDaColecao = validString("Nome da Coleção");
            }
        }
        System.out.println("Digite agora os códigos dos livros, separados por vírgula:");
        String codigos = validString("Códigos dos Livros");
        String[] array = codigos.split(",", -1);
        boolean todosCodigosValidos = false;
        List<String> invalidos = null;
        List<String> validos = null;
        while(!todosCodigosValidos){
            invalidos = new ArrayList<>();
            validos = new ArrayList<>();
            for(int i=0; i<array.length; i++){
                array[i] = array[i].trim();
                Livro livSel = estoque.get(array[i]);
                if(livSel == null){
                    invalidos.add(array[i]);
                }else{
                    validos.add(array[i]);
                }
            }
            if(invalidos.isEmpty()){
                if(validos.size()>=2) {
                    todosCodigosValidos = true;
                }else{
                    System.out.println("Não é possível criar uma coleção com apenas um livro.\nDigite dois ou mais gódigos, separados por vírgula:");
                    codigos = validString("Códigos dos Livros");
                    array = codigos.split(",", -1);
                }
            }else{
                System.out.println("Os códigos \""+invalidos.toString()+"\" não foram encontrados no sistema.");
                System.out.println("Certifique-se que esteja digitando-os corretamente.");
                System.out.println("\nVamos tentar novamente. Digite os códigos dos livros, separados por vírgula:");
                codigos = validString("Códigos dos Livros");
                array = codigos.split(",", -1);
            }
        }

        Map<String, Livro> novaColecao = new HashMap<>();
        for(int i=0;i<validos.size();i++){
            Livro curLiv = estoque.get(validos.get(i));
            novaColecao.put(curLiv.getCodigo(), curLiv);
        }
        colecoes.put(nomeDaColecao, novaColecao);
        System.out.println("\n\n***** COLEÇÃO CRIADA COM SUCESSO!! *****\n");
        System.out.println("Confira abaixo as informações:");
        infosDaColecao(nomeDaColecao);
    }

    ////////// Método usado para que o usuário possa buscar uma coleção;
    public void userBuscarColecao(){
        System.out.println("Digite o nome da coleção que está procurando:");
        String colName = validString("Buscar Coleção");
        Map<String, Livro> curCol = null;
        while(curCol == null){
            curCol = colecoes.get(colName);
            if (curCol == null) {
                System.out.println("Este código não existe. Digite novamente: ");
                colName = validString("Buscar Coleção");;
            }
        }
        infosDaColecao(colName);
    }

    ////////// Método usado para mostrar as infos de uma coleção já existente;
    public void infosDaColecao(String nomeDaColecao){
        String startEnd = "+--------------------------------------------------------------------------------------------------------------------------------------------------+";
        curMap = colecoes.get(nomeDaColecao);
        float vt = 0;
        for (String code : curMap.keySet()){
            vt = vt+curMap.get(code).getPreco();
        }
        listaDeLivros("COLEÇÃO: "+nomeDaColecao, false);
        curMap = estoque;
        String valorTotal = "VALOR TOTAL: R$ "+numberFormat.format(vt);
        valorTotal = centralizarTitulo(valorTotal, 73);
        System.out.println(valorTotal+"\n"+startEnd);
    }

    ////////// Método usado para mostrar as infos de todas as coleções;
    public void todasColecoes(){
        String startEnd =     "+-----------------------------------------------------------------------------------+";
        String space =        "|                                                                                   |";
        String spaceLine =    "|-----------------------------------------------------------------------------------|";
        String spaceLineDiv = "|--------------------|--------------------|--------------------|--------------------|";
        String categories =   "|NOME                |QTD DE LIVROS       |DISPONÍVEL P/ VENDA |VALOR TOTAL         |";
        String titulo = centralizarTitulo("COLEÇÕES EM ESTOQUE ", 42);
        titulo = "|"+titulo.substring(2);

        String nome = "";
        float valorTotal;
        Integer qtdLivros;
        Integer dispPVenda;

        System.out.println("\n"+startEnd+"\n"+space+"\n"+titulo+"\n"+space+"\n"+spaceLineDiv+"\n"+categories+"\n"+spaceLineDiv);

        for (String code : colecoes.keySet()){
            qtdLivros = 0;
            dispPVenda = 0;
            valorTotal = 0;
            boolean semEstoque = false;
            Map<String, Livro> curCollect = colecoes.get(code);
            nome = code;
            for(String codeIn : curCollect.keySet()){
                Livro curLiv = curMap.get(codeIn);
                qtdLivros = qtdLivros+1;
                valorTotal = valorTotal+curLiv.getPreco();
                Integer qtDisp = curLiv.getQtdEstoque();
                if(dispPVenda == 0 || dispPVenda>qtDisp) {
                    dispPVenda = qtDisp;
                }
                if(qtDisp==0){
                    semEstoque=true;
                }
            }

            if(semEstoque){
                dispPVenda=0;
            }

            List<String> listaDeAtributos = new ArrayList<>();
            listaDeAtributos.add(nome);
            listaDeAtributos.add(qtdLivros.toString());
            listaDeAtributos.add(dispPVenda.toString());
            listaDeAtributos.add("R$ "+ numberFormat.format(valorTotal));
            String linhaFormatada = "";
            for (String string :listaDeAtributos){
                if(string.length()>17){
                    string = string.substring(0,17)+"...";
                } else {
                    int theLen = 20-(string.length());
                    for(int i = 0; i<theLen; i++){
                        string = string+" ";
                    }
                }
                string = string+"|";
                linhaFormatada = linhaFormatada+string;
            }
            System.out.println("|"+linhaFormatada);
        }
        System.out.println(startEnd);
        System.out.println("\nObs: o ítem \"DISPONÍVEL P/ VENDA\" compara as unidades disponíveis de cada livro das coleções,\n"+
                "informando quantas coleções COMPLETAS estão disponíveis em estoque.");
    }
}
