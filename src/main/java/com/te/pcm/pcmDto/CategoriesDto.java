package com.te.pcm.pcmdto;

import java.util.List;

import com.te.pcm.pcmentity.CategoriesEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CategoriesDto {
	private int categoryId;
	private String categoryTitle;
	private int departmentId;

}
