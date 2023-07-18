import java.time.LocalDate;
import java.util.*;

public class ComparacaoDeDados {

    /*Nesse exercício encontrei mais dificuldade de executar do que os outros, a maior dificuldade foi conseguir comparar
      os dados com métodos do LocalDate, que aprendi a utilizar no deocorrer do código.

      Outra dificuldade foi conseguir fazer uma pesquisa na Tabela sem ter um parâmetro, acabou que com o negar do usuario
      em adicionar uma data, foi definido uma data padrão

      No código foi utilizado uma Classe para a construção dos Objetos Tabela, para simular linhas de uma tabela*/

    // PARA AGILIZAR O TESTE DO CÓDIGO ADICIONEI DUAS DATAS PADRÃO, APERTE 2 E NEGUE A PESQUISA POR DATA, ELE ADICIONARÁ A DATA PADRÃO.

    static List<Tabela> tabela = new ArrayList<>(); //Criando lista do tipo Tabela
    static List<Tabela> dadosEncontrados = new ArrayList<>(); //Lista para armazenar dados da busca

    static int anoInicio, mesInicio, diaInicio, anoFinal, mesFinal, diaFinal; //Variáveis das datas do usuário
    static LocalDate dataInicio;
    static LocalDate dataFim;

    public static void main(String[] args) {

        //Populando a lista tabela
        addDados();

        //Capturando dados do usuário
        capturarDados();

        dataInicio = LocalDate.of(anoInicio, mesInicio, diaInicio);
        dataFim = LocalDate.of(anoFinal, mesFinal, diaFinal);

        //Pesquisando as datas na tabela e printando
        pesquisaData(dataInicio, dataFim);

    }

    static void addDados() { // Criando novos objetos do tipo tabela e os adicionando na lista tabela.
        tabela.add(new Tabela(1, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 12, 31)));
        tabela.add(new Tabela(2, LocalDate.of(2023, 10, 15), LocalDate.of(2024, 2, 15)));
        tabela.add(new Tabela(3, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 6, 30)));
        tabela.add(new Tabela(4, LocalDate.of(2024, 8, 15), LocalDate.of(2024, 12, 31)));
    }

    static void capturarDados() { //Capturando dados do usuário - Fazemos algumas conferências
        Scanner sc = new Scanner(System.in); //Scanner para capturar os dados

        int confirma;

        System.out.print("\nGostaria de pesquisar com uma data inicial? (1 - Sim   2 - Não)\nEscolha: ");
        confirma = sc.nextInt();

        if (confirma == 1) { //Caso o usuário opte por escolher uma data, será redirecionado:

            System.out.println("\n ------- Data Inicial da Consulta ------- ");
            System.out.print("Dia Início: ");
            diaInicio = sc.nextInt();
            System.out.print("Mês Início: ");
            mesInicio = sc.nextInt();

            while (anoInicio < 2020) { //O ano precisa ser maior que 2020
                System.out.print("Ano Início (Precisa ser maior que 2020): ");
                anoInicio = sc.nextInt();
            }

        } else { //Caso o usuário não queria inserir uma data, colocamos uma data padrão: 05/08/2023
            diaInicio = 5;
            mesInicio = 8;
            anoInicio = 2023;
            System.out.println("A data inicial padrão foi definida como: " + diaInicio + "/" + mesInicio + "/" + anoInicio);
        }

        System.out.print("\nGostaria de pesquisar com uma data final? 1 - Sim --- 2 - Não\nEscolha: ");
        confirma = 0;
        confirma = sc.nextInt();

        if (confirma == 1) { //Caso o usuário opte por escolher uma data, será redirecionado:
            System.out.println("\n ------- Data Final da Consulta ------- ");
            System.out.print("Dia Final: ");
            diaFinal = sc.nextInt();
            System.out.print("Mês Final: ");
            mesFinal = sc.nextInt();

            while (anoFinal < anoInicio) { //O ano precisa ser maior ou igual ao que foi inserido como anoInicio
                System.out.print("Ano Final (Precisa ser posterior a data Inicial " + anoInicio + "): ");
                anoFinal = sc.nextInt();
            }
        } else {//Caso o usuário não queria inserir uma data, colocamos uma data padrão: 07/06/2024
            diaFinal = 7;
            mesFinal = 6;
            anoFinal = 2024;
            System.out.println("A data final padrão foi definida como: " + diaFinal + "/" + mesFinal + "/" + anoFinal);
        }

    }

    static void pesquisaData(LocalDate dataInicio, LocalDate dataFim) { //Pede como parametro as datas de inicio e fim
        for (int i = 0; i < tabela.size(); i++) {

            //Comparação se a data de início está antes da data do fim das datas da tabela
            //Comparação se a data fo fim está depois da data de início do fim das datas da tabela

            if ((dataInicio.isBefore(tabela.get(i).getDataFim()) || dataInicio.isEqual(tabela.get(i).getDataFim())) &&
                    (dataFim.isAfter(tabela.get(i).getDataInicio()) || dataFim.isEqual(tabela.get(i).getDataInicio()))) {

                dadosEncontrados.add(tabela.get(i)); //Caso passe na conferência, adicionamos na lista de dados encontrados

            }
        }

        System.out.println("\nOs dados da tabela que fazem interseção com suas datas são:");

        for (int i = 0; i < dadosEncontrados.size(); i++) { //Printando os dados encontrados (yyyy/MM/aa)

            System.out.println("Tabela de ID: " + dadosEncontrados.get(i).getId() + " Data Início: " + dadosEncontrados.get(i).getDataInicio() + " Data Final: " + dadosEncontrados.get(i).getDataFim());

        }

        if (dadosEncontrados.size() == 0) {
            System.out.println("\nNenhuma dado da tabela faz interseção com suas datas.");
        }
    }
}

class Tabela { //Classe construtora de tabela
    int id;
    LocalDate dataInicio;
    LocalDate dataFim;

    public Tabela(int id, LocalDate dataInicio, LocalDate dataFim) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public String toString() {
        return "\n{" + "id = " + id + ", dataInicio = " + dataInicio + ", dataFim = " + dataFim + '}';
    }
}
