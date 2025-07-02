
import React from "react";

const NewsCard = ({ article }) => (
  <div className="card mb-3">
    <div className="card-body">
      <h5 className="card-title">{article.title}</h5>
      <p className="card-text">{article.description}</p>
    </div>
  </div>
);

export default NewsCard;
