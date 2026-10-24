# TP0 – Introduction à Jakarta EE 11

Application web : **Maven + CDI + JSF (Jakarta Faces)**, déployée sur **Payara Server**.

- groupId : `org.example` · artifactId : `TP0JakartaEE` · version : `1.0-SNAPSHOT`
- JDK 25 · Jakarta EE 11 · packaging `war`

## Structure
- `GreetingService` : bean CDI `@ApplicationScoped`
- `HelloBean` : managed bean `@Named @RequestScoped` (injection `@Inject`)
- `index.xhtml` : page JSF (formulaire + message)

## Build
```
mvn clean package
```
Produit `target/TP0JakartaEE.war`.

## Déploiement sur Payara
```
asadmin start-domain
asadmin deploy target/TP0JakartaEE.war
```
Puis ouvrir http://localhost:8080/TP0JakartaEE/

Dans IntelliJ : Run > Edit Configurations > + > Payara Server > Local, artefact `TP0JakartaEE:war exploded`.

## Git / GitHub
```
git init
git add .
git commit -m "TP0 Jakarta EE : projet Maven CDI + JSF"
git branch -M main
git remote add origin https://github.com/<utilisateur>/TP0JakartaEE.git
git push -u origin main
```
