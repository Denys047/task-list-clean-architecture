package com.tasklist.task_list_clean_architecture.infrastructure.security.filter;

import com.tasklist.task_list_clean_architecture.application.interfaces.security.DomainUseDetails;
import com.tasklist.task_list_clean_architecture.application.interfaces.security.TokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;

import java.util.Objects;

@RequiredArgsConstructor
public class BearerAuthConverter implements AuthenticationConverter {

    public static final String AUTHENTICATION_SCHEME_BEARER = "Bearer";

    private final TokenProvider tokenProvider;

    private final UserDetailsService userDetailsService;

    @Override
    public UsernamePasswordAuthenticationToken convert(HttpServletRequest request) {
        var authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (Objects.isNull(authHeader) ||
                !StringUtils.startsWithIgnoreCase(authHeader, AUTHENTICATION_SCHEME_BEARER)) {
            return null;
        }

        String token = authHeader.substring(7);

        if (tokenProvider.validateToken(token)) {
            String username = tokenProvider.getUsernameFromToken(token);

            var domainUseDetails = userDetailsService.loadUserByUsername(username);

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(
                            domainUseDetails,
                            null,
                            domainUseDetails.getAuthorities()
                    );
            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            return usernamePasswordAuthenticationToken;
        }

        return null;
    }

}
