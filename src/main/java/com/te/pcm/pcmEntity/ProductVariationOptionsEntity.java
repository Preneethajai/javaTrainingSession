package com.te.pcm.pcmEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariationOptionsEntity {
	@Id
	private int productvariationOptionId;

//	@ManyToOne(cascade = CascadeType.ALL)
//	private OptionsEntity optionsEntity;
//	
//	@ManyToOne(cascade = CascadeType.MERGE)
//	private ProductVariationEntity productVariationEntity;

}
