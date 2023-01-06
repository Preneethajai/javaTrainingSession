package com.te.pcm.pcmrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcm.pcmentity.VariationTypesEntity;
@Repository
public interface VariationTypeRepository extends JpaRepository<VariationTypesEntity, Integer>{

}
