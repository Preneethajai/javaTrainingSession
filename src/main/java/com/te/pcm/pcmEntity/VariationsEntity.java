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
public class VariationsEntity {
	@Id
	private int variationId;
	@Column(length = 45)
	private String variationTitle;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "variationId",referencedColumnName = "variationId")
	private List<ProductVariationEntity> productVariationEntities;
}
