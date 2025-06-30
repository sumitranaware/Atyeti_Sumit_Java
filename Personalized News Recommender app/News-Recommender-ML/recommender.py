from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import cosine_similarity
def recommend_articles(user_text,all_articles,top_k=5):
    documents=[user_text]+[a["title"]+" "+a["description"]for a in all_articles]
    vectorizer =TfidfVectorizer(stop_words='english')
    tfidf_matrix=vectorizer.fit_transform(documents)

    similarity_scores=cosine_similarity(tfidf_matrix[0:1],tfidf_matrix[1:]).flatten()

    top_indicates=similarity_scores.argsort()[::-1][:top_k]
    return [all_articles[i]for i in top_indicates]