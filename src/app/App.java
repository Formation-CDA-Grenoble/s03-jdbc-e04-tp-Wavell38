package app;

import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        ResultSet users = DBManager.sendQuery(
            "SELECT * FROM `user`"
        );

    - Quelles sont les marques enregistrées dans notre base de données?
    - Combien y a-t-il de produits de la marque Nokia?
    - Geneviève a-t-elle déjà passé une commande?
    - Quelle est l'adresse de livraison de Stéphanie?
    - Quelles est la commande passée la plus récemment?
    - Combien d'articles y a-t-il dans la commande passée par Jean-Pierre?
    - Quel article a commandé Michel dans sa dernière commande?

        while (users.next()) {
            System.out.println("User #" + users.getString(1) + ": " + users.getString(2));
        }
    }
}