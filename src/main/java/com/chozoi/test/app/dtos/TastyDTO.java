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
public class TastyDTO {
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private float price;

    @JsonProperty("des")
    private String des;

    @JsonProperty("quantities")
    private int quantities;

    @JsonProperty("category_id")
    private int category_id;
}
