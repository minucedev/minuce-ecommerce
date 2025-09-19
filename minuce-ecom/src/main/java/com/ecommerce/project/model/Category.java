package com.ecommerce.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "categories")
@Data // tạo get,set,toString,...
@NoArgsConstructor // tạo constructor không có đối số
@AllArgsConstructor // tạo constructor có tất cả đối số

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increase Id
    private Long categoryID;

    @NotBlank // cannot create empty
    private String categoryName;

}
