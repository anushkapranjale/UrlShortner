package com.anushka.urlshortner.dto;

public class CreateUrlResponse {

    private String originalUrl;
    private String shortCode;
    private String shortUrl;

    public CreateUrlResponse(String originalUrl, String shortCode, String shortUrl) {
        this.originalUrl = originalUrl;
        this.shortCode = shortCode;
        this.shortUrl = shortUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortCode() {
        return shortCode;
    }

    public String getShortUrl() {
        return shortUrl;
    }
}