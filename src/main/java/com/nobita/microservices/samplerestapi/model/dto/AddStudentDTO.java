package com.nobita.microservices.samplerestapi.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor @AllArgsConstructor @ToString
public class AddStudentDTO {
    @NotBlank(message = "Name cannot be empty")
    @Size(min=2 , message = "Name must contain maximum of 2 characters")
    private String name;
    @NotBlank(message = "Branch cannot be empty")
    private String branch;
}
