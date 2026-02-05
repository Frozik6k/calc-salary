package com.example.salaryCalculation.controller;

import com.example.salaryCalculation.dto.LeavePayRequest;
import com.example.salaryCalculation.dto.LeavePayResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Контроллер для получения сумм отпускных выплат для сотрудников")
public interface LeavePayController {

    @Operation(description = "получение суммы отпускных выплат для сотрудника")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "сумма отпускных успешно получена",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = LeavePayResponse.class)
                            )
                    }
            )
    })
    LeavePayResponse getLeavePay(LeavePayRequest request);
}
