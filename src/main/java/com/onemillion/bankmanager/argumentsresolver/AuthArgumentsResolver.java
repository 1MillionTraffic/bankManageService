package com.onemillion.bankmanager.argumentsresolver;

import com.onemillion.bankmanager.interfaces.ParseAuth;
import com.onemillion.bankmanager.model.dto.AuthCookie;
import com.onemillion.bankmanager.model.dto.AuthResult;
import com.onemillion.bankmanager.model.dto.UserDTO;
import com.onemillion.bankmanager.service.TokenService;
import com.onemillion.bankmanager.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Objects;

@RequiredArgsConstructor
@Component
public class AuthArgumentsResolver implements HandlerMethodArgumentResolver {
    private final TokenService tokenService;
    private final UserService userService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(ParseAuth.class) != null &&
                parameter.getParameterType().equals(AuthResult.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        ParseAuth parseAuth = parameter.getParameterAnnotation(ParseAuth.class);
        if (Objects.isNull(parseAuth)) {
            throw new IllegalArgumentException("ParseAuth annotation is not existed.");
        }
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

        AuthResult.AuthResultBuilder builder = AuthResult.builder();

        AuthCookie accessTokenCookie = tokenService.getAccessToken(request);
        AuthCookie refreshTokenCookie = tokenService.getRefreshToken(request);

        boolean isLogin = Objects.nonNull(accessTokenCookie) && Objects.nonNull(refreshTokenCookie);
        builder.isLogin(isLogin);

        if (!isLogin && parseAuth.required()) {
            throw new IllegalStateException("UNAUTHORIZED"); // TODO: Exception Resolver 생성
        }

        if (isLogin) {
            if (!accessTokenCookie.getUserSeqNo().equals(refreshTokenCookie.getUserSeqNo())) {
                throw new IllegalStateException("Access token owner and refresh token owner is different.");
            }

            UserDTO user = userService.getUser(accessTokenCookie.getUserSeqNo());

            builder.accessToken(accessTokenCookie.getToken())
                    .refreshToken(refreshTokenCookie.getToken())
                    .user(user);
        }

        return builder.build();
    }
}
