package com.programming.techie.apigatewayservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.WebSession;

import reactor.core.publisher.Mono;

@RestController
public class WebSessionController {

	@GetMapping("/")
    public Mono<String> home(WebSession webSession) {
        return Mono.just(webSession.getId());
    }
}
