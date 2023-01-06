package com.te.pcm.pcmrepository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcm.pcmentity.ProductEntity;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{
	
}
