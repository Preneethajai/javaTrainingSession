package com.te.pcm.pcmrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcm.pcmentity.VariationsEntity;
@Repository
public interface VariationRepository extends JpaRepository<VariationsEntity, Integer>{

}
