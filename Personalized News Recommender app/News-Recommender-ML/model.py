from typing import List
from pydantic import BaseModel

class ArticleDTO(BaseModel):
    title: str
    description: str
    url: str
    category: str



class RecommendationRequest(BaseModel):
    userId: int
    username: str
    interests: List[str]
    recentArticles: List[ArticleDTO]