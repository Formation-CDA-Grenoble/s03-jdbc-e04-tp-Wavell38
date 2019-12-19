# Réponse au quiz

1. Combien de colonnes aura la table **question** en base de données? Donne le nom de chacune de ces colonnes.
    - La table question aura cinq colonnes.
    - id
    - description
    - difficulty
    - point
    - quiz_id
    - correct_answer_id

2. Quelle fonctionnalité de l'application est décrite par la relation **Quiz** _written by_ **User**? Essaie d'exprimer cette fonctionnalité sous la forme d'une _user story_ ("en tant que ..., j'ai besoin de ... afin de ...").
    - En tant qu'utilisateur, j'ai besoin de connaitre qui a écrit un quiz afin de pouvoir en faire d'autre que cette personne a créé ou de pouvoir filtrer les quiz par créateur ou encore consulter les quiz qu'il a créé sur son profil.

3. La relation **Quiz** _written by_ **User** a un losange blanc, alors que la relation **Question** _belongs to_ **Quiz** a un losange noir. Peux-tu expliquer la différence entre ces deux relations?
    - Le losange blanc **Quiz** _written by_ **User** il s'agit d'une relation d'agrégation. Donc quand on supprime un user ca ne supprimera pas les quiz liés. A la différence de la relation de composition entre **Question** _belongs to_ **Quiz**. Donc quand on supprime un quiz les questions liés sont supprimées.

4. Combien de question peut-il y avoir dans un questionnaire (minimum et maximum)?
    - Il peut y avoir au minimum une question et au maximum quatre questions dans un questionnaire.

5. Combien de réponses chaque question peut-elle avoir (minimum et maximum)?
    - Il peut y avoir une seule réponse pour chaque question.

6. Que se passe-t-il si je supprime une question?
    - Les réponses associées seront supprimées.

7. Que se passe-t-il si je supprime un utilisateur?
    - Tout les champs liés à user_id dans la table QuizResult seront supprimés.

8. Comment pourrons-nous coder la relation **Tag** _describes_ **Quiz** dans notre base de données?
    - Il s'agit d'une relation ManyToMany donc en créant une nouvelle table tags_in_quizs avec id, quiz_id, tag_id.

9. Combien de clés étrangères la table **Quiz** possède-t-elle? Nomme chacune de ces clés.
    - Une seule. user_id. Elle devrait s'appeler fk_quiz_user_id.

10. Pourquoi y a-t-il deux relations entre **Answer** et **Question**?
    - Une relation pour les réponses possibles et une autre pour la réponse correcte.

11. Peux-tu expliquer pourquoi la classe **QuizResult** se trouve entre les classes **User** et **Quiz**?
    - Parce qu'il s'agit d'une relation ManyToMany et il faut donc créer une nouvelle table QuizResult.

12. Si un utilisateur souhaite tenter à nouveau un questionnaire, est-il prévu qu'il puisse voir à quelles questions il avait bien répondu précédemment? Si oui, où peut-on le voir sur le diagramme? Si non, que faudrait-il rajouter sur le diagramme pour pouvoir l'exprimer?
    - Il faudrait rajouter une relation ManyToMany entre QuizResult et Question. On ajoute les questions dans une table quand le user a bien répondu.