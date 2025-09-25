package com.ecommerce.project.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

//Xử lý luồng: Dữ liệu gửi từ server --> client
public class CategoryResponse {
    private List<CategoryDTO> content;
}
