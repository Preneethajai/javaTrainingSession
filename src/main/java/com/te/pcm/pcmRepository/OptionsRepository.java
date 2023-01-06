package com.te.pcm.pcmrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcm.pcmentity.OptionsEntity;
@Repository
public interface OptionsRepository extends JpaRepository<OptionsEntity, Integer>{

}
