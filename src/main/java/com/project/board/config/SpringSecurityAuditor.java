package com.project.board.config;

import com.project.board.config.auth.PrincipalDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@EnableJpaAuditing
@Slf4j
public class SpringSecurityAuditor implements AuditorAware<String>
{
    @Override
    public Optional<String> getCurrentAuditor()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (null == authentication || !authentication.isAuthenticated())
        {
            return null;
        }
        log.info("--------"+authentication.getPrincipal());
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        String name = principal.getMember().getName();
        return Optional.of(name);
    }
}
