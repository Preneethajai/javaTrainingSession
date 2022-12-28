package com.te.pcm.pcmRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcm.pcmEntity.OptionTypesEntity;

@Repository
public interface OptionTypeRepository extends JpaRepository<OptionTypesEntity, Integer> {

}
