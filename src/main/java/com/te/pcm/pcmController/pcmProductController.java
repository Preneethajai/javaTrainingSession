package com.te.pcm.pcmcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.pcm.pcmdto.AppResponse;
import com.te.pcm.pcmdto.CategoriesDto;
import com.te.pcm.pcmdto.EmployeeDto;
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
import com.te.pcm.pcmentity.OptionTypesEntity;
import com.te.pcm.pcmentity.OptionsEntity;
import com.te.pcm.pcmentity.ProductEntity;
import com.te.pcm.pcmentity.VariationTypesEntity;
import com.te.pcm.pcmentity.VariationsEntity;
import com.te.pcm.pcmservice.PcmService;

@RestController
@RequestMapping(path = "/admin")
public class PcmProductController {

	@Autowired
	private AppResponse response;

	@Autowired
	private PcmService service;

	@GetMapping(path ="/getall")
	public ResponseEntity<AppResponse> getall() {
		List<DepartmentsEntity> getall = service.getall();
		if (getall != null) {
			response.setMessage("got all");
			response.setSatus("Sucessufully ");
			response.setData(getall);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(path ="/getEmployee")
	public ResponseEntity<AppResponse> getEmployee() {
		List<EmployeeDto> employee = service.getEmployee();
		if(employee!=null) {
			response.setMessage("got all");
			response.setSatus("Sucessuful");
			response.setData(employee);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(path ="/searchById")
	public ResponseEntity<AppResponse> getById(@RequestBody ProductByIdDto productByIdDto) {
		List<DepartmentsEntity> byId = service.getById(productByIdDto);
		if (byId != null) {
			response.setMessage("product list ");
			response.setSatus("Sucessufully list");
			response.setData(byId);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	
	@PostMapping(path ="/updateCategory")
	public ResponseEntity<AppResponse> updateCategory(@RequestBody CategoriesDto categoriesDto) {
	CategoriesEntity updateCategory = service.updateCategory(categoriesDto);
		if(updateCategory!=null) {
			response.setMessage("sucessfully update");
			response.setSatus("updateds");
			response.setData(updateCategory);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(path ="/updateCategoryTitle")//--> Using the foreign Key
	public ResponseEntity<AppResponse> updateCategoryTitle(@RequestBody CategoriesDto categoriesDto) {
	DepartmentsEntity updateCategory = service.updateCategoryTitle(categoriesDto);
		if(updateCategory!=null) {
			response.setMessage("category");
			response.setSatus("update sucessfully");
			response.setData(updateCategory);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(path ="/updateproduct")
	public ResponseEntity<AppResponse> updateProduct(@RequestBody ProductsDto productsDto ) {
		ProductEntity updateProduct = service.updateProduct(productsDto);
		if(updateProduct!=null) {
			response.setMessage("sucessful's");
			response.setSatus("updated's");
			response.setData(updateProduct);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping(path ="/updateVariation")
	public ResponseEntity<AppResponse> updateVariation(@RequestBody VariationsDto variationsDto) {
		VariationsEntity updateVariation = service.updateVariation(variationsDto);
		if(updateVariation!=null) {
			response.setMessage(" sucessfully variation ");
			response.setSatus("updated variation");
			response.setData(updateVariation);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping(path ="/updateVariationType")
	public ResponseEntity<AppResponse> updateVariationType(@RequestBody VariationTypesDto variationTypesDto) {
		VariationTypesEntity updateVariatioType = service.updateVariatioType(variationTypesDto);
		if(updateVariatioType!=null) {
			response.setMessage("sucessfully variation type");
			response.setSatus("updated variationtype");
			response.setData(updateVariatioType);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping(path ="/updateOption")
	public ResponseEntity<AppResponse> updateOption(@RequestBody OptionsDto optionsDto) {
		OptionsEntity updateOptions = service.updateOptions(optionsDto);
		if(updateOptions!=null) {
			response.setMessage("sucessfully Options");
			response.setSatus("updated Options");
			response.setData(updateOptions);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping(path ="/updateOptionType")
	public ResponseEntity<AppResponse> updateOptionType(@RequestBody OptionTypesDto optionTypesDto) {
		OptionTypesEntity updateOptionType = service.updateOptionType(optionTypesDto);
		if(updateOptionType!=null) {
			response.setMessage("sucessfully OptionTypes");
			response.setSatus("update optionsTypes");
			response.setData(updateOptionType);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@DeleteMapping(path ="/deleteProduct")
	public ResponseEntity<AppResponse> deleteProduct(@RequestBody ProductsDto productsDto) {
		Boolean deleteProduct = service.deleteProduct(productsDto);
		if(Boolean.TRUE.equals(deleteProduct)) {
			response.setMessage("Products sucessfully");
			response.setSatus("Products updated");
		}
		return new ResponseEntity<>(response,HttpStatus.OK);	
	}
	
	@DeleteMapping(path ="/deleteOption")
	public ResponseEntity<AppResponse> deleteOptions(@RequestBody OptionsDto optionsDto) {
		Boolean deleteOption = service.deleteOption(optionsDto);
		if(Boolean.TRUE.equals(deleteOption)) {
			response.setMessage("sucessfully");
			response.setSatus("updated");
		}
		return new ResponseEntity<>(response,HttpStatus.OK);	
	}
	
	@DeleteMapping(path ="/deleteOptionTypes")
	public ResponseEntity<AppResponse> deleteOptionTypes(@RequestBody OptionTypesDto optionTypesDto) {
		Boolean deleteOptionTypes = service.deleteOptionTypes(optionTypesDto);
		if(Boolean.TRUE.equals(deleteOptionTypes)) {
			response.setMessage("Optiontype sucessfully");
			response.setSatus("Option updated");
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping(path ="/sortProduct")
	public ResponseEntity<AppResponse> sortProduct() {
	List<ProductEntity> sortProducts = service.sortProducts();
	if(sortProducts!=null) {
		response.setMessage("sucessfully product");
		response.setSatus("updated product");
		response.setData(sortProducts);
	}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping(path ="/sortByVariation")
	public ResponseEntity<AppResponse> sortByVariation() {
		List<VariationsEntity> sortByVariation = service.sortByVariation();
		if(sortByVariation!=null) {
			response.setMessage("sucessfully variation");
			response.setSatus("updated variation");
			response.setData(sortByVariation);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping(path ="/sortByVariationType")
	public ResponseEntity<AppResponse> sortByVariationType() {
		List<VariationTypesEntity> sortByVariationType = service.sortByVariationType();
		if(sortByVariationType!=null) {
			response.setMessage("sucessfully sortVariationType");
			response.setSatus("updated variationType");
			response.setData(sortByVariationType);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping(path ="/sortOptions")
	public ResponseEntity<AppResponse> sortByOption() {
		List<OptionsEntity> sortByOption = service.sortByOption();
		if(sortByOption!=null) {
			response.setMessage("sucessfully sortOption");
			response.setSatus("updated's options");
			response.setData(sortByOption);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping(path ="/sortOptionsType")
	public ResponseEntity<AppResponse> sortByOptionType() {
		List<OptionTypesEntity> sortByOptionType = service.sortByOptionType();
		if(sortByOptionType!=null) {
			response.setMessage("sucessfully optionType");
			response.setSatus("updated option");
			response.setData(sortByOptionType);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping(path ="/searchProduct")
	public ResponseEntity<AppResponse> searchProduct(int productsId) {
		List<SearchProductDto> serachProduct = service.serachProduct(productsId);
		if(serachProduct!=null) {
			response.setMessage("sucessfully");
			response.setSatus("updated");
			response.setData(serachProduct);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping(path ="/searchCategory")
	public ResponseEntity<AppResponse> searchCategory(int catogorysId) {
		List<SearchCategoryDto> serachCategory = service.serachCategory(catogorysId);
		if(serachCategory!=null) {
			response.setMessage("sucessfully category");
			response.setSatus("updated search catergory");
			response.setData(serachCategory);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping(path = "registerNew")
	public ResponseEntity<AppResponse> registerNew(@RequestBody DepartmentsEntity entity) {
		DepartmentsEntity register = service.register(entity);
		if(register!=null) {
			response.setMessage("sucessfully optionType");
			response.setSatus("updated option");
			response.setData(register);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
