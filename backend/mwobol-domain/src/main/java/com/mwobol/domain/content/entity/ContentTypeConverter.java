package com.mwobol.domain.content.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

@Converter(autoApply = true)
public class ContentTypeConverter implements AttributeConverter<ContentType, String> {

    @Override
    public String convertToDatabaseColumn(ContentType contentType) {
        return contentType == null ? null : contentType.getCode();
    }

    @Override
    public ContentType convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }
        return Arrays.stream(ContentType.values())
                .filter(ct -> ct.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown content type code: " + code));
    }
}
