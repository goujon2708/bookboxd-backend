package com.bookboxd.service;

import com.bookboxd.model.User;
import jakarta.ws.rs.core.Response;

public interface AuthService {
    Response register(User user);

    Response login(User user);
}
