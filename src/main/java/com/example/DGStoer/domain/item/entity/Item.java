package com.example.DGStoer.domain.item.entity;

import com.example.DGStoer.domain.user.entity.User;
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
public class Item extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn
    private User author;

    public void setAuthor(User author) {
        this.author = author;
    }

    private String title;

    private String thumb;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String developer;

    private String github;

    private String framework;

    @OneToMany
    private List<ItemBinary> downloads;
    public void addDownload(ItemBinary itemBinary) {
        itemBinary.setItem(this);
        this.downloads.add(itemBinary);
    }
}
