#  Personalized News Recommender System

A full-stack application that delivers personalized news based on user interests and preferred categories. It integrates:

-  Spring Boot (Java) — for fetching real-time news from [GNews API](https://gnews.io/)
-  FastAPI (Python) — for machine learning-based article recommendation
-  React.js — for an interactive frontend UI

---

##  Features

-  Search news by category (e.g., general, health, sports)
-  Enter your interests to get personalized recommendations
-  Recommends relevant news using NLP (TF-IDF + Cosine Similarity)
-  Full integration across Spring Boot → FastAPI → React
-  Containerized (Docker-ready)

---


---

##  Technologies Used

| Layer        | Tech Stack                                |
|--------------|--------------------------------------------|
| Frontend     | React 18.2, Bootstrap, Axios               |
| Backend      | Spring Boot, WebClient, Jackson, Lombok    |
| ML Service   | Python 3.11, FastAPI, scikit-learn         |
| Communication| REST APIs, Axios, CORS-enabled             |
| External API | [GNews API](https://gnews.io/)             |

---

##  How It Works

1. **User selects category and enters interests** in the React frontend.
2. **Spring Boot** fetches live news from GNews API based on selected category.
3. These articles are sent to **FastAPI**, which uses NLP to recommend the most relevant articles.
4. Final recommended articles are displayed back in the frontend.

---
