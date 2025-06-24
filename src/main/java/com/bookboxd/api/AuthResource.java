package com.bookboxd.api;

import com.bookboxd.model.User;
import com.bookboxd.security.JwtUtil;
import com.bookboxd.service.AuthService;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    private AuthService authService;

    @POST
    @Path("/register")
    public Response register(User user) {

        return authService.register(user);
    }

    @POST
    @Path("/login")
    public Response login(User credentials) {

        return authService.login(credentials);
    }
}
