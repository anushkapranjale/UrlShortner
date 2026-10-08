package com.anushka.urlshortner.controller;

import com.anushka.urlshortner.entity.Url;
import com.anushka.urlshortner.service.UrlService;
import org.springframework.web.bind.annotation.*;
import com.anushka.urlshortner.dto.CreateUrlRequest;
import com.anushka.urlshortner.dto.CreateUrlResponse;

@RestController
@RequestMapping("/api/urls")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping
    public CreateUrlResponse createShortUrl(
            @RequestBody CreateUrlRequest request) {

        Url savedUrl = urlService.createShortUrl(request.getOriginalUrl());

        return new CreateUrlResponse(
                savedUrl.getOriginalUrl(),
                savedUrl.getShortCode(),
                "http://localhost:8080/r/" + savedUrl.getShortCode()
        );
    }

}