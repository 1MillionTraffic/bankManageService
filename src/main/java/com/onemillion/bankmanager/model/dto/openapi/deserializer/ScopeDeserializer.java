package com.onemillion.bankmanager.model.dto.openapi.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.onemillion.bankmanager.model.enums.TokenScope;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScopeDeserializer extends JsonDeserializer<List<TokenScope>> {
    @Override
    public List<TokenScope> deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String[] scopes = parser.getText().split(" ");

        List<TokenScope> tokenScopeList = new ArrayList<>();

        for(String scope: scopes) {
            tokenScopeList.add(TokenScope.valueOf(scope.toUpperCase()));
        }

        return tokenScopeList;
    }
}
