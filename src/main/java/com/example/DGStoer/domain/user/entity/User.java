package com.example.DGStoer.domain.user.entity;


import com.example.DGStoer.domain.item.entity.Item;
import com.example.DGStoer.global.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor @NoArgsConstructor @Getter
@Entity
public class User extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    @Column(unique = true)
    private String bindInfraId;

    @OneToMany(mappedBy = "author")
    private List<Item> items;

    public void addItem(Item item) {
        item.setAuthor(this);
        this.items.add(item);
    }

}
