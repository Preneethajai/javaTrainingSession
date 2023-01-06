package com.te.pcm.pcmentity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariationEntity {
	@Id
	private int productVariation;
	
//	@OneToMany(mappedBy = "productVariationEntity")
//	@JoinColumn(name = "productVariation",referencedColumnName = "productVariation")
	
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "productVariationId",referencedColumnName = "productVariation")
	private List<ProductVariationOptionsEntity> productVariationOptionsEntities;
	
	
}
