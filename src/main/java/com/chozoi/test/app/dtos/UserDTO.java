package com.chozoi.test.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("pass")
    private String password;

    @JsonProperty("emp")
    private String emp;
}
