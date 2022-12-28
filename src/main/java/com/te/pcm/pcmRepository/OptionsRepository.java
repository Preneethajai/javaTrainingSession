package com.te.pcm.pcmRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcm.pcmEntity.OptionsEntity;
@Repository
public interface OptionsRepository extends JpaRepository<OptionsEntity, Integer>{

}
