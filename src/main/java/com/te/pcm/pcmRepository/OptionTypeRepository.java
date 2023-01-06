package com.te.pcm.pcmrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcm.pcmentity.OptionTypesEntity;

@Repository
public interface OptionTypeRepository extends JpaRepository<OptionTypesEntity, Integer> {

}
