package com.example.avantageevents.specification;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

/**
 * @author Malikov Azizjon  *  09.02.2023  *  23:19   *  AvantageEvents
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FilterRequest {

    private String key;

    private Operator operator;

    private FieldType fieldType;

    private transient Object value;

    private transient Object valueTo;

    private transient Collection<Object> values;

    @Builder.Default
    private boolean or = false;

    public static FilterRequest isActiveDefault() {
        return FilterRequest.builder()
                .key("active")
                .value(true)
                .fieldType(FieldType.BOOLEAN)
                .operator(Operator.EQUAL)
                .build();
    }

}
