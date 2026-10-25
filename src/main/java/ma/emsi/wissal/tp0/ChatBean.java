package ma.emsi.wissal.tp0;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Dependent
class GenerateurReponse {

    public String generer(String question, String role, boolean premiereQuestion) {
        StringBuilder message = new StringBuilder();

        if (premiereQuestion) {
            message.append("Bonjour ! ");
        }

        message.append("Je peux vous aider en tant que ")
               .append(role)
               .append(". Votre question : ")
               .append(question);

        return message.toString();
    }
}

@Named("chatBean")
@ViewScoped
public class ChatBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private GenerateurReponse generateurReponse;

    private String question;
    private String reponse;
    private String role;

    private boolean roleVerrouille = false;

    private final List<String> historique = new ArrayList<>();

    public void envoyer() {
        if (question == null || question.isBlank()) {
            afficherErreur("Veuillez saisir une question.");
            return;
        }

        if (role == null || role.isBlank()) {
            afficherErreur("Veuillez choisir un rôle avant d'envoyer votre question.");
            return;
        }

        if (roleVerrouille && !role.equals(this.role)) {
            afficherErreur("Pour changer de rôle, veuillez commencer un nouveau chat.");
            return;
        }

        boolean premiereQuestion = historique.isEmpty();

        roleVerrouille = true;

        reponse = generateurReponse.generer(
            question,
            role,
            premiereQuestion
        );

        historique.add("Vous : " + question.trim());
        historique.add("Réponse : " + reponse);

        question = "";
    }

    public void nouveauChat() {
        question = "";
        reponse = "";
        role = null;
        roleVerrouille = false;
        historique.clear();
    }

    public void effacerDerniereQuestion() {
        if (historique.size() >= 2) {
            historique.remove(historique.size() - 1);
            historique.remove(historique.size() - 1);
        }

        question = "";
        reponse = historique.isEmpty()
            ? ""
            : historique.get(historique.size() - 1).replace("Réponse : ", "");
    }

    private void afficherErreur(String message) {
        FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null)
        );
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if (!roleVerrouille) {
            this.role = role;
        }
    }

    public boolean isRoleVerrouille() {
        return roleVerrouille;
    }

    public List<String> getHistorique() {
        return historique;
    }

    public String getHistoriqueAsText() {
        return String.join("\n", historique);
    }
}
