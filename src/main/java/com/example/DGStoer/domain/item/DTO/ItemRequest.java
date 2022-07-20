package com.example.DGStoer.domain.item.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Getter
@Builder
public class ItemRequest {
    private String title;

    private String thumb;

    private String description;

    private String developer;

    private String github;

    private String framework;
}
