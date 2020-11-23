package dev.zodo.faas.samples.calculator.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculatorData {
    private Operator operator;
    private Double value1;
    private Double value2;
}
