package com.ecommerce.project.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

//Luồng: Xử lý dữ liệu gửi từ clien (web) json --> server
public class CategoryDTO {
    private Long categoryId;
    private String categoryName;
}
