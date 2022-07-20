package com.example.DGStoer.domain.item.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor @Getter
public class ItemListResponse {
    @JsonProperty("page_size")
    private int pageSize;

    private List<ItemResponse> list;
}
