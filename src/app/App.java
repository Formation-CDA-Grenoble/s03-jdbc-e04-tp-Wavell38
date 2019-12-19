package app;

import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        ResultSet resultSet = DBManager.sendQuery(
            "SELECT * FROM `user`"
        );

        while (resultSet.next()) {
            System.out.println("User #" + resultSet.getString(1) + ": " + resultSet.getString(2));
        }

        //Quelles sont les marques enregistrées dans notre base de données?
        resultSet = DBManager.sendQuery(
            "SELECT * FROM `brand`"
        );

        //Combien y a-t-il de produits de la marque Nokia?
        resultSet = DBManager.sendQuery(
            "SELECT COUNT(*) FROM `product` JOIN `brand` ON `product`.`brand_id` = `brand`.id WHERE `brand`.`name` = 'Nokia'"
        );

        //Geneviève a-t-elle déjà passé une commande?
        resultSet = DBManager.sendQuery(
            "SELECT * FROM `_order` JOIN `user` ON `_order`.`user_id` = `user`.id WHERE `user`.`name` = 'Geneviève'"
        );

        //Quelle est l'adresse de livraison de Stéphanie?
        resultSet = DBManager.sendQuery(
            "SELECT `address` FROM `shipping_order` JOIN `user` ON `user`.id = `shipping_order`.`user_id` WHERE `user`.`name` = 'Stéphanie'"
        );

        //Quelles est la commande passée la plus récemment?
        resultSet = DBManager.sendQuery(
            "SELECT * FROM `_order` ORDER BY DESC LIMIT 1"
        );
    }
}