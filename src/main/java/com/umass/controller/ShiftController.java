package com.umass.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.umass.model.Shift;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Shift Controller", description = "Endpoints for managing shifts")
public interface ShiftController {

    @Operation(summary = "Fetch shifts", description = "Endpoint to fetch shifts based on criteria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of shifts")
    })
    @GetMapping(path = "/private/api/shifts", produces = "application/json")
    public ResponseEntity<List<Shift>> fetchShift(@RequestParam("startTime") String startTime, @RequestParam("endTime") String endTime);

    @Operation(summary = "Create a new shift", description = "Endpoint to create a new shift")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created the shift"),
            @ApiResponse(responseCode = "400", description = "Bad request, invalid input")
    })
    @PostMapping(path = "/private/api/shifts", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Shift> createShift(@RequestBody Shift shift);

    @Operation(summary = "Update a shift", description = "Endpoint to update an existing shift")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated the shift"),
            @ApiResponse(responseCode = "400", description = "Bad request, invalid input"),
            @ApiResponse(responseCode = "404", description = "Shift not found")
    })
    @PutMapping(path = "/private/api/shifts", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> updateShift(@RequestBody Shift shift);

    @Operation(summary = "Delete a shift", description = "Endpoint to delete a shift by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted the shift"),
            @ApiResponse(responseCode = "404", description = "Shift not found")
    })
    @DeleteMapping(path = "/private/api/shifts", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> deleteShift(
            @Parameter(in = ParameterIn.QUERY, name = "id", description = "ID of the shift to be deleted", required = true)
            @RequestParam String id);

}
