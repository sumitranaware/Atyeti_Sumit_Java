package com.example.Personalized.News.Recommender.System.service;

import com.example.Personalized.News.Recommender.System.dto.ArticleDTO;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
@RequiredArgsConstructor
public class NewsService {

    private final WebClient webClient = WebClient.create("https://gnews.io");

    @Value("${gnews.api-key}")
    private String apiKey;

    public List<ArticleDTO> fetchNews(String category) {
        String url = "/api/v4/top-headlines?country=in&lang=en&topic=" + category + "&token=" + apiKey;


        JsonNode response = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block();

        if (response == null || !response.has("articles")) {
            return Collections.emptyList();
        }

        List<ArticleDTO> articles = new ArrayList<>();
        for (JsonNode articleNode : response.get("articles")) {
            ArticleDTO article = new ArticleDTO();
            article.setTitle(articleNode.get("title").asText(""));
            article.setDescription(articleNode.get("description").asText(""));
            article.setUrl(articleNode.get("url").asText(""));
            article.setCategory(category);
            articles.add(article);
        }

        return articles;
    }
}

