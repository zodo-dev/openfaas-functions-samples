package dev.zodo.faas.samples.calculator;

import dev.zodo.faas.samples.calculator.model.CalculatorData;
import dev.zodo.faas.samples.calculator.model.ResultData;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class CalculatorResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response handle(CalculatorData data) {
        Double result = Calculator.calculate(data);
        ResultData resultData = ResultData.from(data, result);
        return Response.ok(resultData).build();
    }
}
