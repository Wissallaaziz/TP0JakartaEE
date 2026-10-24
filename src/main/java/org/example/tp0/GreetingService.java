package org.example.tp0;

import jakarta.enterprise.context.ApplicationScoped;

/** Bean CDI applicatif : service injecté dans le managed bean. */
@ApplicationScoped
public class GreetingService {

    public String greet(String name) {
        if (name == null || name.isBlank()) {
            return "Bonjour, inconnu(e) !";
        }
        return "Bonjour, " + name.trim() + " ! Bienvenue dans Jakarta EE 11.";
    }
}
