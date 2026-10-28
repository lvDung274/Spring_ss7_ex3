package com.example.democandidate.models.dto.req;

import jakarta.validation.constraints.*;

public record CandidateCreateDTO(
        @NotBlank(message = "Tên người dùng không được để trống")
        @Size(min = 5, max = 50, message = "Tên người dùng phải từ 5 đến 50 ký tự")
        String fullName,

        @NotBlank(message = "Email không được để trống")
        @Pattern(
                regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
                message ="Email không đúng định dạng"
        )
        String email,

        @Min(value = 18, message = "Nguyoiwf dungf phải từ 18 tuổi trở lên")
        Integer age,

        @Min(value = 0, message = "Số năm kinh nghiệm không được nhỏ hơn 0")
        Integer yearsOfExperience

) {
}
