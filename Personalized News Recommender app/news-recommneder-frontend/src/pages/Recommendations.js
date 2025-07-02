import React, { useEffect, useState } from "react";
import { fetchArticles } from "../api/springApi";
import { fetchRecommendations } from "../api/fastApi"; 
import Loader from "../components/Loader";
import NewsCard from "../components/NewsCard";

const Recommendations = () => {
  const [interests, setInterests] = useState("");
  const [articles, setArticles] = useState([]);
  const [recommended, setRecommended] = useState([]);
  const [loading, setLoading] = useState(false);

  const getArticles = async () => {
    try {
      const res = await fetchArticles(); 
      setArticles(res.data)
      console.log("loading")
    } catch (err) {
      console.error("Error fetching articles:", err);
    }
  };

const handleRecommend = async () => {
  setLoading(true);

  try {
    const springRes = await fetchArticles(interests); // dynamic category
    const articlesFromSpring = springRes.data;

    if (!articlesFromSpring || articlesFromSpring.length === 0) {
      console.error("No articles received from Spring Boot.");
      setLoading(false);
      return;
    }

    const payload = {
      interests: interests.split(",").map(i => i.trim()),
      recentArticles: articlesFromSpring.slice(0, 10),
    };

    const fastRes = await fetchRecommendations(payload);
    if (fastRes.data?.recommendations) {
      setRecommended(fastRes.data.recommendations);
    } else {
      console.error("No recommendations returned from FastAPI");
    }
  } catch (err) {
    console.error("Error during recommendation:", err.response?.data || err.message);
  } finally {
    setLoading(false);
  }
};




  useEffect(() => {
    getArticles();
  }, []);

  return (
    <div className="container">
      <h2>Get Personalized News</h2>
      <input
        type="text"
        className="form-control"
        placeholder="Enter interests, e.g., cricket, economy"
        value={interests}
        onChange={(e) => setInterests(e.target.value)}
      />
      <button className="btn btn-primary mt-2" onClick={handleRecommend}>
        Recommend
      </button>

      {loading && <Loader />}

      {recommended.map((article, i) => (
        <NewsCard key={i} article={article} />
      ))}
    </div>
  );
};

export default Recommendations;
