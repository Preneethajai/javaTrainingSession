package com.te.pcm.pcmRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcm.pcmEntity.CategoriesEntity;
import com.te.pcm.pcmEntity.DepartmentsEntity;
import com.te.pcm.pcmEntity.ProductEntity;
@Repository
public interface RegisterRepository extends JpaRepository<DepartmentsEntity, Integer>{
	 
}
