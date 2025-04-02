package com.interfazgrafica.version1.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.interfazgrafica.version1.services.FirebaseService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class MyController {

    @Autowired
    private FirebaseService firebaseService;

    // Guardar datos genéricos (con ID automático)
    @PostMapping("/save/{collectionName}")
    public String saveData(
            @PathVariable String collectionName,
            @RequestBody Object data) throws Exception {
        firebaseService.saveData(collectionName, data);
        return "Datos guardados en la colección: " + collectionName;
    }

    // Guardar ticket (con ID automático)
    @GetMapping("/test-save/{name}")
    public String saveTicket(
            @PathVariable String name,
            @RequestParam String responsible,
            @RequestParam String deadline) throws Exception {
        
        Map<String, Object> ticketData = new HashMap<>();
        ticketData.put("nombre", name);
        ticketData.put("responsable", responsible);
        ticketData.put("fechaEntrega", deadline);
        
        firebaseService.saveData("tickets", ticketData);
        
        return "Ticket guardado: " + name + ", Responsable: " + responsible + ", Fecha: " + deadline;
    }

    // Registrar usuario (con ID específico)
    @GetMapping("/register")
    public String registerUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email) throws Exception {
        
        Map<String, Object> userData = new HashMap<>();
        userData.put("username", username);
        userData.put("password", password);
        userData.put("email", email);
        
        firebaseService.saveDataWithId("usuarios", username, userData);
        
        return "Usuario registrado: " + username + ", Email: " + email;
    }

    @GetMapping("/login")
    public ResponseEntity<?> loginUser(
            @RequestParam String user,
            @RequestParam String password) throws Exception {
    
        boolean isValid = firebaseService.verifyCredentials("usuarios", user, password);
    
        if (isValid) {
            return ResponseEntity.ok().body("Login correcto");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }

}