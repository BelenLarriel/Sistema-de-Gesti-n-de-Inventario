package com.pruebaventas.ventasempresa.Filtrer;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ApiKeyFilter extends OncePerRequestFilter {

    private static final String API_KEY = "Canelabebe258";

    @Override
    protected void doFilterInternal(
            // es la petición del cliente//aquí vienen headers, body, url, etc.
            HttpServletRequest request,
            // es lo que tú vas a devolver
            HttpServletResponse response,

            FilterChain filterChain)
            throws ServletException, IOException {

        String apiKey = request.getHeader("X-API-KEY");

        if (API_KEY.equals(apiKey)) {
            // ✔ deja pasar
            filterChain.doFilter(request, response);
        } else {
            // ❌ bloquea
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized - Invalid API KEY");
        }
    }

}
