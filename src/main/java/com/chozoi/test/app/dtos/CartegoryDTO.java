package com.chozoi.test.app.dtos;

import com.chozoi.test.domain.entities.Tasty;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartegoryDTO {
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("tasty")
    private List<Tasty> tasty;
}
