package br.com.macvinny.goanddo.security;

import br.com.macvinny.goanddo.data.UserData;
import br.com.macvinny.goanddo.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Value("$TOKEN_SECRET_KEY")
    public static String TOKEN_SECRET_KEY;

    @Value("$TOKEN_EXPIRATION_TIME")
    public static int TOKEN_EXPIRATION_TIME;

    private final AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try {
            User user = new ObjectMapper()
                    .readValue(request.getInputStream(), User.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getEmail(),
                    user.getPassword(),
                    new ArrayList<>()
            ));
        } catch(IOException e) {
            throw new RuntimeException("Failed to authenticate user.", e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException {
        UserData userData = (UserData) authResult.getPrincipal();

        String token = JWT.create().
                withSubject(userData.getUsername())
                .withExpiresAt(new Date((new Date()).getTime() + TOKEN_EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(TOKEN_SECRET_KEY));

        response.getWriter().write(token);
        response.getWriter().flush();
    }
}
