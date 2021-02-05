package com.example.podcastlisten.models;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModelFirestore {
    private static final String TAG = "ModelFirestore.class:";
    public static FirebaseFirestore db;
    public static FirebaseStorage storage;

    public ModelFirestore() {

    }

    static {
        db = FirebaseFirestore.getInstance();
        storage = FirebaseStorage.getInstance();

    }

    /**
     * Busca numa coleção pelo campo e valor passados
     *
     * @param colecao
     * @param campo
     * @param valor
     * @return
     */
    protected static QueryDocumentSnapshot find(String colecao, String campo, String valor) {
        // [START listen_state]
        final QueryDocumentSnapshot[] nova = {null};
        db.collection(colecao)
                .whereEqualTo(campo, valor)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                nova[0] = document;
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                            nova[0] = null;
                        }
                    }
                });

        return nova[0];
        // [END listen_state]
    }

    public static ArrayList<QueryDocumentSnapshot> findAllSubDocumentsByParentDocument(String colecaoParent, String documentIdParent, String colecaoSon) {

        CollectionReference col = db.collection(colecaoParent).document(documentIdParent).collection(colecaoSon);

        final ArrayList<QueryDocumentSnapshot> listDocs = new ArrayList<>();

        col//.whereEqualTo("email", documentIdParent)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                listDocs.add(document);
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
        return listDocs;
        // [END listen_state]
    }

    protected static List<QueryDocumentSnapshot> findAllByFatherDocumentWithWhere(final String colecaoPai, String campoPai, String valorPai, final String colecaoFilho) {
        // [START listen_state]
        final ArrayList<QueryDocumentSnapshot> listDocs = new ArrayList<>();


        db.collection(colecaoPai)
                .whereEqualTo(campoPai, valorPai)

                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());


                                db.collection(colecaoPai)
                                        .document(document.getId())
                                        .collection(colecaoFilho)
                                        .get()
                                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                            @Override
                                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                                if (task.isSuccessful()) {

                                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                                        Log.d(TAG, document.getId() + " => " + document.getData());
                                                        listDocs.add(document);

                                                    }
                                                } else {
                                                    Log.w(TAG, "Error getting documents.", task.getException());
                                                }
                                            }
                                        })
                                ;

                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
        return listDocs;
        // [END listen_state]
    }

    /**
     * Insere um novo documento na base de dados.
     *
     * @param colecao
     * @param data    Exemplo:        Map<String, Object> data = new HashMap<>();
     *                data.put("name", "Tokyo");
     *                data.put("country", "Japan");
     */
    public static void addDocument(String colecao, Map<String, Object> data) {
        // Add a new document with a generated id.
        db.collection(colecao)
                .add(data)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);

                    }
                });
        // [END add_document]
    }


    /**
     * Insere um novo documento na base de dados com uma dada ID
     *
     * @param colecao
     * @param data       Exemplo:        Map<String, Object> data = new HashMap<>();
     *                   data.put("name", "Tokyo");
     *                   data.put("country", "Japan");
     * @param documentId //id do documento
     */
    public static void addDocument(String colecao, Map<String, Object> data, String documentId) {
        // Add a new document with a generated id.
        //teste();
        DocumentReference doc = db.collection(colecao).document(documentId);

        doc.set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "Usuário salvo com sucesso!");

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Erro ao adicionar usuário", e);

                    }
                });
        // [END add_document]
    }

    public void addSubDocument(Analise analise, String colecaoParent, String documentIdParent, String colecaoSon, Map<String, Object> data) {

        CollectionReference col = db.collection(colecaoParent).document(documentIdParent).collection(colecaoSon);
        OnSuccessListener onSuccessListener = new OnSucessListenerAnalise(analise);

        col.add(data)
                .addOnSuccessListener(onSuccessListener)
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);

                    }
                });
    }

    public void updateSubDocument(String colecaoParent, String documentIdParent, String colecaoSon, String documentIdSon, Map<String, Object> data) {

        DocumentReference doc = db.collection(colecaoParent).document(documentIdParent).collection(colecaoSon).document(documentIdSon);

        doc.update(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "Alteração enviada com sucesso ");
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "Não foi possível salvar ");
            }
        });
    }

    public void setSubDocument(String colecaoParent, String documentIdParent, String colecaoSon, String documentIdSon, Map<String, Object> data) {

        DocumentReference doc = db.collection(colecaoParent).document(documentIdParent).collection(colecaoSon).document(documentIdSon);

        doc.set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "Alteração enviada com sucesso ");
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "Não foi possível salvar ");
            }
        });
    }

    class OnSucessListenerAnalise implements OnSuccessListener<DocumentReference> {
        private Analise analise;

        public OnSucessListenerAnalise(Analise analise) {
            super();
            this.analise = analise;
        }

        @Override
        public void onSuccess(DocumentReference documentReference) {
            analise.setId(documentReference.getId());
        }
    }

    public void deleteSubDocument(String colecaoParent, String documentIdParent, String colecaoSon, String documentIdSon, final Context context) {

        if (colecaoParent != null && documentIdParent != null && colecaoSon != null && documentIdSon != null) {
            DocumentReference col = db.collection(colecaoParent).document(documentIdParent).collection(colecaoSon).document(documentIdSon);
            // [START delete_document]
            col
                    .delete()
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(context, "Análise removida com sucesso", Toast.LENGTH_LONG).show();
                            Log.d(TAG, "DocumentSnapshot successfully deleted!");
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(context, "Ocorreu um erro e não foi possível remover essa análise.", Toast.LENGTH_LONG).show();
                            Log.w(TAG, "Error deleting document", e);
                        }
                    });
            // [END delete_document]
        }
    }
}
