package com.soighiri.libraryAp.category;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategory", nullable = false, unique = true)
    private Long idCategory;

    @Column(name ="categoryLabel", insertable = true, updatable = true, nullable = false)
    private String categoryLabel;
    private String description;

}
