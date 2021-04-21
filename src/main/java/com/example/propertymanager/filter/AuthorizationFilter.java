package com.example.propertymanager.filter;

import com.example.propertymanager.dao.UserDao;
import com.example.propertymanager.entity.Role;
import com.example.propertymanager.entity.User;
import com.example.propertymanager.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDao userDao;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String apiKey = request.getHeader("api-key");
        if (StringUtils.isBlank(apiKey)) {
            unauthorizedResponse(response);
        }

        Optional<User> user = userDao.findUserByApiKey(apiKey);
        if (!user.isPresent()) {
            unauthorizedResponse(response);
            return;
        }

        if (isInaccessible(request, user.get().getRoles())) {
            forbiddenResponse(response);
            return;
        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !new AntPathMatcher().match("/api/v1/**", request.getServletPath());
    }

    private void unauthorizedResponse(HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.TEXT_PLAIN_VALUE);
        response.getWriter().write("Unauthorized access!");
    }

    private void forbiddenResponse(HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType(MediaType.TEXT_PLAIN_VALUE);
        response.getWriter().write("You don't have access to this resource! Please contact your admin.");
    }

    private boolean isInaccessible(HttpServletRequest request, Set<Role> roles) {
        Predicate<Role> checkIfPurchaser = role -> role.getName().compareTo("purchaser") == 0;
        Predicate<Role> checkIfInnkeeper = role -> role.getName().compareTo("innkeeper") == 0;
        return ((roles.size() == 1
                && roles.stream().anyMatch(checkIfPurchaser)
                && !request.getRequestURI().equals("/api/v1/properties/_list"))
                ||
                (roles.stream().anyMatch(checkIfInnkeeper)
                        && request.getRequestURI().contains("/api/v1/properties/approve")));
    }
}
