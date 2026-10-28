package com.example.democandidate.controllers;

import com.example.democandidate.models.dto.req.CandidateCreateDTO;
import com.example.democandidate.models.dto.req.CandidateUpdateDTO;
import com.example.democandidate.models.dto.wrapper.ApiResponse;
import com.example.democandidate.models.entities.Candidate;
import com.example.democandidate.models.services.CandidateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/candidates")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService candidateService;

    @GetMapping
    public ResponseEntity<?> findAll() {

        return ResponseEntity.ok(
                ApiResponse.builder()
                        .status(HttpStatus.OK.name())
                        .message("Thanh cong nhe!")
                        .data(candidateService.findAll())
                        .build()
        );
    }

    @PostMapping
    ResponseEntity<?> create(@Valid @RequestBody CandidateCreateDTO request, BindingResult result){
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            List<FieldError> fieldErrors = result.getFieldErrors();

            fieldErrors.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(
                    ApiResponse.builder()
                            .status(HttpStatus.BAD_REQUEST.name())
                            .message("Data Failed")
                            .data(errors)
                            .build()
            );
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.builder()
                        .status(HttpStatus.CREATED.name())
                        .message("Successfully")
                        .data(candidateService.create(request))
                        .build()
                );

    }

    @PutMapping("updates/{id}")
    ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody CandidateUpdateDTO request,BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            List<FieldError> fieldErrors = result.getFieldErrors();
            fieldErrors.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(
                    ApiResponse.builder()
                            .status(HttpStatus.BAD_REQUEST.name())
                            .message("Data Failed")
                            .data(errors)
                            .build()
            );
        }


        Candidate updateCandidate = candidateService.Update(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.builder()
                        .status(HttpStatus.OK.name())
                        .message("Successfully")
                        .data(updateCandidate)
                        .build()
                );
    }
}
