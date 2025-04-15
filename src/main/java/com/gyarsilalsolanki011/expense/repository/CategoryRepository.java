package com.gyarsilalsolanki011.expense.repository;

import com.gyarsilalsolanki011.expense.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
