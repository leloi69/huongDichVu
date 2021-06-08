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
public class CartItemDTO {
    private int id;

    @JsonProperty("cart_id")
    private int cart_id;

    @JsonProperty("tasty_id")
    private int tasty_id;

    @JsonProperty("quantities")
    private int quantities;

    @JsonProperty("unit_price")
    private float unit_price;
}
