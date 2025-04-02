package com.interfazgrafica.version1.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
public class MyController {

    @Autowired
    private FirebaseService firebaseService;

    @PostMapping("/save/{name}")
    public String saveData(
            @PathVariable String name,
            @RequestBody Object data
    ) throws Exception {
        String collectionName = "users";
        firebaseService.saveData(collectionName, data);
        return "Data saved successfully for user: " + name;
    }

    // Endpoint para guardar tickets (GET)
    @GetMapping("/test-save/{name}")
    public String saveTicket(
            @PathVariable String name,
            @RequestParam String responsible,
            @RequestParam String deadline
    ) throws Exception {
        String collectionName = "tickets";
        
        Map<String, Object> ticketData = new HashMap<>();
        ticketData.put("nombre", name);
        ticketData.put("responsable", responsible);
        ticketData.put("fechaEntrega", deadline);
        
        firebaseService.saveData(collectionName, ticketData);
        
        return "Ticket guardado: " + name + 
               ", Responsable: " + responsible + 
               ", Fecha: " + deadline;
    }
}