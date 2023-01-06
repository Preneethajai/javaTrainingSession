package com.te.pcm.pcmrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcm.pcmentity.CategoriesEntity;
@Repository
public interface CategoryRepository extends JpaRepository<CategoriesEntity, Integer> {

}
