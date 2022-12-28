package com.te.pcm.pcmservice;

import java.util.List;
import com.te.pcm.pcmDto.CategoriesDto;
import com.te.pcm.pcmDto.EmployeeDto;
import com.te.pcm.pcmDto.OptionTypesDto;
import com.te.pcm.pcmDto.OptionsDto;
import com.te.pcm.pcmDto.ProductByIdDto;
import com.te.pcm.pcmDto.ProductsDto;
import com.te.pcm.pcmDto.SearchCategoryDto;
import com.te.pcm.pcmDto.SearchProductDto;
import com.te.pcm.pcmDto.VariationTypesDto;
import com.te.pcm.pcmDto.VariationsDto;
import com.te.pcm.pcmEntity.CategoriesEntity;
import com.te.pcm.pcmEntity.DepartmentsEntity;
import com.te.pcm.pcmEntity.EmployeeEntity;
import com.te.pcm.pcmEntity.OptionTypesEntity;
import com.te.pcm.pcmEntity.OptionsEntity;
import com.te.pcm.pcmEntity.ProductEntity;
import com.te.pcm.pcmEntity.VariationTypesEntity;
import com.te.pcm.pcmEntity.VariationsEntity;
import com.te.pcm.pcmServiceImp.EmployeesDto;

public interface PcmService {
	DepartmentsEntity register(DepartmentsEntity departmentsEntity); 
	EmployeeEntity empRegister(EmployeesDto employeesDto);
	List<DepartmentsEntity> getall();
	List<DepartmentsEntity> getById(ProductByIdDto productByIdDto);
	CategoriesEntity updateCategory(CategoriesDto categoriesDto);
	DepartmentsEntity updateCategoryTitle(CategoriesDto categoriesDto);
	ProductEntity updateProduct(ProductsDto productsDto);
	VariationsEntity updateVariation(VariationsDto variationsDto);
	VariationTypesEntity updateVariatioType(VariationTypesDto variationTypesDto);
	OptionsEntity updateOptions(OptionsDto optionsDto);
	OptionTypesEntity updateOptionType(OptionTypesDto optionTypesDto);
	List<EmployeeDto> getEmployee();
	Boolean deleteProduct(ProductsDto productsDto);
	Boolean deleteOption(OptionsDto optionsDto);
	Boolean deleteOptionTypes(OptionTypesDto optionTypesDto);
	List<ProductEntity> sortProducts();
	List<VariationsEntity> sortByVariation();
	List<VariationTypesEntity> sortByVariationType();
	List<OptionsEntity> sortByOption();
	List<OptionTypesEntity> sortByOptionType();
	List<SearchProductDto> serachProduct(int productId);
	List<SearchCategoryDto> serachCategory(int categorystId);
//	EmployeeEntity empRegister(EmployeeEntity employeeEntity);
}
