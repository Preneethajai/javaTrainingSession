package com.te.pcm.pcmRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcm.pcmEntity.CategoriesEntity;
@Repository
public interface CategoryRepository extends JpaRepository<CategoriesEntity, Integer> {

}
