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
public class CartDTO {
    private int id;

    @JsonProperty("cost")
    private long cost;

    @JsonProperty("user_id")
    private int user_id;

    @JsonProperty("created_at")
    private String date;

    @JsonProperty("phone")
    private int phone;

    @JsonProperty("address")
    private String address;
}
