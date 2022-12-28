package com.te.pcm.pcmController;

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
import com.te.pcm.pcmDto.AppResponse;
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
import com.te.pcm.pcmEntity.OptionTypesEntity;
import com.te.pcm.pcmEntity.OptionsEntity;
import com.te.pcm.pcmEntity.ProductEntity;
import com.te.pcm.pcmEntity.VariationTypesEntity;
import com.te.pcm.pcmEntity.VariationsEntity;
import com.te.pcm.pcmservice.PcmService;

@RestController
@RequestMapping("/admin")
public class pcmProductController {

	@Autowired
	private AppResponse response;

	@Autowired
	private PcmService service;

	@GetMapping("/getall")
	public ResponseEntity<AppResponse> getall() {
		List<DepartmentsEntity> getall = service.getall();
		if (getall != null) {
			response.setMessage("got all");
			response.setSatus("Sucessufully");
			response.setData(getall);
		}
		return new ResponseEntity<AppResponse>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getEmployee")
	public ResponseEntity<AppResponse> getEmployee() {
		List<EmployeeDto> employee = service.getEmployee();
		if(employee!=null) {
			response.setMessage("got all");
			response.setSatus("Sucessufully");
			response.setData(employee);
		}
		return new ResponseEntity<AppResponse>(response, HttpStatus.OK);
	}

	@PostMapping("/searchById")
	public ResponseEntity<AppResponse> getById(@RequestBody ProductByIdDto productByIdDto) {
		List<DepartmentsEntity> byId = service.getById(productByIdDto);
		if (byId != null) {
			response.setMessage("product list ");
			response.setSatus("Sucessufully");
			response.setData(byId);
		}
		return new ResponseEntity<AppResponse>(response, HttpStatus.OK);
	}

	
	@PostMapping("/updateCategory")
	public ResponseEntity<AppResponse> updateCategory(@RequestBody CategoriesDto categoriesDto) {
	CategoriesEntity updateCategory = service.updateCategory(categoriesDto);
		if(updateCategory!=null) {
			response.setMessage("sucessfully");
			response.setSatus("updated");
			response.setData(updateCategory);
		}
		return new ResponseEntity<AppResponse>(response, HttpStatus.OK);
	}
	
	@PostMapping("/updateCategoryTitle")//--> Using the foreign Key
	public ResponseEntity<AppResponse> updateCategoryTitle(@RequestBody CategoriesDto categoriesDto) {
	DepartmentsEntity updateCategory = service.updateCategoryTitle(categoriesDto);
		if(updateCategory!=null) {
			response.setMessage("sucessfully");
			response.setSatus("updated");
			response.setData(updateCategory);
		}
		return new ResponseEntity<AppResponse>(response, HttpStatus.OK);
	}
	
	@PostMapping("/updateproduct")
	public ResponseEntity<AppResponse> updateProduct(@RequestBody ProductsDto productsDto ) {
		ProductEntity updateProduct = service.updateProduct(productsDto);
		if(updateProduct!=null) {
			response.setMessage("sucessfully");
			response.setSatus("updated");
			response.setData(updateProduct);
		}
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	@PostMapping("/updateVariation")
	public ResponseEntity<AppResponse> updateVariation(@RequestBody VariationsDto variationsDto) {
		VariationsEntity updateVariation = service.updateVariation(variationsDto);
		if(updateVariation!=null) {
			response.setMessage("sucessfully");
			response.setSatus("updated");
			response.setData(updateVariation);
		}
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	@PostMapping("/updateVariationType")
	public ResponseEntity<AppResponse> updateVariationType(@RequestBody VariationTypesDto variationTypesDto) {
		VariationTypesEntity updateVariatioType = service.updateVariatioType(variationTypesDto);
		if(updateVariatioType!=null) {
			response.setMessage("sucessfully");
			response.setSatus("updated");
			response.setData(updateVariatioType);
		}
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	@PostMapping("/updateOption")
	public ResponseEntity<AppResponse> updateOption(@RequestBody OptionsDto optionsDto) {
		OptionsEntity updateOptions = service.updateOptions(optionsDto);
		if(updateOptions!=null) {
			response.setMessage("sucessfully");
			response.setSatus("updated");
			response.setData(updateOptions);
		}
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	@PostMapping("/updateOptionType")
	public ResponseEntity<AppResponse> updateOptionType(@RequestBody OptionTypesDto optionTypesDto) {
		OptionTypesEntity updateOptionType = service.updateOptionType(optionTypesDto);
		if(updateOptionType!=null) {
			response.setMessage("sucessfully");
			response.setSatus("updated");
			response.setData(updateOptionType);
		}
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteProduct")
	public ResponseEntity<AppResponse> deleteProduct(@RequestBody ProductsDto productsDto) {
		Boolean deleteProduct = service.deleteProduct(productsDto);
		if(deleteProduct) {
			response.setMessage("sucessfully");
			response.setSatus("updated");
		}
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);	
	}
	
	@DeleteMapping("/deleteOption")
	public ResponseEntity<AppResponse> deleteOptions(@RequestBody OptionsDto optionsDto) {
		Boolean deleteOption = service.deleteOption(optionsDto);
		if(deleteOption) {
			response.setMessage("sucessfully");
			response.setSatus("updated");
		}
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);	
	}
	
	@DeleteMapping("/deleteOptionTypes")
	public ResponseEntity<AppResponse> deleteOptionTypes(@RequestBody OptionTypesDto optionTypesDto) {
		Boolean deleteOptionTypes = service.deleteOptionTypes(optionTypesDto);
		if(deleteOptionTypes) {
			response.setMessage("sucessfully");
			response.setSatus("updated");
		}
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	@GetMapping("/sortProduct")
	public ResponseEntity<AppResponse> sortProduct() {
	List<ProductEntity> sortProducts = service.sortProducts();
	if(sortProducts!=null) {
		response.setMessage("sucessfully");
		response.setSatus("updated");
		response.setData(sortProducts);
	}
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	@GetMapping("/sortByVariation")
	public ResponseEntity<AppResponse> sortByVariation() {
		List<VariationsEntity> sortByVariation = service.sortByVariation();
		if(sortByVariation!=null) {
			response.setMessage("sucessfully");
			response.setSatus("updated");
			response.setData(sortByVariation);
		}
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	@GetMapping("/sortByVariationType")
	public ResponseEntity<AppResponse> sortByVariationType() {
		List<VariationTypesEntity> sortByVariationType = service.sortByVariationType();
		if(sortByVariationType!=null) {
			response.setMessage("sucessfully");
			response.setSatus("updated");
			response.setData(sortByVariationType);
		}
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	@GetMapping("/sortOptions")
	public ResponseEntity<AppResponse> sortByOption() {
		List<OptionsEntity> sortByOption = service.sortByOption();
		if(sortByOption!=null) {
			response.setMessage("sucessfully");
			response.setSatus("updated");
			response.setData(sortByOption);
		}
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	@GetMapping("/sortOptionsType")
	public ResponseEntity<AppResponse> sortByOptionType() {
		List<OptionTypesEntity> sortByOptionType = service.sortByOptionType();
		if(sortByOptionType!=null) {
			response.setMessage("sucessfully");
			response.setSatus("updated");
			response.setData(sortByOptionType);
		}
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	@PostMapping("/searchProduct")
	public ResponseEntity<AppResponse> searchProduct(int productsId) {
		List<SearchProductDto> serachProduct = service.serachProduct(productsId);
		if(serachProduct!=null) {
			response.setMessage("sucessfully");
			response.setSatus("updated");
			response.setData(serachProduct);
		}
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	@PostMapping("/searchCategory")
	public ResponseEntity<AppResponse> searchCategory(int catogorysId) {
		List<SearchCategoryDto> serachCategory = service.serachCategory(catogorysId);
		if(serachCategory!=null) {
			response.setMessage("sucessfully");
			response.setSatus("updated");
			response.setData(serachCategory);
		}
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
}
