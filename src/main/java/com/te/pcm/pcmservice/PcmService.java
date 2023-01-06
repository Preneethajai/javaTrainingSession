package com.te.pcm.pcmservice;

import java.util.List;

import com.te.pcm.pcmdto.CategoriesDto;
import com.te.pcm.pcmdto.DepartmentsDto;
import com.te.pcm.pcmdto.EmployeeDto;
import com.te.pcm.pcmdto.EmployeesDto;
import com.te.pcm.pcmdto.OptionTypesDto;
import com.te.pcm.pcmdto.OptionsDto;
import com.te.pcm.pcmdto.ProductByIdDto;
import com.te.pcm.pcmdto.ProductsDto;
import com.te.pcm.pcmdto.SearchCategoryDto;
import com.te.pcm.pcmdto.SearchProductDto;
import com.te.pcm.pcmdto.VariationTypesDto;
import com.te.pcm.pcmdto.VariationsDto;
import com.te.pcm.pcmentity.CategoriesEntity;
import com.te.pcm.pcmentity.DepartmentsEntity;
import com.te.pcm.pcmentity.EmployeeEntity;
import com.te.pcm.pcmentity.OptionTypesEntity;
import com.te.pcm.pcmentity.OptionsEntity;
import com.te.pcm.pcmentity.ProductEntity;
import com.te.pcm.pcmentity.VariationTypesEntity;
import com.te.pcm.pcmentity.VariationsEntity;

public interface PcmService {
	DepartmentsEntity register(DepartmentsDto departmentDto); 
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
	DepartmentsEntity register(DepartmentsEntity departmentsEntity); 
}
