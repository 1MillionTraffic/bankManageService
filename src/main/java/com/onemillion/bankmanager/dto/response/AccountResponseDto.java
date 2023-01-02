package com.onemillion.bankmanager.dto.response;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.List;

public class AccountResponseDto extends JsonDeserializer<List<AccountResponseDto>> {

    @Override
    public List<AccountResponseDto> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {

        return null;
    }
}
