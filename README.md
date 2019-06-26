# Projet Spring 5 /Hibernate 5 creation de site autour de l'escalade

## Technologies utilisées:
    •       JDK 8
	•	Spring MVC - 5.1.0 RELEASE
	•	Hibernate - 5.2.17.Final
	•	Maven - 3.5.1
	•	Apache Tomcat - 9.0.19
	•	mySQL 5.6.41
	•	Eclipse Ice for Entreprise Java developers 4.11.0
	•	Bootstrap 3.3.7
	•	JSTL - 1.2.1
	•	JSP - 2.3.1

## Build
```
mvn clean install
```

## Deployer  war

Copier le WAR dans le dossier webapps de Tomcat 9 et lancer le serveur avec les commandes:

```
./startup.sh

tail -f logs/catalina.out
```

Puis à l'aide de votre navigateur aller à:
```
http://localhost:8080/springmvc_webapp_OCP6/account
```

Utiliser le password 123 pour les utilisateurs test_user, toto et admin


## Auteur
Joseph Herradi
