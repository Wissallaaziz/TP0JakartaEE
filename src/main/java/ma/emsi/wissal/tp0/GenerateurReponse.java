package ma.emsi.wissal.tp0;

import jakarta.enterprise.context.Dependent;

@Dependent
public class GenerateurReponse {

    public String generer(String question, String role, boolean premiereQuestion) {
        String questionTraitee = question.trim().toUpperCase();
        StringBuilder reponse = new StringBuilder();

        if (premiereQuestion) {
            reponse.append("ROLE : ")
                   .append(role.toUpperCase())
                   .append("\n");
        }

        switch (role) {
            case "Traducteur français-anglais" ->
                reponse.append("Traduction demandée : ");

            case "Guide touristique" ->
                reponse.append("Guide touristique : ");

            default ->
                reponse.append("Assistant : ");
        }

        reponse.append("||")
               .append(questionTraitee)
               .append("||");

        return reponse.toString();
    }
}
