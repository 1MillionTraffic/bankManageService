package com.onemillion.bankmanager.service;

import com.onemillion.bankmanager.utils.AES256Util;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TokenService {
    private static final String ACCESS_TOKEN_COOKIE_NAME = "access_token";
    private static final String REFRESH_TOKEN_COOKIE_NAME = "refresh_token";
    private static final String ACCESS_TOKEN_KEY = "access_token_key";
    private static final String REFRESH_TOKEN_KEY = "refresh_token_key";
    private static final int ACCESS_TOKEN_EXPIRE = 3600;
    private static final int REFRESH_TOKEN_EXPIRE = 86400;

    public String getAccessToken(HttpServletRequest request) {
        return parseToken(request, ACCESS_TOKEN_COOKIE_NAME, ACCESS_TOKEN_KEY);
    }

    public String getRefreshToken(HttpServletRequest request) {
        return parseToken(request, REFRESH_TOKEN_COOKIE_NAME, REFRESH_TOKEN_KEY);
    }

    private String parseToken(HttpServletRequest request, String cookieName, String key) {
        Cookie[] cookies = request.getCookies();

        Optional<Cookie> optionalCookie = findFirstCookie(cookies, cookieName);
        if (optionalCookie.isEmpty()) {
            return null;
        }

        Cookie tokenCookie = optionalCookie.get();
        String encryptedToken = tokenCookie.getValue();

        try {
            return AES256Util.decrypt(encryptedToken, key);
        } catch (Exception exception) {
            log.debug(exception.getMessage());
            return null;
        }
    }

    private Optional<Cookie> findFirstCookie(Cookie[] cookies, String cookieName) {
        return Arrays.stream(cookies)
                .filter(cookie -> cookieName.equals(cookie.getName()))
                .findFirst();
    }

    public void setAccessToken(HttpServletResponse response, String token) throws Exception {
        setToken(response, token, ACCESS_TOKEN_COOKIE_NAME, ACCESS_TOKEN_EXPIRE, ACCESS_TOKEN_KEY);
    }

    public void setRefreshToken(HttpServletResponse response, String token) throws Exception {
        setToken(response, token, REFRESH_TOKEN_COOKIE_NAME, REFRESH_TOKEN_EXPIRE, REFRESH_TOKEN_KEY);
    }

    private void setToken(HttpServletResponse response, String token, String cookieName, int cookieExpire, String key) throws Exception {
        String encryptedToken = AES256Util.encrypt(token, key);

        Cookie cookie = new Cookie(cookieName, encryptedToken);
        cookie.setPath("/");
        cookie.setMaxAge(cookieExpire);
        cookie.setHttpOnly(true);

        response.addCookie(cookie);
    }

}
