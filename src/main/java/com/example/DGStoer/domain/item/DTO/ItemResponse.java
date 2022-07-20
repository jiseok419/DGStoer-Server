package com.example.DGStoer.domain.item.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor @Getter @Builder
public class ItemResponse {
    private String title;

    private String thumb;

    private String description;

    private String developer;

    private String github;

    private String framework;

    private List<DownloadDto> downloads;
}
