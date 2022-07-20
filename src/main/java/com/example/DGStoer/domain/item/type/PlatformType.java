package com.example.DGStoer.domain.item.type;


import lombok.Getter;

public enum PlatformType {
    windows("window"),
    macos("macos"),
    android("android"),
    ios("ios"),
    linux("linux");

    @Getter
    private  final String value;

    PlatformType(String value){
        this.value = value;
    }
}
