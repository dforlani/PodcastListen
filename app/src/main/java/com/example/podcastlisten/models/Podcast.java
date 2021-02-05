package com.example.podcastlisten.models;

import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.HashMap;
import java.util.Map;

public class Podcast extends ModelFirestore {
    private static final String TAG = "Podcast.class";


    private static final String CAMPO_NOME = "nome";
    private static final String CAMPO_DESCRICAO = "descricao";
    private static final String CAMPO_LINK = "link";

    public static final String COLECAO = "Podcast";


    private String nome;
    private String link;

    public Podcast(String id, String nome, String link) {
        this.id = id;
        this.nome = nome;
        this.link = link;
    }


    public Podcast(String nome, String link) {

        this.nome = nome;
        this.link = link;
    }

    public Podcast(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    /**
     * Cria um podcast passado caso ele não exista para um dado usuario
     */
    public void salvaPodcast() {

        if (nome != null && link != null && link.trim().length() > 0) {
            //se não tiver criado, o sistema cria uma nova coleção pra esse email


            Podcast.addSubDocumentToUser(COLECAO, this);

        }

    }

    @Override
    Map<String, Object> toMap() {
        Map<String, Object> data = new HashMap<>();
        data.put(CAMPO_ID, id);
        data.put(CAMPO_NOME, nome );
        data.put(CAMPO_LINK, link);
        return  data;
    }
}
