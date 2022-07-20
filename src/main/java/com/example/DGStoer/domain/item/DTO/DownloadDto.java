package com.example.DGStoer.domain.item.DTO;

import com.example.DGStoer.domain.item.type.PlatformType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class DownloadDto {
    private PlatformType platformType;

    private String fileName;
}
