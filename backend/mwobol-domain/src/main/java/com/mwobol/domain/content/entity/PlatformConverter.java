package com.mwobol.domain.content.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

@Converter(autoApply = true)
public class PlatformConverter implements AttributeConverter<Platform, String> {

    @Override
    public String convertToDatabaseColumn(Platform platform) {
        return platform == null ? null : platform.getCode();
    }

    @Override
    public Platform convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }
        return Arrays.stream(Platform.values())
                .filter(p -> p.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown platform code: " + code));
    }
}
