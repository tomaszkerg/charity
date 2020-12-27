package pl.coderslab.charity.converter;

import pl.coderslab.charity.dto.CategoryDto;
import pl.coderslab.charity.entity.CategoryEntity;

public class CategoryConverter {

    public static CategoryDto toDto(CategoryEntity category){
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
