package com.onemillion.bankmanager.argumentsresolver;

import com.onemillion.bankmanager.interfaces.ParseAuth;
import com.onemillion.bankmanager.model.dto.AuthResult;
import com.onemillion.bankmanager.service.TokenService;
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

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(ParseAuth.class) != null &&
                parameter.getParameterType().equals(AuthResult.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        ParseAuth parseAuth = parameter.getParameterAnnotation(ParseAuth.class);
        assert parseAuth != null;
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

        String accessToken = tokenService.getAccessToken(request);
        String refreshToken = tokenService.getRefreshToken(request);

        boolean isLogin = Objects.nonNull(accessToken) && Objects.nonNull(refreshToken);

        if(parseAuth.required()) {
            throw new IllegalArgumentException("UNAUTHORIZED"); // TODO: Exception Resolver 생성
        }

        return AuthResult.builder()
                .isLogin(isLogin)
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
