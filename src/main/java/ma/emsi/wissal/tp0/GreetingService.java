package ma.emsi.wissal.tp0;

import jakarta.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class GreetingService {

    public String greet(String name) {
        if (name == null || name.isBlank()) {
            return "Bonjour, inconnu(e) !";
        }
        return "Bonjour, " + name.trim() + " ! Bienvenue dans Jakarta EE 11.";
    }
}
