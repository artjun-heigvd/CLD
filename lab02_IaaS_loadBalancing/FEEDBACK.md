# Feedback - CLD lab 2 - App scaling on IaaS

## Groupe
* GrE
* Edwin Häffner
* Arthur Junod

## TASK 1: CREATE A DATABASE USING THE RELATIONAL DATABASE SERVICE (RDS)

* L'estimation des coûts mensuels du RDS est dans la plage attendue. Par contre, l'estimation des coûts mensuels de l'instance EC2 est trop basse. Il manque en fait le coût de l'adresse IPV4 qui est incluse dans le RDS. Il faudrait donc ajouter 3.65$ par mois pour l'adresse IPV4 de l'instance EC2. Selon les calculs du feedback 1, le coût total mensuel de l'instance EC2 devrait être d'environ 13.718$ ce qui rapproche sensiblement le coût total mensuel de l'instance EC2 et du RDS.

## TASK 2: CONFIGURE THE WORDPRESS MASTER INSTANCE TO USE THE RDS DATABASE

* Rien à signaler.

## TASK 3: CREATE A CUSTOM VIRTUAL MACHINE IMAGE

* Rien à signaler.

## TASK 4: CREATE A LOAD BALANCER

* Rien à signaler.

## TASK 5: LAUNCH A SECOND INSTANCE FROM THE CUSTOM IMAGE

* Concernant le diagramme, les security groups ne sont pas des pare-feux, mais plutôt des configurations pour les pare-feux. Il faudrait donc représenter un pare-feu devant chaque entité.

## TASK 5B: DELETE AND RE-CREATE THE LOAD BALANCER USING THE COMMAND LINE INTERFACE

* Rien à signaler.

## TASK 6: TEST THE DISTRIBUTED APPLICATION

* Il est un peu dommage d'avoir testé dans le premier cas l'URL /wp-admin plutôt que votre post. C'est moins représentatif d'un cas d'utilisation réel puisque les utilisateurs finaux consulteront plutôt des posts que l'interface d'administration.
* Vous n'avez pas été très critique sur le test, mais plutôt sur le résultat ou sur le peu de conclusion que vous avez pu en tirer. Il aurait pu être intéressant de mentionner que le test provient d'une seule source, qu'il est dirigé vers une seule URL en GET et qu'il est actif durant une courte période. Ces trois points sont importants pour juger de la robustesse de votre application face à un trafic réel.