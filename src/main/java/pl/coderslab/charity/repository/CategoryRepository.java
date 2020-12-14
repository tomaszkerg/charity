package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
}
