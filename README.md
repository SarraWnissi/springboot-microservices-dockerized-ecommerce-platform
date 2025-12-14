# 🧩 Microservices E-commerce – Spring Boot, Docker & Spring Cloud

Plateforme **microservices e-commerce** totalement **dockerisée**, basée sur **Spring Boot**, **Spring Cloud**, et plusieurs bases de données (**MySQL, PostgreSQL, MongoDB**) pour illustrer une architecture moderne et scalable.

---

## 🚀 Aperçu du projet

Ce projet démontre une architecture microservices complète pour un système de facturation / e-commerce, incluant :

- 🔎 **Eureka Server** pour la découverte de services
- 🚪 **API Gateway** pour le routage des requêtes
- 👤 **Customer Microservice** (PostgreSQL)
- 📦 **Product Microservice** (MongoDB)
- 🧾 **Facture Service** (MySQL)
- 🐳 **Docker & Docker Compose** pour l’orchestration des services

L’objectif est de rendre l’exécution **simple, reproductible et portable**, quel que soit l’environnement.

---

## 🛠️ Stack technique

- **Java 21 / 22**
- **Spring Boot 3.x**
- **Spring Cloud (Eureka, Gateway)**
- **Spring Data JPA / MongoDB**
- **MySQL 8**
- **PostgreSQL 15**
- **MongoDB**
- **Docker & Docker Compose**
- **Maven**

---
springboot-microservices-dockerized-ecommerce-platform/
├── eureka-server/
│ ├── src/...
│ └── Dockerfile
├── api-gateway/
│ ├── src/...
│ └── Dockerfile
├── customer-microservice/
│ ├── src/...
│ └── Dockerfile
├── product-microservice/
│ ├── src/...
│ └── Dockerfile
├── factureService/
│ ├── src/...
│ └── Dockerfile
├── docker-compose.yml
└── README.md



---

## 🧱 Dockerisation des microservices

Chaque microservice possède un `Dockerfile` à sa racine :

FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE XXXX

ENTRYPOINT ["java","-jar","app.jar"]


Adapter `EXPOSE` selon le microservice :

| Microservice        | Port |
|---------------------|------|
| Eureka Server       | 8761 |
| API Gateway         | 8888 |
| Customer Service    | 8081 |
| Product Service     | 8082 |
| Facture Service     | 8083 |

Exemple pour le **Customer Microservice** :

EXPOSE 8081



---

## 🐳 Orchestration avec Docker Compose

Fichier `docker-compose.yml` à la racine du projet :


---

## 🔨 Build & Run

### 1️⃣ Compiler tous les microservices

Dans chaque dossier de microservice (`eureka-server`, `api-gateway`, `customer-microservice`, `product-microservice`, `factureService`) :

mvn clean package -DskipTests


Assure-toi que le `.jar` est bien généré dans `target/`.

---

### 2️⃣ Lancer toute la plateforme avec Docker

Depuis la racine du projet (là où se trouve `docker-compose.yml`) :
docker compose up --build

Pour lancer en arrière-plan :docker compose up --build -d

📦 Lister les conteneurs :
docker ps

text
Tous les services doivent être en `STATUS Up`.

- 🌐 Eureka Dashboard :
- Ouvrir : `http://localhost:8761`
- Vérifier que les services `CUSTOMER-MICROSERVICE`, `PRODUCT-MICROSERVICE`, `FACTURESERVICE`, `API-GATEWAY` sont enregistrés.

- 🔁 Accès API :
- Direct :
  - `http://localhost:8081/...`
  - `http://localhost:8082/...`
  - `http://localhost:8083/...`
- Via API Gateway (recommandé) :
  - `http://localhost:8888/...` (routes à définir dans la configuration Gateway)

---
<img width="1880" height="890" alt="Capture d&#39;écran 2025-12-14 161625" src="https://github.com/user-attachments/assets/f9b6c3ad-5602-41f4-b37a-7ca7d71f4d63" />

## 📌 Notes importantes

- Ne pas utiliser `localhost` dans les `application.properties` côté Docker, mais les **noms de services** (ex : `mysql-facturation`, `postgres-facturation`, `mongo-facturation`, `eureka-server`).
- Les **volumes** (`mysql_data`, `mongo_data`, `postgres_data`) garantissent la **persistance des données**, même si les conteneurs sont supprimés.
- Éviter `spring.jpa.hibernate.ddl-auto=create` en production, utiliser `update` ou `validate` pour ne pas perdre les données.

---

## 👩‍💻 Auteur

**Sarra Wnissi**  
Étudiante en informatique – Spring Boot, Microservices & Docker

- 💻 GitHub : `@sarrawnissi`  
- 🔗 LinkedIn : [Sarra Ounissi](https://www.linkedin.com/in/sarra-ounissi-1881b8247/)  


## ⭐ Contribution & Support

- N’hésite pas à **fork** le projet, proposer des **issues** ou des **pull requests**.
- Si ce projet t’a aidé, laisse une ⭐ sur le repository !


**Fait avec ❤️ par Sarra Wnissi**









## 📂 Structure du repository

