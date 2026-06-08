package com.erp.winkaws.mydb.auth.dto;

import jakarta.validation.constraints.NotBlank;

public record Credentials(@NotBlank String username, @NotBlank String password) {

}
