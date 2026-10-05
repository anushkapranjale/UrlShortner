package com.anushka.urlshortner.controller;

import com.anushka.urlshortner.entity.Url;
import com.anushka.urlshortner.service.UrlService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/urls")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping
    public Map<String, String> createShortUrl(
            @RequestBody Map<String, String> request) {

        String originalUrl = request.get("originalUrl");

        Url savedUrl = urlService.createShortUrl(originalUrl);

        return Map.of(
                "originalUrl", savedUrl.getOriginalUrl(),
                "shortCode", savedUrl.getShortCode(),
                "shortUrl", "http://localhost:8080/" + savedUrl.getShortCode()
        );
    }
}