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
public class CategoriesEntity {
//	public CategoriesEntity(CategoriesEntity categoriesEntity) {
//		super();
//	}

	@Id
	private int categoryId;
	@Column(length = 45)
	private String categoryTitle;

	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
	private List<ProductEntity> productEntity;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
	private List<VariationTypesEntity> variationTypesEntities;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
	private List<OptionTypesEntity> optionTypesEntities;
}
