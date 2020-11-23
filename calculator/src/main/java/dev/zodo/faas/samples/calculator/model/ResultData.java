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
public class ResultData {
    private Operator operator;
    private Double value1;
    private Double value2;
    private Double result;

    public static ResultData from(CalculatorData data, Double result) {
        final ResultData resultData;
        if (data == null) {
            resultData = new ResultData(null, null, null, result);
        } else {
            resultData = new ResultData(data.getOperator(), data.getValue1(), data.getValue2(), result);
        }
        return resultData;
    }
}
