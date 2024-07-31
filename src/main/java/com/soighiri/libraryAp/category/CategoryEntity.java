package com.soighiri.libraryAp.category;

import com.soighiri.libraryAp.book.BookEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "CATEGORY")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CategoryEntity {
    @Id
    @Column(name = "category_id", nullable = false, unique = true)
    private Long idCategory;

    @Column(name ="category_label", nullable = false)
    private String categoryLabel;
    private String description;

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookEntity> books;

}
