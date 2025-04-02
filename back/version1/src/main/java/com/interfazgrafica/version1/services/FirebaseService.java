package com.interfazgrafica.version1.services;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

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
    }
}