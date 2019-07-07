package com.example.demo.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        // if you are using Spring Security then get the logged-in user from
        // SecurityContextHolder and set it accordingly
        //  if you are using X-AUTH-TOKEN then the username from there and set it accordingly
        return Optional.of("Raj Kumar");
    }
}
