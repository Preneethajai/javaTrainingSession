package com.te.pcm.pcmRepository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.te.pcm.pcmEntity.ProductEntity;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{
	
}
