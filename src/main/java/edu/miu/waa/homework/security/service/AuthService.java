package edu.miu.waa.homework.security.service;

import edu.miu.waa.homework.security.entity.dto.request.LoginRequest;
import edu.miu.waa.homework.security.entity.dto.request.RefreshTokenRequest;
import edu.miu.waa.homework.security.entity.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
