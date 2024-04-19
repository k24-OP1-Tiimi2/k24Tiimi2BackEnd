package k24.op1.dogbackend;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import k24.op1.dogbackend.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;

    public AuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(@SuppressWarnings("null") HttpServletRequest request,
            @SuppressWarnings("null") HttpServletResponse response, @SuppressWarnings("null") FilterChain filterChain)
            throws ServletException, java.io.IOException {
        // Get token from the Authorization header
        String jws = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (jws != null) {
            // Verify token and get user
            String user = jwtService.getAuthUser(request);
            // Authenticate
            Authentication authentication = new UsernamePasswordAuthenticationToken(user, null,
                    java.util.Collections.emptyList());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }
}