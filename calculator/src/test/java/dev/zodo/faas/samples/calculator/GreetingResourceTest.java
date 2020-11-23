package dev.zodo.faas.samples.calculator;

import dev.zodo.faas.samples.calculator.model.CalculatorData;
import dev.zodo.faas.samples.calculator.model.Operator;
import dev.zodo.faas.samples.calculator.model.ResultData;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.ws.rs.core.MediaType;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;

@QuarkusTest
class GreetingResourceTest {

    @ParameterizedTest
    @MethodSource("calculatorArgsTest")
    void calculatorTest(Operator operator, Double value1, Double value2, Double expectedResult) {
        CalculatorData data = new CalculatorData(operator, value1, value2);
        ResultData result = given()
                .when()
                .contentType(MediaType.APPLICATION_JSON)
                .body(data)
                .post("/")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(ResultData.class);
        Assertions.assertEquals(operator, result.getOperator());
        Assertions.assertEquals(value1, result.getValue1());
        Assertions.assertEquals(value2, result.getValue2());
        Assertions.assertEquals(expectedResult, result.getResult());
    }

    private static Stream<Arguments> calculatorArgsTest() {
        return Stream.of(
                Arguments.of(Operator.SUM, 10D, 20D, 30D),
                Arguments.of(Operator.SUM, 0D, 20D, 20D),
                Arguments.of(Operator.MULTIPLY, 10D, 20D, 200D),
                Arguments.of(Operator.MULTIPLY, 0D, 20D, 0D),
                Arguments.of(null, null, null, null)
        );
    }

}