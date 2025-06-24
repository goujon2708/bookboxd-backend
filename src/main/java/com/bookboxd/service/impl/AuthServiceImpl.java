package com.bookboxd.service.impl;

import com.bookboxd.model.User;
import com.bookboxd.security.JwtUtil;
import com.bookboxd.service.AuthService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class AuthServiceImpl implements AuthService {

    @PersistenceContext(unitName = "bookboxdPU")
    private EntityManager em;

    @Override
    @Transactional
    public Response register(User user) {
        em.persist(user);
        return Response.status(Response.Status.CREATED).entity(user).build();
    }

    @Override
    public Response login(User credentials) {
        try {
            User user = em.createQuery(
                            "SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class)
                    .setParameter("username", credentials.getUsername())
                    .setParameter("password", credentials.getPassword())
                    .getSingleResult();


            String jwt = JwtUtil.generateToken(user.getUsername());

            return Response.ok().entity("{\"token\": \"" + jwt + "\"}").build();

        } catch (NoResultException e) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("{\"error\": \"Invalid credentials\"}")
                    .build();
        }
    }
}
