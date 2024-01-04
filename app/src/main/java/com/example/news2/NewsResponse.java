package com.example.news2;

import java.util.ArrayList;
import java.util.List;

public class NewsResponse {
    private String status;
    private int totalResults;
    private ArrayList<NewsModel> news;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<NewsModel> getNews() {
        return news;
    }

    public void setNews(ArrayList<NewsModel> news) {
        this.news = news;
    }
}
