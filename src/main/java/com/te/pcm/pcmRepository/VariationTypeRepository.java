package com.te.pcm.pcmRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcm.pcmEntity.VariationTypesEntity;
@Repository
public interface VariationTypeRepository extends JpaRepository<VariationTypesEntity, Integer>{

}
