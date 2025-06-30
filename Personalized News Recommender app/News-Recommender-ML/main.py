
from fastapi import FastAPI
from model import RecommendationRequest
from recommender import recommend_articles
import json

app = FastAPI()  

with open("dummy_news.json", "r", encoding="utf-8") as f:
    all_articles = json.load(f)

@app.post("/recommend")
def recommend(request: RecommendationRequest):
    user_text = " ".join(request.interests + [a.title + " " + a.description for a in request.recentArticles])
    recommended = recommend_articles(user_text, all_articles)
    return {"recommendations": recommended}
