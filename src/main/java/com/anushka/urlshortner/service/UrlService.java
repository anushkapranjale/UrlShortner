
package com.anushka.urlshortner.service;

import com.anushka.urlshortner.entity.Url;
import com.anushka.urlshortner.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    private static final String CHARACTERS =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final int CODE_LENGTH = 6;

    private final SecureRandom random = new SecureRandom();

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public Url createShortUrl(String originalUrl) {

        if (originalUrl == null || originalUrl.isBlank()) {
            throw new IllegalArgumentException("URL cannot be empty");
        }

        try {
            java.net.URI uri = java.net.URI.create(originalUrl);

            if (uri.getHost() == null ||
                    (!uri.getScheme().equals("http")
                            && !uri.getScheme().equals("https"))) {

                throw new IllegalArgumentException("Invalid URL");
            }

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid URL");
        }

        Url url = new Url();

        url.setOriginalUrl(originalUrl);
        url.setShortCode(generateUniqueCode());

        return urlRepository.save(url);
    }

    private String generateUniqueCode() {
        String code;

        do {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < CODE_LENGTH; i++) {
                int index = random.nextInt(CHARACTERS.length());
                builder.append(CHARACTERS.charAt(index));
            }

            code = builder.toString();

        } while (urlRepository.findByShortCode(code).isPresent());

        return code;
    }
}