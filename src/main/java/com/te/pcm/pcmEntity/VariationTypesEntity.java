package com.te.pcm.pcmEntity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class VariationTypesEntity {
	@Id
	private int variationTypeId;
	@Column(length = 45)
	private String variationTypeTitle;
	
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "variationTypeId", referencedColumnName = "variationTypeId")
	private List<ProductEntity> productEntity;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "variationTypeId", referencedColumnName = "variationTypeId")
	private List<VariationsEntity> variationsEntities;
}
