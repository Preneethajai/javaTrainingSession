package com.te.pcm.pcmrepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcm.pcmentity.CategoriesEntity;
import com.te.pcm.pcmentity.DepartmentsEntity;
import com.te.pcm.pcmentity.ProductEntity;
@Repository
public interface RegisterRepository extends JpaRepository<DepartmentsEntity, Integer>{
	 
}
