package com.interfazgrafica.version1.services;

<<<<<<< HEAD
import java.util.Map;
=======
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

>>>>>>> ba230306af08ef4a56b15810bafb6a49185a2c3e
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

<<<<<<< HEAD
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseService {

    private Firestore getFirestore() {
        return FirestoreClient.getFirestore();
    }

    // Guarda datos con ID automático
    public void saveData(String collectionName, Object data) throws ExecutionException, InterruptedException {
        getFirestore().collection(collectionName)
                     .add(data)
                     .get();
    }

    // Guarda datos con ID específico
    public void saveDataWithId(String collectionName, String documentId, Object data) 
            throws ExecutionException, InterruptedException {
        getFirestore().collection(collectionName)
                     .document(documentId)
                     .set(data)
                     .get();
    }

    // Obtiene un documento por ID
    public DocumentSnapshot getDocument(String collectionName, String documentId) 
            throws InterruptedException, ExecutionException {
        return getFirestore()
                .collection(collectionName)
                .document(documentId)
                .get()
                .get();
    }

    // Obtiene los datos de un documento
    public Map<String, Object> getData(String collectionName, String documentId) 
            throws ExecutionException, InterruptedException {
        DocumentSnapshot document = getDocument(collectionName, documentId);
        return document.exists() ? document.getData() : null;
    }

    // Verifica credenciales
    public boolean verifyCredentials(String collectionName, String username, String password) 
            throws InterruptedException, ExecutionException {
        DocumentSnapshot userDoc = getDocument(collectionName, username);
        
        if (!userDoc.exists()) {
            return false;
        }
        
        String storedPassword = userDoc.getString("password");
        return storedPassword != null && storedPassword.equals(password);
=======
@Service
public class FirebaseService {

    public void saveData(String collectionName, Object data) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore(); // Obtiene la instancia de Firestore
        db.collection(collectionName)                 // Selecciona la colección
          .add(data)                                 // Guarda los datos y genera un ID automático
          .get();                                    // Espera a que se complete la operación
    }

    public Object getData(String collectionName, String documentId) throws Exception {
        Firestore db = FirestoreClient.getFirestore();
        return db.collection(collectionName).document(documentId).get().get().getData();
>>>>>>> ba230306af08ef4a56b15810bafb6a49185a2c3e
    }
}