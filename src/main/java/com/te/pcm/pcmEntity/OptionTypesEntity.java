package com.te.pcm.pcmentity;

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

public class OptionTypesEntity {
	@Id
	private int optionTypeId;
	@Column(length = 45)
	private String optionTypeTitle;
	
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "optionTypeId", referencedColumnName = "optionTypeId")
	private List<ProductEntity> productEntity;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "optionTypeId", referencedColumnName = "optionTypeId")
	private List<OptionsEntity> optionsEntities;

	
	
}


