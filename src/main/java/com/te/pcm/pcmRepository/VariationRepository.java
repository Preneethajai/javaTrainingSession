package com.te.pcm.pcmRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcm.pcmEntity.VariationsEntity;
@Repository
public interface VariationRepository extends JpaRepository<VariationsEntity, Integer>{

}
