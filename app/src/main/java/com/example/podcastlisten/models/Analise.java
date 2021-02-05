package com.example.podcastlisten.models;

import android.content.Context;

import androidx.annotation.Nullable;

import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Analise extends ModelFirestore implements Serializable {
    public static final String COLECAO = "Analise";


    public static final String COLUMN_AUDIO_NOME = "nome";
    public static final String COLUMN_AUDIO_DATA = "data";
    public static final String COLUMN_DT_CRIACAO = "dt_criacao";

    Map<String, String> mapaQuesitos;

    /**
     * ID vai guardar a identificação única dada a coleção pelo FIrebase
     */
    private String id;

    private String ISBN;

    /**
     * Data de criação da análise, vai ser atribuído automaticamente
     */
    public Date dt_criacao;


    //tela 1
    //Informações importantes sobre o texto
    /**
     * Título do texto
     */
    private String q1_1;

    /**
     * Autor ou autores
     */
    private String q1_2;

    /**
     * Você já conhecia o autor do texto? Já leu outros textos dele? O que achou? O que é importante registrar?
     */
    private String q1_3;

    /**
     * Referência Bibliográfica
     */
    private String q1_4;

    /**
     * Qual o seu objetivo ao ler o texto?
     */
    private String q1_5;

    /**
     * Assunto principal do texto"
     */
    private String q1_6;

    /**
     * Outros assuntos do texto
     */
    private String q1_7;

    /**
     * Como você chegou até o texto? O texto foi indicado por alguém? Quem? Essa informação é importante para a leitura? Por quê?
     */
    private String q1_8;

    /**
     * Data de início da leitura
     */
    private String q1_9;

    /**
     * Data de término da leitura
     */
    private String q1_10;

    /**
     * Você quer fazer uma análise completa? *
     */
    private String q1_11;

    /**
     * Como você classificaria o seu interesse após 5 minutos de leitura?
     */
    private String q2_1;

    /**
     * Justifique a resposta, é importante para você se conhecer como leitor:
     */
    private String q2_2;

    /**
     * E na metade de leitura, como você se sentia?
     */
    private String q2_3;

    /**
     * Justifique a resposta, é importante para você se conhecer como leitor:
     */
    private String q2_4;

    /**
     * Como você classificaria o prazer ao final da leitura?
     */
    private String q2_5;

    /**
     * Justifique a resposta, é importante para você se conhecer como leitor:
     */
    private String q2_6;

    /**
     * Seu objetivo ao ler o texto foi cumprido?
     */
    private String q2_7;

    /**
     * Caso a leitura não tenha sido satisfatória para o objetivo, o que aconteceu?
     */
    private List<String> q2_8;

    /**
     * Que outra coisa?
     */
    private String q2_9;

    /**
     * As ideias do autor lhe agradam?
     */
    private String q2_10;

    /**
     * Com que partes do texto você concorda mais? Faça citações ou paráfrases:
     */
    private String q2_11;

    /**
     * Com que parte(s) do texto você discorda? Faça citações, paráfrases, discuta e apresente argumentos:
     */
    private String q2_12;

    /**
     * O estilo de escrita do autor lhe agrada?
     */
    private String q2_13;

    /**
     * Justifique a resposta, é importante para você se conhecer como leitor:
     */
    private String q2_14;

    /**
     * O gênero desse livro lhe agrada?
     */
    private String q2_15;


    /**
     * Justifique a resposta, é importante para você se conhecer como leitor:
     */
    private String q2_16;

    /**
     * Você acredita que a leitura desse texto contribuiu em alguma dessas áreas?
     */
    private List<String> q2_17;

    /**
     * Justifique a resposta, citando trechos ou fazendo paráfrases:
     */
    private String q2_18;

    /**
     * Você acredita que a leitura do texto contribuiria para a vida de outras pessoas? Quais? Como?
     */
    private String q2_19;

    /**
     * Anotações Livres
     */
    private String q3_1;


    /**
     * Resumo geral
     */
    private String q4_1;

    /**
     * Resumo de capítulos
     */
    private String q4_2;

    /**
     * Paráfrases (não esqueça de marcar as páginas!)
     */
    private String q4_3;

    /**
     * Citações diretas (não esqueça de marcar as páginas!)
     */
    private String q4_4;

    /**
     * Há algo interessante sobre as capas, a orelha ou o título do livro que você queira registrar?
     */
    private String q5_1;

    /**
     * Há algo interessante sobre o projeto gráfico do livro? (formato, papel, cores, ilustrações) - em caso de texto narrativo ilustrado, haverá um guia detalhado para análise posterior.
     */
    private String q5_2;

    /**
     * Há algo interessante a respeito da editora, da série ou coleção a que o livro pertence que você queira registrar?
     */
    private String q5_3;

    /**
     * A edição e a data de publicação do livro são importantes para seu objetivo de leitura? Por quê? Como?
     */
    private String q5_4;

    /**
     * Há apresentação, notas, apêndices? Eles são importantes para compreensão do assunto? Quem escreveu esses textos? O que é importante anotar?
     */
    private String q5_5;

    /**
     * Qual tipo de texto você está lendo?
     */
    private String q6_1;


    //******TELA Pontos importantes do texto informativo *******/

    /**
     * Qual o assunto principal do texto? Sintetize e/ou registre trechos importantes
     */
    private String q7_1;

    /**
     * Qual o assunto principal do texto? Sintetize e/ou registre trechos importantes
     */
    private String q7_2;


    /**
     * Quais as fontes utilizadas? Elas são confiáveis? É possível resgatá-las e lê-las no original?
     */
    private String q7_3;

    /**
     * As informações estão completas? Há lacunas?
     */
    private String q7_4;

    /**
     * Ficaram questões a ser compreendidas?
     */
    private String q7_5;

    /**
     * Há pontos importantes a anotar sobre a bibliografia utilizada pelo autor? *
     */
    private String q7_6;

    /**
     * Qual a tese central do texto? Sintetize e/ou registre trechos importantes
     */
    private String q8_1;

    /**
     * Quais os argumentos utilizados? Sintetize e/ou registre trechos importantes
     */
    private String q8_2;

    /**
     * Há ilustrações, tabelas ou gráficos acompanhando o texto? São importantes? Há algo a registrar sobre elas?
     */
    private String q8_3;

    /**
     * Há outros pontos importantes a ser registrados?
     */
    private String q8_4;

    /**
     * Você concorda ou não com a tese? Por quê?
     */
    private String q8_5;

    /**
     * Os argumentos utilizados são verdadeiros? Há fontes? Você confia nas fontes apresentadas? Você pode apresentar fontes ou argumentos contrários?
     */
    private String q8_6;

    /**
     * Os argumentos estão bem construídos e concatenados? Eles suportam a tese ou não tem relação com ela?
     */
    private String q8_7;

    /**
     * Há pontos importantes a anotar sobre a bibliografia utilizada pelo autor?
     */
    private String q8_8;

    /**
     * A leitura foi prazerosa e interessante? Qual a impressão mais vívida provocada pela leitura?
     */
    private String q9_1;

    /**
     * Há um tema central no(s) poema(s)? Em caso de coletânea, há um eixo temático que amarre os poemas entre si? Isso é importante?
     */
    private String q9_2;

    /**
     * Como é a rima do poema?
     */
    private String q9_3;

    /**
     * Como é a métrica do poema?
     */
    private String q9_4;

    /**
     * O eu lírico se apresenta de alguma forma? Há algo a relatar?
     */
    private String q9_5;

    /**
     * Questões de linguagem que podem aparecer no texto:
     */
    private List<String> q9_6;

    /**
     * Quais figuras de linguagem estão presentes no poema?
     */
    private String q9_7;

    /**
     * Descreva de forma mais detalhada o que lhe chamou atenção na questão anterior, fazendo citações
     */
    private String q9_8;

    /**
     * A forma como o poema se distribui na página é importante? É um poema concreto?
     */
    private String q9_9;

    /**
     * O texto é um poema épico ou narrativo? Você gostaria de analisar também a história existente no poema? *
     */
    private String q9_10;


    /**
     * A leitura foi prazerosa e interessante? Qual a impressão mais vívida provocada pela leitura?
     */
    private String q10_1;

    /**
     * O que acontece na história? Qual o enredo?
     */
    private String q10_2;

    /**
     * Quem são os personagens, como são, como se relacionam? Quais são mais importantes para a história, quais são coadjuvantes?
     */
    private String q10_3;

    /**
     * O que se pode registrar sobre o espaço da narrativa? Algum elemento espacial se apresenta com mais destaque?
     */
    private String q10_4;

    /**
     * O que se pode registrar sobre a sequência temporal dos acontecimentos narrados? O tempo é cronológico, psicológico? Os fatos são narrados na sequência em que acontecem? Há algo específico sobre o tempo que seja interessante registrar?
     */
    private String q10_5;

    /**
     * Há descrições? Como são?
     */
    private String q10_6;

    /**
     * Qual o gênero literário escolhido? Isso é importante?
     */
    private String q10_7;

    /**
     * Qual o tipo do narrador? Isso é importante?
     */
    private String q10_8;

    /**
     * Qual o foco narrativo predominante: mostrar ou contar? Isso é importante?
     */
    private String q10_9;

    /**
     * Questões de linguagem que podem aparecer no texto:
     */
    private List<String> q10_10;

    /**
     * Descreva de forma mais detalhada o que lhe chamou atenção na questão anterior, fazendo citações
     */
    private String q10_11;

    /**
     * Há ilustrações acompanhando o texto? Como se relacionam com o texto? São importantes? Há algo a registrar sobre elas?
     */
    private String q10_12;

    /**
     * Você gostaria de analisar as ilustrações e o projeto do gráfico mais detalhadamente? *
     */
    private String q10_13;


    /**
     * Você conhece alguma obra relacionada?
     */
    private String q11_1;

    /**
     * São obras atuais?
     */
    private String q11_2;

    /**
     * Você conhece alguma obra relacionada?
     */
    private String q11_3;

    /**
     * Você considera a bibliografia adequada ao assunto do texto?
     */
    private String q11_4;

    /**
     * Qual lacuna? Qual a relevância dessa lacuna para seu objetivo em ler o texto?
     */
    private String q11_5;

    /**
     * Pode-se perceber algum enfoque político a partir dessas obras?
     */
    private String q11_6;

    /**
     * Deseja comentar algo sobre elas? *
     */
    private String q12_1;

    /**
     * Marque as dificuldades encontradas:
     */
    private List<String> q13_1;

    /**
     * Descreva de forma mais detalhada suas dificuldades, com citações:
     */
    private String q13_2;

    /**
     * Como você resolveu suas dificuldades?
     */
    private String q13_3;

    /**
     * Você pretende resolvê-las com alguma estratégia? Qual?
     */
    private String q13_4;

    /**
     * Você consegue relacionar o texto com alguma dessas experiências?
     */
    private List<String> q14_1;

    /**
     * Descreva as experiências que acreditar mais importantes:
     */
    private String q14_2;

    /**
     * Você consegue relacionar o texto com algum desses objetos culturais?
     */
    private List<String> q14_3;

    /**
     * Descreva com mais detalhes as relações marcadas na questão anterior:
     */
    private String q14_4;

    /**
     * Você consegue relacionar o texto com algum texto acadêmico cujo autor concorde ou complemente as ideias apresentadas? Qual?
     */
    private String q14_5;

    /**
     * Você consegue relacionar o texto com algum texto acadêmico cujo autor discorde das ideais apresentadas? Qual?
     */
    private String q14_6;

    /**
     * Você gostaria de analisar as ilustrações e o projeto do gráfico mais detalhadamente? *
     */
    private String q15_1;

    /**
     * Qual é, ou são, o(s) artista(s) responsáveis pelo projeto gráfico ou pelas ilustrações?
     */
    private String q16_1;

    /**
     * O formato do livro é diferente ou relevante? Como?
     */
    private String q16_2;

    /**
     * O material utilizado na confecção do livro é diferente o relevante? Como?
     */
    private String q16_3;

    /**
     * Como as ilustrações se relacionam com o texto?
     */
    private String q16_4;

    /**
     * Qual é a técnica utilizada na produção das ilustrações?
     */
    private String q16_5;

    /**
     * Há algo interessante a respeito das cores utilizadas? Que sensação elas te trazem?
     */
    private String q16_6;

    /**
     * Há algo interessante sobre o desenho das personagens, ou de alguma personagem específica?
     */
    private String q16_7;

    /**
     * Há algo interessante sobre os espaços e cenários desenhados?
     */
    private String q16_8;

    /**
     * Há coisas interessantes a se relatar sobre objetos de cena desenhados? Há algum objeto de cena específico que mereça destaque?
     */
    private String q16_9;

    /**
     * O que mais é possível dizer a respeito das ilustrações?
     */
    private String q16_10;

    private List<Map<String, String>> audios = new ArrayList<>();


    public Analise() {
        generateMap();
    }


    public void generateMap() {
        mapaQuesitos = new HashMap<>();
    }

    public static List<Analise> findAll(String email) {
        List<QueryDocumentSnapshot> aux = ModelFirestore.findAllSubDocumentsByParentDocument(Usuario.COLECAO, email, Analise.COLECAO);
        List<Analise> lista = new ArrayList<>();
        if (aux != null) {
            for (QueryDocumentSnapshot doc : aux) {
                lista.add(doc.toObject(Analise.class));
            }
            return lista;
        } else {
            return null;
        }
    }

    public List<Map<String, String>> getAudios() {
        return audios;
    }


    public void setAudios(List<Map<String, String>> audios) {
        this.audios = audios;
    }

    public Map<String, String> getMapaQuesitos() {
        return mapaQuesitos;
    }

    public void setMapaQuesitos(Map<String, String> mapaQuesitos) {
        this.mapaQuesitos = mapaQuesitos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDt_criacao() {
        return dt_criacao;
    }

    public void setDt_criacao(Date dt_criacao) {
        this.dt_criacao = dt_criacao;
    }

    public String getQ1_1() {
        return q1_1;
    }

    public void setQ1_1(String q1_1) {
        this.q1_1 = q1_1;
    }

    public String getQ11_1() {
        return q11_1;
    }

    public String getQ12_1() {
        return q12_1;
    }

    public void setQ12_1(String q12_1) {
        this.q12_1 = q12_1;
    }

    public void setQ11_1(String q11_1) {
        this.q11_1 = q11_1;
    }

    public String getQ11_2() {
        return q11_2;
    }

    public void setQ11_2(String q11_2) {
        this.q11_2 = q11_2;
    }

    public String getQ16_1() {
        return q16_1;
    }

    public void setQ16_1(String q16_1) {
        this.q16_1 = q16_1;
    }

    public String getQ16_2() {
        return q16_2;
    }

    public void setQ16_2(String q16_2) {
        this.q16_2 = q16_2;
    }

    public String getQ16_3() {
        return q16_3;
    }

    public void setQ16_3(String q16_3) {
        this.q16_3 = q16_3;
    }

    public String getQ16_4() {
        return q16_4;
    }

    public void setQ16_4(String q16_4) {
        this.q16_4 = q16_4;
    }

    public String getQ16_5() {
        return q16_5;
    }

    public void setQ16_5(String q16_5) {
        this.q16_5 = q16_5;
    }

    public String getQ16_6() {
        return q16_6;
    }

    public void setQ16_6(String q16_6) {
        this.q16_6 = q16_6;
    }

    public String getQ16_7() {
        return q16_7;
    }

    public void setQ16_7(String q16_7) {
        this.q16_7 = q16_7;
    }

    public String getQ16_8() {
        return q16_8;
    }

    public void setQ16_8(String q16_8) {
        this.q16_8 = q16_8;
    }

    public String getQ16_9() {
        return q16_9;
    }

    public void setQ16_9(String q16_9) {
        this.q16_9 = q16_9;
    }

    public String getQ16_10() {
        return q16_10;
    }

    public void setQ16_10(String q16_10) {
        this.q16_10 = q16_10;
    }

    public String getQ15_1() {
        return q15_1;
    }

    public void setQ15_1(String q15_1) {
        this.q15_1 = q15_1;
    }

    public String getQ11_3() {
        return q11_3;
    }

    public void setQ11_3(String q11_3) {
        this.q11_3 = q11_3;
    }

    public List<String> getQ13_1() {
        return q13_1;
    }

    public void setQ13_1(List<String> q13_1) {
        this.q13_1 = q13_1;
    }

    public List<String> getQ14_1() {
        return q14_1;
    }

    public void setQ14_1(List<String> q14_1) {
        this.q14_1 = q14_1;
    }

    public String getQ14_2() {
        return q14_2;
    }

    public void setQ14_2(String q14_2) {
        this.q14_2 = q14_2;
    }

    public List<String> getQ14_3() {
        return q14_3;
    }

    public void setQ14_3(List<String> q14_3) {
        this.q14_3 = q14_3;
    }

    public String getQ14_4() {
        return q14_4;
    }

    public void setQ14_4(String q14_4) {
        this.q14_4 = q14_4;
    }

    public String getQ14_5() {
        return q14_5;
    }

    public void setQ14_5(String q14_5) {
        this.q14_5 = q14_5;
    }

    public String getQ14_6() {
        return q14_6;
    }

    public void setQ14_6(String q14_6) {
        this.q14_6 = q14_6;
    }

    public String getQ13_2() {
        return q13_2;
    }

    public void setQ13_2(String q13_2) {
        this.q13_2 = q13_2;
    }

    public String getQ13_3() {
        return q13_3;
    }

    public void setQ13_3(String q13_3) {
        this.q13_3 = q13_3;
    }

    public String getQ13_4() {
        return q13_4;
    }

    public void setQ13_4(String q13_4) {
        this.q13_4 = q13_4;
    }

    public String getQ11_4() {
        return q11_4;
    }

    public void setQ11_4(String q11_4) {
        this.q11_4 = q11_4;
    }

    public String getQ11_5() {
        return q11_5;
    }

    public void setQ11_5(String q11_5) {
        this.q11_5 = q11_5;
    }

    public String getQ11_6() {
        return q11_6;
    }

    public void setQ11_6(String q11_6) {
        this.q11_6 = q11_6;
    }

    public String getQ1_2() {
        return q1_2;
    }

    public void setQ1_2(String q1_2) {
        this.q1_2 = q1_2;
    }

    public String getQ1_3() {
        return q1_3;
    }

    public String getQ7_1() {
        return q7_1;
    }

    public void setQ7_1(String q7_1) {
        this.q7_1 = q7_1;
    }

    public String getQ7_2() {
        return q7_2;
    }

    public void setQ7_2(String q7_2) {
        this.q7_2 = q7_2;
    }

    public String getQ7_3() {
        return q7_3;
    }

    public void setQ7_3(String q7_3) {
        this.q7_3 = q7_3;
    }

    public String getQ8_1() {
        return q8_1;
    }

    public void setQ8_1(String q8_1) {
        this.q8_1 = q8_1;
    }

    public String getQ8_2() {
        return q8_2;
    }

    public void setQ8_2(String q8_2) {
        this.q8_2 = q8_2;
    }

    public String getQ9_1() {
        return q9_1;
    }

    public void setQ9_1(String q9_1) {
        this.q9_1 = q9_1;
    }

    public String getQ9_2() {
        return q9_2;
    }

    public void setQ9_2(String q9_2) {
        this.q9_2 = q9_2;
    }

    public String getQ9_3() {
        return q9_3;
    }

    public void setQ9_3(String q9_3) {
        this.q9_3 = q9_3;
    }

    public String getQ9_4() {
        return q9_4;
    }

    public void setQ9_4(String q9_4) {
        this.q9_4 = q9_4;
    }

    public String getQ9_5() {
        return q9_5;
    }

    public void setQ9_5(String q9_5) {
        this.q9_5 = q9_5;
    }

    public List<String> getQ9_6() {
        return q9_6;
    }

    public void setQ9_6(List<String> q9_6) {
        this.q9_6 = q9_6;
    }

    public String getQ9_7() {
        return q9_7;
    }

    public void setQ9_7(String q9_7) {
        this.q9_7 = q9_7;
    }

    public String getQ9_8() {
        return q9_8;
    }

    public void setQ9_8(String q9_8) {
        this.q9_8 = q9_8;
    }

    public String getQ9_9() {
        return q9_9;
    }

    public void setQ9_9(String q9_9) {
        this.q9_9 = q9_9;
    }

    public String getQ9_10() {
        return q9_10;
    }

    public void setQ9_10(String q9_10) {
        this.q9_10 = q9_10;
    }

    public String getQ8_3() {
        return q8_3;
    }

    public void setQ8_3(String q8_3) {
        this.q8_3 = q8_3;
    }

    public String getQ8_4() {
        return q8_4;
    }

    public void setQ8_4(String q8_4) {
        this.q8_4 = q8_4;
    }

    public String getQ8_5() {
        return q8_5;
    }

    public void setQ8_5(String q8_5) {
        this.q8_5 = q8_5;
    }

    public String getQ8_6() {
        return q8_6;
    }

    public void setQ8_6(String q8_6) {
        this.q8_6 = q8_6;
    }

    public String getQ8_7() {
        return q8_7;
    }

    public void setQ8_7(String q8_7) {
        this.q8_7 = q8_7;
    }

    public String getQ8_8() {
        return q8_8;
    }

    public void setQ8_8(String q8_8) {
        this.q8_8 = q8_8;
    }

    public String getQ7_4() {
        return q7_4;
    }

    public void setQ7_4(String q7_4) {
        this.q7_4 = q7_4;
    }

    public String getQ7_5() {
        return q7_5;
    }

    public void setQ7_5(String q7_5) {
        this.q7_5 = q7_5;
    }

    public String getQ7_6() {
        return q7_6;
    }

    public void setQ7_6(String q7_6) {
        this.q7_6 = q7_6;
    }

    public void setQ1_3(String q1_3) {
        this.q1_3 = q1_3;
    }

    public String getQ1_4() {
        return q1_4;
    }

    public void setQ1_4(String q1_4) {
        this.q1_4 = q1_4;
    }

    public String getQ1_5() {
        return q1_5;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setQ1_5(String q1_5) {
        this.q1_5 = q1_5;
    }

    public String getQ1_6() {
        return q1_6;
    }

    public String getQ6_1() {
        return q6_1;
    }

    public void setQ6_1(String q6_1) {
        this.q6_1 = q6_1;
    }

    public void setQ1_6(String q1_6) {
        this.q1_6 = q1_6;
    }

    public String getQ1_7() {
        return q1_7;
    }

    public void setQ1_7(String q1_7) {
        this.q1_7 = q1_7;
    }

    public String getQ1_8() {
        return q1_8;
    }

    public void setQ1_8(String q1_8) {
        this.q1_8 = q1_8;
    }

    public String getQ1_9() {
        return q1_9;
    }

    public void setQ1_9(String q1_9) {
        this.q1_9 = q1_9;
    }

    public String getQ1_10() {
        return q1_10;
    }

    public void setQ1_10(String q1_10) {
        this.q1_10 = q1_10;
    }

    public String getQ1_11() {
        return q1_11;
    }

    public void setQ1_11(String q1_11) {
        this.q1_11 = q1_11;
    }

    public String getQ2_1() {
        return q2_1;
    }

    public void setQ2_1(String q2_1) {
        this.q2_1 = q2_1;
    }

    public String getQ2_2() {
        return q2_2;
    }

    public void setQ2_2(String q2_2) {
        this.q2_2 = q2_2;
    }

    public String getQ2_3() {
        return q2_3;
    }

    public void setQ2_3(String q2_3) {
        this.q2_3 = q2_3;
    }

    public String getQ2_4() {
        return q2_4;
    }

    public void setQ2_4(String q2_4) {
        this.q2_4 = q2_4;
    }

    public String getQ2_5() {
        return q2_5;
    }

    public void setQ2_5(String q2_5) {
        this.q2_5 = q2_5;
    }

    public String getQ2_6() {
        return q2_6;
    }

    public void setQ2_6(String q2_6) {
        this.q2_6 = q2_6;
    }

    public String getQ2_7() {
        return q2_7;
    }

    public void setQ2_7(String q2_7) {
        this.q2_7 = q2_7;
    }

    public List<String> getQ2_8() {
        return q2_8;
    }

    public void setQ2_8(List<String> q2_8) {
        this.q2_8 = q2_8;
    }

    public String getQ2_9() {
        return q2_9;
    }

    public void setQ2_9(String q2_9) {
        this.q2_9 = q2_9;
    }

    public String getQ2_10() {
        return q2_10;
    }

    public void setQ2_10(String q2_10) {
        this.q2_10 = q2_10;
    }

    public String getQ2_11() {
        return q2_11;
    }

    public void setQ2_11(String q2_11) {
        this.q2_11 = q2_11;
    }

    public String getQ2_12() {
        return q2_12;
    }

    public void setQ2_12(String q2_12) {
        this.q2_12 = q2_12;
    }

    public String getQ2_13() {
        return q2_13;
    }

    public void setQ2_13(String q2_13) {
        this.q2_13 = q2_13;
    }

    public String getQ2_14() {
        return q2_14;
    }

    public void setQ2_14(String q2_14) {
        this.q2_14 = q2_14;
    }

    public String getQ2_15() {
        return q2_15;
    }

    public void setQ2_15(String q2_15) {
        this.q2_15 = q2_15;
    }

    public String getQ2_16() {
        return q2_16;
    }

    public void setQ2_16(String q2_16) {
        this.q2_16 = q2_16;
    }

    public List<String> getQ2_17() {
        return q2_17;
    }

    public void setQ2_17(List<String> q2_17) {
        this.q2_17 = q2_17;
    }

    public String getQ2_18() {
        return q2_18;
    }

    public void setQ2_18(String q2_18) {
        this.q2_18 = q2_18;
    }

    public String getQ2_19() {
        return q2_19;
    }

    public void setQ2_19(String q2_19) {
        this.q2_19 = q2_19;
    }

    public String getQ3_1() {
        return q3_1;
    }

    public void setQ3_1(String q3_1) {
        this.q3_1 = q3_1;
    }

    public String getQ4_1() {
        return q4_1;
    }

    public void setQ4_1(String q4_1) {
        this.q4_1 = q4_1;
    }

    public String getQ4_2() {
        return q4_2;
    }

    public void setQ4_2(String q4_2) {
        this.q4_2 = q4_2;
    }

    public String getQ4_3() {
        return q4_3;
    }

    public void setQ4_3(String q4_3) {
        this.q4_3 = q4_3;
    }

    public String getQ4_4() {
        return q4_4;
    }

    public void setQ4_4(String q4_4) {
        this.q4_4 = q4_4;
    }

    public String getQ5_1() {
        return q5_1;
    }

    public void setQ5_1(String q5_1) {
        this.q5_1 = q5_1;
    }

    public String getQ5_2() {
        return q5_2;
    }

    public String getQ10_1() {
        return q10_1;
    }

    public void setQ10_1(String q10_1) {
        this.q10_1 = q10_1;
    }

    public String getQ10_2() {
        return q10_2;
    }

    public void setQ10_2(String q10_2) {
        this.q10_2 = q10_2;
    }

    public String getQ10_3() {
        return q10_3;
    }

    public void setQ10_3(String q10_3) {
        this.q10_3 = q10_3;
    }

    public String getQ10_4() {
        return q10_4;
    }

    public void setQ10_4(String q10_4) {
        this.q10_4 = q10_4;
    }

    public String getQ10_5() {
        return q10_5;
    }

    public void setQ10_5(String q10_5) {
        this.q10_5 = q10_5;
    }

    public String getQ10_6() {
        return q10_6;
    }

    public void setQ10_6(String q10_6) {
        this.q10_6 = q10_6;
    }

    public String getQ10_7() {
        return q10_7;
    }

    public void setQ10_7(String q10_7) {
        this.q10_7 = q10_7;
    }

    public String getQ10_8() {
        return q10_8;
    }

    public void setQ10_8(String q10_8) {
        this.q10_8 = q10_8;
    }

    public String getQ10_9() {
        return q10_9;
    }

    public void setQ10_9(String q10_9) {
        this.q10_9 = q10_9;
    }

    public List<String> getQ10_10() {
        return q10_10;
    }

    public void setQ10_10(List<String> q10_10) {
        this.q10_10 = q10_10;
    }

    public String getQ10_11() {
        return q10_11;
    }

    public void setQ10_11(String q10_11) {
        this.q10_11 = q10_11;
    }

    public String getQ10_12() {
        return q10_12;
    }

    public void setQ10_12(String q10_12) {
        this.q10_12 = q10_12;
    }

    public String getQ10_13() {
        return q10_13;
    }

    public void setQ10_13(String q10_13) {
        this.q10_13 = q10_13;
    }

    public void setQ5_2(String q5_2) {
        this.q5_2 = q5_2;
    }

    public String getQ5_3() {
        return q5_3;
    }

    public void setQ5_3(String q5_3) {
        this.q5_3 = q5_3;
    }

    public String getQ5_4() {
        return q5_4;
    }

    public void setQ5_4(String q5_4) {
        this.q5_4 = q5_4;
    }

    public String getQ5_5() {
        return q5_5;
    }

    public void setQ5_5(String q5_5) {
        this.q5_5 = q5_5;
    }

    private static String getPerguntaTexto(String pergunta, String resposta) {
        if (resposta == null) {
            return pergunta + "\n\n";
        } else {
            return pergunta + "\n" + resposta + "\n\n";
        }
    }

    private static String getPerguntaTextoRadioButton(String pergunta, String resposta) {
        if (resposta == null || resposta.contentEquals("-1")) {
            return pergunta + "\n\n";
        } else {
            return pergunta + "\n" + resposta + "\n\n";
        }
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if ((this.id.equals(((Analise) obj).id)))// && (this.descricao == ((Produto)obj).descricao) && (this.preco == ((Produto)obj).preco) )
            return true;
        else
            return false;
    }


    public void save(String email) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", this.getId());

        map.put("ISBN", this.getISBN());

        map.put("q1_1", this.q1_1);
        map.put("q1_2", this.q1_2);
        map.put("q1_3", this.q1_3);
        map.put("q1_4", this.q1_4);
        map.put("q1_5", this.q1_5);
        map.put("q1_6", this.q1_6);
        map.put("q1_7", this.q1_7);
        map.put("q1_8", this.q1_8);
        map.put("q1_9", this.q1_9);
        map.put("q1_10", this.q1_10);
        map.put("q1_11", this.q1_11);

        map.put("q2_1", this.q2_1);
        map.put("q2_2", this.q2_2);
        map.put("q2_3", this.q2_3);
        map.put("q2_4", this.q2_4);
        map.put("q2_5", this.q2_5);
        map.put("q2_6", this.q2_6);
        map.put("q2_7", this.q2_7);
        map.put("q2_8", this.q2_8);
        map.put("q2_9", this.q2_9);
        map.put("q2_10", this.q2_10);
        map.put("q2_11", this.q2_11);
        map.put("q2_12", this.q2_12);
        map.put("q2_13", this.q2_13);
        map.put("q2_14", this.q2_14);
        map.put("q2_15", this.q2_15);
        map.put("q2_16", this.q2_16);
        map.put("q2_17", this.q2_17);
        map.put("q2_18", this.q2_18);
        map.put("q2_19", this.q2_19);

        map.put("q3_1", this.q3_1);

        map.put("q4_1", this.q4_1);
        map.put("q4_2", this.q4_2);
        map.put("q4_3", this.q4_3);
        map.put("q4_4", this.q4_4);

        map.put("q5_1", this.q5_1);
        map.put("q5_2", this.q5_2);
        map.put("q5_3", this.q5_3);
        map.put("q5_4", this.q5_4);
        map.put("q5_5", this.q5_5);

        //tela quesitos completo 2
        map.put("q6_1", this.q6_1);

        //******TELA Pontos importantes do texto informativo *******/
        map.put("q7_1", this.q7_1);
        map.put("q7_2", this.q7_2);
        map.put("q7_3", this.q7_3);
        map.put("q7_4", this.q7_4);
        map.put("q7_5", this.q7_5);
        map.put("q7_6", this.q7_6);

        //******TELA Pontos importantes do texto argumentativo *******/
        map.put("q8_1", this.q8_1);
        map.put("q8_2", this.q8_2);
        map.put("q8_3", this.q8_3);
        map.put("q8_4", this.q8_4);
        map.put("q8_5", this.q8_5);
        map.put("q8_6", this.q8_6);
        map.put("q8_7", this.q8_5);
        map.put("q8_8", this.q8_6);

        //******TELA Pontos importantes do texto poesia *******/
        map.put("q9_1", this.q9_1);
        map.put("q9_2", this.q9_2);
        map.put("q9_3", this.q9_3);
        map.put("q9_4", this.q9_4);
        map.put("q9_5", this.q9_5);
        map.put("q9_6", this.q9_6);
        map.put("q9_7", this.q9_7);
        map.put("q9_8", this.q9_8);
        map.put("q9_9", this.q9_9);
        map.put("q9_10", this.q9_10);

        //******TELA Pontos importantes do texto narrativo *******/
        map.put("q10_1", this.q10_1);
        map.put("q10_2", this.q10_2);
        map.put("q10_3", this.q10_3);
        map.put("q10_4", this.q10_4);
        map.put("q10_5", this.q10_5);
        map.put("q10_6", this.q10_6);
        map.put("q10_7", this.q10_7);
        map.put("q10_8", this.q10_8);
        map.put("q10_9", this.q10_9);
        map.put("q10_10", this.q10_10);
        map.put("q10_11", this.q10_11);
        map.put("q10_12", this.q10_12);
        map.put("q10_13", this.q10_13);

        //******TELA Analise Bibliografia *******/
        map.put("q11_1", this.q11_1);
        map.put("q11_2", this.q11_2);
        map.put("q11_3", this.q11_3);
        map.put("q11_4", this.q11_4);
        map.put("q11_5", this.q11_5);
        map.put("q11_6", this.q11_6);


        //******TELA Analise teve dificuldade leitura *******/
        map.put("q12_1", this.q12_1);

        //******TELA Complementar Dificuldade de Leitura *******/
        map.put("q13_1", this.q13_1);
        map.put("q13_2", this.q13_2);
        map.put("q13_3", this.q13_3);
        map.put("q13_4", this.q13_4);

        //******TELA Relações do texto com outros conteúdos *******/
        map.put("q14_1", this.q14_1);
        map.put("q14_2", this.q14_2);
        map.put("q14_3", this.q14_3);
        map.put("q14_4", this.q14_4);
        map.put("q14_5", this.q14_5);
        map.put("q14_6", this.q14_6);

        map.put("audios", this.getAudios());

        if (this.dt_criacao == null)
            map.put("dt_criacao", new Date());
        else
            map.put("dt_criacao", this.dt_criacao);
        this.setSubDocument(Usuario.COLECAO, email, Analise.COLECAO, this.id, map);
    }

    private static String getPerguntaTextoCheckBox(String pergunta, List<String> respostas, HashMap<String, String> possibilidades) {
        String texto = pergunta + "\n";
        if (respostas != null && respostas.size() > 0 && possibilidades != null && possibilidades.size() > 0) {
            for (String resposta : respostas) {
                if (possibilidades.get(resposta) != null)
                    texto += possibilidades.get(resposta) + "\n";
            }
        }

        return texto + "\n";
    }

    public String getTipoAnalise() {
//        if (this.q1_11 != null)
//            switch (this.q1_11) {
//                case IDENTIFICACOES.APENAS_ANOTACAOES:
//                    return IDENTIFICACOES.APENAS_ANOTACAOES_COMPLETE;
//
//                case IDENTIFICACOES.APENAS_REACOES:
//                    return IDENTIFICACOES.APENAS_REACOES_COMPLETE;
//
//                case IDENTIFICACOES.APENAS_RESUMOS:
//                    return IDENTIFICACOES.APENAS_RESUMOS_COMPLETE;
//
//                case IDENTIFICACOES.ENCERRAR:
//                    return IDENTIFICACOES.ENCERRAR_COMPLETO;
//
//                case IDENTIFICACOES.ANALISE_COMPLETA:
//                    return IDENTIFICACOES.ANALISE_COMPLETA_COMPLETO;
//            }
        return "";
    }

    public boolean isEncerrar() {

//        return this.q1_11.compareTo(IDENTIFICACOES.ENCERRAR) == 0;
        return true;
    }

    public String getTextToShare(Context context) {
        String texto = "";
        RESPOSTAS_CHECK respostasCheck = new RESPOSTAS_CHECK(context);

//        texto += getTextToShareQ1(respostasCheck);


        return texto;
    }

//    private String getTextToShareQ16(RESPOSTAS_CHECK respostas_check) {
//        String texto = Analise.getPerguntaTexto(PERGUNTAS.q16_1, q16_1);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q16_2, q16_2);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q16_3, q16_3);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTextoRadioButton(PERGUNTAS.q16_4, q16_4);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q16_5, q16_5);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q16_6, q16_6);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q16_7, q16_7);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q16_8, q16_8);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q16_9, q16_9);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q16_10, q16_10);
//
//        texto += getTextToShareQ12(respostas_check);
//
//        return texto;
//    }
//
//    private String getTextToShareQ15(RESPOSTAS_CHECK respostas_check) {
//        String texto = br.com.dforlani.readwithme.model.Analise.getPerguntaTextoRadioButton(PERGUNTAS.q15_1, q15_1);
//        if (this.getQ15_1() != null) {
//            switch (this.getQ15_1()) {
//                case br.com.dforlani.readwithme.model.Analise.IDENTIFICACOES.SIM_MINUSCULAS:
//                    texto += getTextToShareQ16(respostas_check);
//                    break;
//                case br.com.dforlani.readwithme.model.Analise.IDENTIFICACOES.NAO_MINUSCULAS:
//                    texto += getTextToShareQ12(respostas_check);
//                    break;
//            }
//        }
//        return texto;
//    }
//
//    private String getTextToShareQ14(RESPOSTAS_CHECK respostas_check) {
//        String texto = br.com.dforlani.readwithme.model.Analise.getPerguntaTextoCheckBox(PERGUNTAS.q14_1, q14_1, respostas_check.q14_1);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q14_2, q14_2);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTextoCheckBox(PERGUNTAS.q14_3, q14_3, respostas_check.q14_3);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q13_4, q13_4);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q14_5, q14_5);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q14_6, q14_6);
//
//        texto += getTextToShareQ2(respostas_check);
//
//        return texto;
//    }
//
//    private String getTextToShareQ13(RESPOSTAS_CHECK respostas_check) {
//        String texto = br.com.dforlani.readwithme.model.Analise.getPerguntaTextoCheckBox(PERGUNTAS.q13_1, q13_1, respostas_check.q13_1);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q13_2, q13_2);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q13_3, q13_3);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q13_4, q13_4);
//
//        texto += getTextToShareQ14(respostas_check);
//
//        return texto;
//    }
//
//    private String getTextToShareQ12(RESPOSTAS_CHECK respostas_check) {
//        String texto = br.com.dforlani.readwithme.model.Analise.getPerguntaTextoRadioButton(PERGUNTAS.q12_1, q12_1);
//        if (this.getQ12_1() != null) {
//            switch (this.getQ12_1()) {
//                case br.com.dforlani.readwithme.model.Analise.IDENTIFICACOES.SIM_MINUSCULAS:
//                    texto += getTextToShareQ13(respostas_check);
//                    break;
//                case br.com.dforlani.readwithme.model.Analise.IDENTIFICACOES.NAO_MINUSCULAS:
//                    texto += getTextToShareQ14(respostas_check);
//                    break;
//            }
//        }
//        return texto;
//    }
//
//    private String getTextToShareQ11(RESPOSTAS_CHECK respostas_check) {
//        String texto = br.com.dforlani.readwithme.model.Analise.getPerguntaTextoRadioButton(PERGUNTAS.q11_1, q11_1);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTextoRadioButton(PERGUNTAS.q11_2, q11_2);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTextoRadioButton(PERGUNTAS.q11_3, q11_3);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q11_4, q11_4);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTextoRadioButton(PERGUNTAS.q11_5, q11_5);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q11_6, q11_6);
//
//        texto += getTextToShareQ12(respostas_check);
//
//        return texto;
//    }
//
//    private String getTextToShareQ10(RESPOSTAS_CHECK respostas_check) {
//        String texto = br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q10_1, q10_1);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q10_2, q10_2);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q10_3, q10_3);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q10_4, q10_4);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q10_5, q10_5);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q10_6, q10_6);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q10_7, q10_7);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q10_8, q10_8);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q10_9, q10_9);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTextoCheckBox(PERGUNTAS.q10_10, q10_10, respostas_check.q10_10);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q10_11, q10_11);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q10_12, q10_12);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q10_13, q10_13);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q10_13, q10_13);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q10_13, q10_13);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q10_13, q10_13);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q10_13, q10_13);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q10_13, q10_13);
//
//        if (this.getQ10_13() != null) {
//
//            switch (this.getQ10_13()) {
//                case br.com.dforlani.readwithme.model.Analise.IDENTIFICACOES.SIM:
//                    texto += getTextToShareQ16(respostas_check);
//                    break;
//                case br.com.dforlani.readwithme.model.Analise.IDENTIFICACOES.NAO:
//                    texto += getTextToShareQ12(respostas_check);
//                    break;
//            }
//        }
//        return texto;
//    }
//
//    private String getTextToShareQ9(RESPOSTAS_CHECK respostas_check) {
//        String texto = br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q9_1, q9_1);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q9_2, q9_2);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q9_3, q9_3);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q9_4, q9_4);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q9_5, q9_5);
//
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTextoCheckBox(PERGUNTAS.q9_6, q9_6, respostas_check.q9_6);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q9_7, q9_7);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q9_8, q9_8);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q9_9, q9_9);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q9_10, q9_10);
//
//        if (this.getQ9_10() != null) {
//
//            switch (this.getQ9_10()) {
//                case br.com.dforlani.readwithme.model.Analise.IDENTIFICACOES.SIM:
//                    texto += getTextToShareQ10(respostas_check);
//                    break;
//                case br.com.dforlani.readwithme.model.Analise.IDENTIFICACOES.NAO:
//                    texto += getTextToShareQ15(respostas_check);
//                    break;
//            }
//        }
//        return texto;
//    }
//
//    private String getTextToShareQ8(RESPOSTAS_CHECK respostas_check) {
//        String texto = br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q8_1, q8_1);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q8_2, q8_2);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q8_3, q8_3);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q8_4, q8_4);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q8_5, q8_5);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q8_6, q8_6);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q8_7, q8_7);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q8_8, q8_8);
//
//        if (this.getQ8_8() != null) {
//
//            switch (this.getQ8_8()) {
//                case br.com.dforlani.readwithme.model.Analise.IDENTIFICACOES.SIM:
//                    texto += getTextToShareQ11(respostas_check);
//                    break;
//                case br.com.dforlani.readwithme.model.Analise.IDENTIFICACOES.NAO:
//                    texto += getTextToShareQ12(respostas_check);
//                    break;
//            }
//        }
//
//        return texto;
//    }
//
//    private String getTextToShareQ7(RESPOSTAS_CHECK respostas_check) {
//
//        String texto = br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q7_1, q7_1);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q7_2, q7_2);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q7_3, q7_3);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q7_4, q7_4);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q7_5, q7_5);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q7_6, q7_6);
//
//        if (this.getQ7_6() != null) {
//
//            switch (this.getQ7_6()) {
//                case br.com.dforlani.readwithme.model.Analise.IDENTIFICACOES.SIM:
//                    texto += getTextToShareQ11(respostas_check);
//
//                    break;
//                case br.com.dforlani.readwithme.model.Analise.IDENTIFICACOES.NAO:
//                    texto += getTextToShareQ12(respostas_check);
//                    break;
//            }
//        }
//        return texto;
//    }
//
//    private String getTextToShareQ6(RESPOSTAS_CHECK respostas_check) {
//
//        String texto = br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q6_1, q6_1);
//        if (getQ6_1() != null)
//            switch (this.getQ6_1()) {
//                case br.com.dforlani.readwithme.model.Analise.IDENTIFICACOES.TEXTO_INFORMATIVO:
//                    texto += getTextToShareQ7(respostas_check);
//                    break;
//                case br.com.dforlani.readwithme.model.Analise.IDENTIFICACOES.TEXTO_ARGUMENTATIVO:
//                    texto += getTextToShareQ8(respostas_check);
//                    break;
//
//                case br.com.dforlani.readwithme.model.Analise.IDENTIFICACOES.TEXTO_POESIA:
//                    texto += getTextToShareQ9(respostas_check);
//
//                    break;
//
//                case br.com.dforlani.readwithme.model.Analise.IDENTIFICACOES.TEXTO_NARRATIVO:
//                    texto += getTextToShareQ10(respostas_check);
//                    break;
//            }
//        return texto;
//    }
//
//    private String getTextToShareQ5(RESPOSTAS_CHECK respostas_check) {
//        String texto = br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q5_1, q5_1);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q5_2, q5_2);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q5_3, q5_3);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q5_4, q5_4);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q5_5, q5_5);
//
//        texto += this.getTextToShareQ6(respostas_check);
//
//        return texto;
//    }
//
//    private String getTextToShareQ4(RESPOSTAS_CHECK respostas_check) {
//        String texto = "";
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q4_1, q4_1);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q4_2, q4_2);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q4_3, q4_3);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q4_4, q4_4);
//        return texto;
//    }
//
//    private String getTextToShareQ3(RESPOSTAS_CHECK respostas_check) {
//        String texto = "";
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q3_1, q3_1);
//        return texto;
//    }
//
//    private String getTextToShareQ2(RESPOSTAS_CHECK respostasCheck) {
//        String texto = "";
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTextoRadioButton(PERGUNTAS.q2_1, q2_1);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q2_2, q2_2);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTextoRadioButton(PERGUNTAS.q2_3, q2_3);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q2_4, q2_4);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTextoRadioButton(PERGUNTAS.q2_5, q2_5);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q2_6, q2_6);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTextoRadioButton(PERGUNTAS.q2_7, q2_7);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTextoCheckBox(PERGUNTAS.q2_8, q2_8, respostasCheck.q2_8);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q2_9, q2_9);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTextoRadioButton(PERGUNTAS.q2_10, q2_10);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q2_11, q2_11);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q2_12, q2_12);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTextoRadioButton(PERGUNTAS.q2_13, q2_13);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q2_14, q2_14);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTextoRadioButton(PERGUNTAS.q2_15, q2_15);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q2_16, q2_16);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTextoCheckBox(PERGUNTAS.q2_17, q2_17, respostasCheck.q2_17);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q2_18, q2_18);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q2_19, q2_19);
//        return texto;
//    }
//
//    private String getTextToShareQ1(RESPOSTAS_CHECK respostas_check) {
//        String texto = "";
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q1_1, q1_1);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q1_2, q1_2);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q1_3, q1_3);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q1_4, q1_4);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q1_5, q1_5);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q1_6, q1_6);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q1_7, q1_7);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q1_8, q1_8);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q1_9, q1_9);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q1_10, q1_10);
//        texto += br.com.dforlani.readwithme.model.Analise.getPerguntaTexto(PERGUNTAS.q1_11, q1_11);
//
//        switch (this.getQ1_11()) {
//            case br.com.dforlani.readwithme.model.Analise.IDENTIFICACOES.ANALISE_COMPLETA:
//                texto += getTextToShareQ5(respostas_check);
//                break;
//            case br.com.dforlani.readwithme.model.Analise.IDENTIFICACOES.APENAS_ANOTACAOES:
//                texto += getTextToShareQ3(respostas_check);
//                break;
//
//            case br.com.dforlani.readwithme.model.Analise.IDENTIFICACOES.APENAS_REACOES:
//                texto += getTextToShareQ2(respostas_check);
//                break;
//
//            case br.com.dforlani.readwithme.model.Analise.IDENTIFICACOES.APENAS_RESUMOS:
//                texto += getTextToShareQ4(respostas_check);
//                break;
//        }
//
//
//        return texto;
//    }

    public static class RESPOSTAS_CHECK {
        public HashMap<String, String> q2_8 = new HashMap<>();
        public HashMap<String, String> q9_6 = new HashMap<>();
        public Context context;
        public HashMap<String, String> q10_10 = new HashMap<>();
        public HashMap<String, String> q2_17 = new HashMap<>();
        public HashMap<String, String> q13_1 = new HashMap<>();
        public HashMap<String, String> q14_1 = new HashMap<>();
        public HashMap<String, String> q14_3 = new HashMap<>();


        public RESPOSTAS_CHECK(Context context) {
            this.context = context;

//            initQ2_8();
//            initQQ9_6();
//            initQQ10_10();
//            initQ2_17();
//            initQ13_1();
//            initQ14_1();
//            initQ14_3();
        }
//
//        private void initQ14_3() {
//            q14_3.put("act_check_1Q14_3", context.getString(R.string.act_check_1Q14_3));
//            q14_3.put("act_check_2Q14_3", context.getString(R.string.act_check_2Q14_3));
//            q14_3.put("act_check_3Q14_3", context.getString(R.string.act_check_3Q14_3));
//            q14_3.put("act_check42Q14_3", context.getString(R.string.act_check42Q14_3));
//            q14_3.put("act_check52Q14_3", context.getString(R.string.act_check52Q14_3));
//            q14_3.put("act_check62Q14_3", context.getString(R.string.act_check62Q14_3));
//            q14_3.put("act_check72Q14_3", context.getString(R.string.act_check72Q14_3));
//            q14_3.put("act_check82Q14_3", context.getString(R.string.act_check82Q14_3));
//
//        }
//
//        private void initQ14_1() {
//            q14_1.put("act_check_1Q14_1", context.getString(R.string.act_check_1Q14_1));
//            q14_1.put("act_check_2Q14_1", context.getString(R.string.act_check_2Q14_1));
//            q14_1.put("act_check_3Q14_1", context.getString(R.string.act_check_3Q14_1));
//            q14_1.put("act_check_4Q14_1", context.getString(R.string.act_check_4Q14_1));
//            q14_1.put("act_check_5Q14_1", context.getString(R.string.act_check_5Q14_1));
//            q14_1.put("act_check_6Q14_1", context.getString(R.string.act_check_6Q14_1));
//        }
//
//        private void initQ13_1() {
//            q13_1.put("act_comentar_difuldade_check1_Q13_1", context.getString(R.string.act_comentar_difuldade_check1_Q13_1));
//            q13_1.put("act_comentar_difuldade_check2_Q13_1", context.getString(R.string.act_comentar_difuldade_check2_Q13_1));
//            q13_1.put("act_comentar_difuldade_check3_Q13_1", context.getString(R.string.act_comentar_difuldade_check3_Q13_1));
//            q13_1.put("act_comentar_difuldade_check4_Q13_1", context.getString(R.string.act_comentar_difuldade_check4_Q13_1));
//            q13_1.put("act_comentar_difuldade_check5_Q13_1", context.getString(R.string.act_comentar_difuldade_check5_Q13_1));
//            q13_1.put("act_comentar_difuldade_check6_Q13_1", context.getString(R.string.act_comentar_difuldade_check6_Q13_1));
//            q13_1.put("act_comentar_difuldade_check7_Q13_1", context.getString(R.string.act_comentar_difuldade_check7_Q13_1));
//        }
//
//        void initQ2_8() {
//            q2_8.put("act_reacoes_check_avaliei_mal", context.getString(R.string.act_reacoes_check_avaliei_mal));
//            q2_8.put("act_reacoes_check_texto_nao_cumpre", context.getString(R.string.act_reacoes_check_texto_nao_cumpre));
//            q2_8.put("act_reacoes_check_texto_nao_cumpre_quem_recomendou", context.getString(R.string.act_reacoes_check_texto_nao_cumpre_quem_recomendou));
//            q2_8.put("act_reacoes_check_profundidade_maior_menor", context.getString(R.string.act_reacoes_check_profundidade_maior_menor));
//            q2_8.put("act_reacoes_check_outra_coisa", context.getString(R.string.act_reacoes_check_outra_coisa));
//        }
//
//        public void initQQ9_6() {
//            q9_6.put("act_poesia_algumas_palavras", context.getString(R.string.act_poesia_algumas_palavras));
//            q9_6.put("act_poesia_o_vocabulario", context.getString(R.string.act_poesia_o_vocabulario));
//            q9_6.put("act_poesia_as_figuras", context.getString(R.string.act_poesia_as_figuras));
//            q9_6.put("act_poesia_o_tamanho", context.getString(R.string.act_poesia_o_tamanho));
//            q9_6.put("act_poesia_a_utilizacao", context.getString(R.string.act_poesia_a_utilizacao));
//            q9_6.put("act_poesia_o_equilibrio", context.getString(R.string.act_poesia_o_equilibrio));
//            q9_6.put("act_poesia_outra", context.getString(R.string.act_poesia_outra));
//        }
//
//        void initQQ10_10() {
//            q10_10.put("act_narrativo_algumas_palavras", context.getString(R.string.act_narrativo_algumas_palavras));
//            q10_10.put("act_poesia_o_vocabulario", context.getString(R.string.act_poesia_o_vocabulario));
//            q10_10.put("act_narrativo_as_figuras", context.getString(R.string.act_narrativo_as_figuras));
//            q10_10.put("act_poesia_o_tamanho", context.getString(R.string.act_poesia_o_tamanho));
//            q10_10.put("act_poesia_a_utilizacao", context.getString(R.string.act_poesia_a_utilizacao));
//            q10_10.put("act_poesia_o_equilibrio", context.getString(R.string.act_poesia_o_equilibrio));
//            q10_10.put("act_poesia_outra", context.getString(R.string.act_poesia_outra));
//        }
//
//        void initQ2_17() {
//            q2_17.put("act_reacoes_check_vida_academica", context.getString(R.string.act_reacoes_check_vida_academica));
//            q2_17.put("act_reacoes_check_prazer_e_diversao", context.getString(R.string.act_reacoes_check_prazer_e_diversao));
//            q2_17.put("act_reacoes_check_vida_profissional", context.getString(R.string.act_reacoes_check_vida_profissional));
//            q2_17.put("act_reacoes_check_producao_textos", context.getString(R.string.act_reacoes_check_producao_textos));
//            q2_17.put("act_reacoes_check_conhecimento_mundo", context.getString(R.string.act_reacoes_check_conhecimento_mundo));
//            q2_17.put("act_reacoes_check_gosto_muito", context.getString(R.string.act_reacoes_check_gosto_muito));
//
//
//        }
//    }

    public static class PERGUNTAS {
        public static final String q1_1 = " Título do texto";
        public static final String q1_2 = "Autor ou autores";
        public static final String q1_3 = "Você já conhecia o autor do texto? Já leu outros textos dele? O que achou? O que é importante registrar?";
        public static final String q1_4 = "Referência Bibliográfica";
        public static final String q1_5 = "Qual o seu objetivo ao ler o texto?";
        public static final String q1_6 = "Assunto principal do texto";
        public static final String q1_7 = "Outros assuntos do texto";
        public static final String q1_8 = "Como você chegou até o texto? O texto foi indicado por alguém? Quem? Essa informação é importante para a leitura? Por quê?";
        public static final String q1_9 = "Data de início da leitura";
        public static final String q1_10 = "Data de término da leitura";
        public static final String q1_11 = "Você quer fazer uma análise completa?";

        public static final String q2_1 = "Como você classificaria o seu interesse após 5 minutos de leitura?";
        public static final String q2_2 = "Justifique a resposta, é importante para você se conhecer como leitor:";
        public static final String q2_3 = "E na metade de leitura, como você se sentia?";
        public static final String q2_4 = "Justifique a resposta, é importante para você se conhecer como leitor:";
        public static final String q2_5 = "Como você classificaria o prazer ao final da leitura?";
        public static final String q2_6 = "Justifique a resposta, é importante para você se conhecer como leitor:";
        public static final String q2_7 = "Seu objetivo ao ler o texto foi cumprido?";
        public static final String q2_8 = "Caso a leitura não tenha sido satisfatória para o objetivo, o que aconteceu?";
        public static final String q2_9 = "Que outra coisa?";
        public static final String q2_10 = "As ideias do autor lhe agradam?";
        public static final String q2_11 = "Com que partes do texto você concorda mais? Faça citações ou paráfrases:";
        public static final String q2_12 = " Com que parte(s) do texto você discorda? Faça citações, paráfrases, discuta e apresente argumentos:";
        public static final String q2_13 = "O estilo de escrita do autor lhe agrada?";
        public static final String q2_14 = "Justifique a resposta, é importante para você se conhecer como leitor:";
        public static final String q2_15 = "O gênero desse livro lhe agrada?";
        public static final String q2_16 = "Justifique a resposta, é importante para você se conhecer como leitor:";
        public static final String q2_17 = "Você acredita que a leitura desse texto contribuiu em alguma dessas áreas?";
        public static final String q2_18 = "Justifique a resposta, citando trechos ou fazendo paráfrases:";

        public static final String q2_19 = "Você acredita que a leitura do texto contribuiria para a vida de outras pessoas? Quais? Como?";

        public static final String q3_1 = " Anotações Livres";


        public static final String q4_1 = "Resumo geral";
        public static final String q4_2 = "Resumo de capítulos";
        public static final String q4_3 = " Paráfrases (não esqueça de marcar as páginas!)";
        public static final String q4_4 = "Citações diretas (não esqueça de marcar as páginas!)";

        public static final String q5_1 = "Há algo interessante sobre as capas, a orelha ou o título do livro que você queira registrar?";
        public static final String q5_2 = "Há algo interessante sobre o projeto gráfico do livro? (formato, papel, cores, ilustrações) - em caso de texto narrativo ilustrado, haverá um guia detalhado para análise posterior.";
        public static final String q5_3 = "Há algo interessante a respeito da editora, da série ou coleção a que o livro pertence que você queira registrar?";
        public static final String q5_4 = "A edição e a data de publicação do livro são importantes para seu objetivo de leitura? Por quê? Como?";
        public static final String q5_5 = "Há apresentação, notas, apêndices? Eles são importantes para compreensão do assunto? Quem escreveu esses textos? O que é importante anotar?";

        public static final String q6_1 = "Qual tipo de texto você está lendo?";


        //******TELA Pontos importantes do texto informativo *******/
        public static final String q7_1 = "Qual o assunto principal do texto? Sintetize e/ou registre trechos importantes";
        public static final String q7_2 = "Qual o assunto principal do texto? Sintetize e/ou registre trechos importantes";
        public static final String q7_3 = "Quais as fontes utilizadas? Elas são confiáveis? É possível resgatá-las e lê-las no original?";
        public static final String q7_4 = "As informações estão completas? Há lacunas?";
        public static final String q7_5 = "Ficaram questões a ser compreendidas?";
        public static final String q7_6 = "Há pontos importantes a anotar sobre a bibliografia utilizada pelo autor?";

        public static final String q8_1 = "Qual a tese central do texto? Sintetize e/ou registre trechos importantes";
        public static final String q8_2 = "Quais os argumentos utilizados? Sintetize e/ou registre trechos importantes";
        public static final String q8_3 = "Há ilustrações, tabelas ou gráficos acompanhando o texto? São importantes? Há algo a registrar sobre elas?";
        public static final String q8_4 = "Há outros pontos importantes a ser registrados?";
        public static final String q8_5 = "Você concorda ou não com a tese? Por quê?";
        public static final String q8_6 = "Os argumentos utilizados são verdadeiros? Há fontes? Você confia nas fontes apresentadas? Você pode apresentar fontes ou argumentos contrários?";
        public static final String q8_7 = " Os argumentos estão bem construídos e concatenados? Eles suportam a tese ou não tem relação com ela?";
        public static final String q8_8 = "Há pontos importantes a anotar sobre a bibliografia utilizada pelo autor?";

        public static final String q9_1 = "A leitura foi prazerosa e interessante? Qual a impressão mais vívida provocada pela leitura?";
        public static final String q9_2 = "Há um tema central no(s) poema(s)? Em caso de coletânea, há um eixo temático que amarre os poemas entre si? Isso é importante?";
        public static final String q9_3 = "Como é a rima do poema?";
        public static final String q9_4 = "Como é a métrica do poema?";
        public static final String q9_5 = "O eu lírico se apresenta de alguma forma? Há algo a relatar?";
        public static final String q9_6 = "Questões de linguagem que podem aparecer no texto:";
        public static final String q9_7 = "Quais figuras de linguagem estão presentes no poema?";
        public static final String q9_8 = "Descreva de forma mais detalhada o que lhe chamou atenção na questão anterior, fazendo citações";
        public static final String q9_9 = "A forma como o poema se distribui na página é importante? É um poema concreto?";
        public static final String q9_10 = "O texto é um poema épico ou narrativo? Você gostaria de analisar também a história existente no poema?";

        public static final String q10_1 = "A leitura foi prazerosa e interessante? Qual a impressão mais vívida provocada pela leitura?";
        public static final String q10_2 = "O que acontece na história? Qual o enredo?";
        public static final String q10_3 = "Quem são os personagens, como são, como se relacionam? Quais são mais importantes para a história, quais são coadjuvantes?";
        public static final String q10_4 = "O que se pode registrar sobre o espaço da narrativa? Algum elemento espacial se apresenta com mais destaque?";
        public static final String q10_5 = "O que se pode registrar sobre a sequência temporal dos acontecimentos narrados? O tempo é cronológico, psicológico? Os fatos são narrados na sequência em que acontecem? Há algo específico sobre o tempo que seja interessante registrar?";
        public static final String q10_6 = "Há descrições? Como são?";
        public static final String q10_7 = "Qual o gênero literário escolhido? Isso é importante?";
        public static final String q10_8 = "Qual o tipo do narrador? Isso é importante?";
        public static final String q10_9 = "Qual o foco narrativo predominante: mostrar ou contar? Isso é importante?";
        public static final String q10_10 = "Questões de linguagem que podem aparecer no texto:";
        public static final String q10_11 = "Descreva de forma mais detalhada o que lhe chamou atenção na questão anterior, fazendo citações";
        public static final String q10_12 = "Há ilustrações acompanhando o texto? Como se relacionam com o texto? São importantes? Há algo a registrar sobre elas?";
        public static final String q10_13 = "Você gostaria de analisar as ilustrações e o projeto do gráfico mais detalhadamente?";

        public static final String q11_1 = "Você conhece alguma obra relacionada?";
        public static final String q11_2 = "São obras atuais?";
        public static final String q11_3 = "Você conhece alguma obra relacionada?";
        public static final String q11_4 = "Você considera a bibliografia adequada ao assunto do texto?";
        public static final String q11_5 = " Qual lacuna? Qual a relevância dessa lacuna para seu objetivo em ler o texto?";
        public static final String q11_6 = "Pode-se perceber algum enfoque político a partir dessas obras?";

        public static final String q12_1 = "Deseja comentar algo sobre elas? ";

        public static final String q13_1 = "Marque as dificuldades encontradas:";
        public static final String q13_2 = "Descreva de forma mais detalhada suas dificuldades, com citações:";
        public static final String q13_3 = "Como você resolveu suas dificuldades?";
        public static final String q13_4 = "Você pretende resolvê-las com alguma estratégia? Qual?";

        public static final String q14_1 = "Você consegue relacionar o texto com alguma dessas experiências?";
        public static final String q14_2 = "Descreva as experiências que acreditar mais importantes:";
        public static final String q14_3 = "Você consegue relacionar o texto com algum desses objetos culturais?";
        public static final String q14_4 = "Descreva com mais detalhes as relações marcadas na questão anterior:";
        public static final String q14_5 = "Você consegue relacionar o texto com algum texto acadêmico cujo autor concorde ou complemente as ideias apresentadas? Qual?";
        public static final String q14_6 = "Você consegue relacionar o texto com algum texto acadêmico cujo autor discorde das ideais apresentadas? Qual?";

        public static final String q15_1 = "Você gostaria de analisar as ilustrações e o projeto do gráfico mais detalhadamente?";

        public static final String q16_1 = "Qual é, ou são, o(s) artista(s) responsáveis pelo projeto gráfico ou pelas ilustrações?";
        public static final String q16_2 = "O formato do livro é diferente ou relevante? Como?";
        public static final String q16_3 = "O material utilizado na confecção do livro é diferente o relevante? Como?";
        public static final String q16_4 = "Como as ilustrações se relacionam com o texto?";
        public static final String q16_5 = "Qual é a técnica utilizada na produção das ilustrações?";
        public static final String q16_6 = "Há algo interessante a respeito das cores utilizadas? Que sensação elas te trazem?";
        public static final String q16_7 = "Há algo interessante sobre o desenho das personagens, ou de alguma personagem específica?";
        public static final String q16_8 = "Há algo interessante sobre os espaços e cenários desenhados?";
        public static final String q16_9 = "Há coisas interessantes a se relatar sobre objetos de cena desenhados? Há algum objeto de cena específico que mereça destaque?";
        public static final String q16_10 = "O que mais é possível dizer a respeito das ilustrações?";
    }

    public class IDENTIFICACOES {

        public static final String SIM = "Sim";
        public static final String NAO = "Não";

        public static final String SIM_MINUSCULAS = "Sim";
        public static final String NAO_MINUSCULAS = "Não";


        public static final String TEXTO_INFORMATIVO = "informativo";
        public static final String TEXTO_ARGUMENTATIVO = "argumentativo";
        public static final String TEXTO_POESIA = "poesia";
        public static final String TEXTO_NARRATIVO = "narrativo";

        public static final String APENAS_ANOTACAOES = "apenas_anotacoes";

        private static final String APENAS_ANOTACAOES_COMPLETE = "Anotações livres";
        public static final String APENAS_REACOES = "apenas_reacoes";
        private static final String APENAS_REACOES_COMPLETE = "Reações";
        public static final String APENAS_RESUMOS = "apenas_resumos";
        private static final String APENAS_RESUMOS_COMPLETE = "Resumos, citações e paráfrases";
        public static final String ENCERRAR = "encerrar";
        private static final String ENCERRAR_COMPLETO = "Análise simples";
        public static final String ANALISE_COMPLETA = "analise_completa";
        private static final String ANALISE_COMPLETA_COMPLETO = "Análise completa";

    }

    public void remover(String email, Context context) {
//        this.deleteSubDocument(Usuario.COLECAO, email, br.com.dforlani.readwithme.model.Analise.COLECAO, this.id, context);
    }
}
}