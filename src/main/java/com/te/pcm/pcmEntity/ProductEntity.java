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
public class ProductEntity {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(unique = true, nullable = false)
	private int productId;
	@Column(length = 100)
	private String productTitle;
	
	
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "productId",referencedColumnName = "productId")
	private List<ProductVariationEntity> productVariationEntities;
}
