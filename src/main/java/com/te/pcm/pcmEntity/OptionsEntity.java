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
public class OptionsEntity {
	@Id
	private int optionId;
	@Column(length = 45)
	private String optionTitle;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "optionId",referencedColumnName = "optionId")
	private List<ProductVariationOptionsEntity> productVariationOptionsEntities;
	
}
