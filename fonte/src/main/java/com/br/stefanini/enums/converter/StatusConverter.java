package com.br.stefanini.enums.converter;

import com.br.stefanini.enums.Status;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Status status) {
        if (status == null) {
            return null;
        }
        return status.getId();
    }

    @Override
    public Status convertToEntityAttribute(Integer id) {
        if (id == null) {
            return null;
        }
        return Status.fromId(id);
    }
}
