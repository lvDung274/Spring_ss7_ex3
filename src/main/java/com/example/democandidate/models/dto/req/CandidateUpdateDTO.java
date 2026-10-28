package com.example.democandidate.models.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CandidateUpdateDTO(
        @NotBlank(message = "Địa chỉ không được rỗng")
        String address,

        @Size(max = 200, message = "Đ ộ dài tối đa 20 kí tự")
        String bio
) {
}
