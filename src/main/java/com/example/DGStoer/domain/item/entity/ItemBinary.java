package com.example.DGStoer.domain.item.entity;

import com.example.DGStoer.domain.item.type.PlatformType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor @NoArgsConstructor
@Entity @Getter @Builder
public class ItemBinary {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @JoinColumn
    @ManyToOne
    private Item item;
    public void setItem(Item item) {
        this.item = item;
    }

    @Enumerated(EnumType.STRING)
    private PlatformType platformtype;

    private String savedName;
}
