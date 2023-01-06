package com.te.pcm.pcmserviceimp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.te.pcm.exception.InvalidId;
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
import com.te.pcm.pcmentity.AppUser;
import com.te.pcm.pcmentity.CategoriesEntity;
import com.te.pcm.pcmentity.DepartmentsEntity;
import com.te.pcm.pcmentity.EmployeeEntity;
import com.te.pcm.pcmentity.OptionTypesEntity;
import com.te.pcm.pcmentity.OptionsEntity;
import com.te.pcm.pcmentity.ProductEntity;
import com.te.pcm.pcmentity.VariationTypesEntity;
import com.te.pcm.pcmentity.VariationsEntity;
import com.te.pcm.pcmrepository.CategoryRepository;
import com.te.pcm.pcmrepository.EmpRegisterRepository;
import com.te.pcm.pcmrepository.OptionTypeRepository;
import com.te.pcm.pcmrepository.OptionsRepository;
import com.te.pcm.pcmrepository.ProductRepository;
import com.te.pcm.pcmrepository.RegisterRepository;
import com.te.pcm.pcmrepository.UserRepository;
import com.te.pcm.pcmrepository.VariationRepository;
import com.te.pcm.pcmrepository.VariationTypeRepository;
import com.te.pcm.pcmservice.PcmService;

@Service
public class PcmServiceImp implements PcmService {
	@Autowired
	private RegisterRepository repository;

	@Autowired
	private EmpRegisterRepository empRegisterRep;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private VariationRepository variationRepository;

	@Autowired
	private VariationTypeRepository variationTypeRepository;

	@Autowired
	private OptionsRepository optionsRepository;

	@Autowired
	private OptionTypeRepository optionTypeRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public DepartmentsEntity register(DepartmentsDto departmentsDto) {
		DepartmentsEntity departmentsEntity = new DepartmentsEntity();
		BeanUtils.copyProperties(departmentsDto, departmentsEntity);
		return repository.save(departmentsEntity);
	}

	@Override
	public EmployeeEntity empRegister(EmployeesDto employeeDto) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employeeDto, employeeEntity);
		String empPassword = employeeDto.getEmpPassword();
		String encode = new BCryptPasswordEncoder().encode(empPassword);
		AppUser appUser = new AppUser();
//		Roles roles = new Roles();
//		EmployeeEntity findByEmpName = empRegisterRep.findByEmpName(employeeDto.getEmpName());
		appUser.setUserName(employeeDto.getEmpName());
		appUser.setPassword(encode);
		appUser.setRole(employeeDto.getEmpRoles());
		userRepository.save(appUser);
		return empRegisterRep.save(employeeEntity);
	}

	@Override
	public List<DepartmentsEntity> getall() {
		return repository.findAll();
	}

	@Override
	public List<EmployeeDto> getEmployee() {
		List<EmployeeEntity> findAll = empRegisterRep.findAll();
		List<EmployeeDto> employeeDtos = new ArrayList<>();
		for (EmployeeEntity employee : findAll) {
			int empId = employee.getEmpId();
			String empName = employee.getEmpName();
			String empEmail = employee.getEmpEmail();
			String empRoles = employee.getEmpRoles();
			long empPhone = employee.getEmpPhone();
			employeeDtos.add(new EmployeeDto(empId, empName, empEmail, empPhone, empRoles));
		}
		return employeeDtos;
	}

	@Override
	public List<DepartmentsEntity> getById(ProductByIdDto productByIdDto) {
		BeanUtils.copyProperties(productByIdDto, repository);
		return repository.findAll();
	}

	@Override
	public DepartmentsEntity updateCategoryTitle(CategoriesDto categoriesDto) {
		CategoriesEntity categoriesEntity = new CategoriesEntity();
		BeanUtils.copyProperties(categoriesDto, categoriesEntity);
		DepartmentsEntity entity = repository.findById(categoriesDto.getDepartmentId()).orElse(null);
		if (entity != null) {
			List<CategoriesEntity> category = entity.getCategoriesEntities();
			for (CategoriesEntity categoriesEntitys : category) {
				categoriesEntitys.setCategoryTitle(categoriesDto.getCategoryTitle());
			}
			entity.setCategoriesEntities(category);
			return repository.save(entity);
		}
		throw new InvalidId("please enter the valid id");
	}

	@Override
	public CategoriesEntity updateCategory(CategoriesDto categoriesDto) {
		CategoriesEntity categoriesEntity = categoryRepository.findById(categoriesDto.getCategoryId())
				.orElseThrow(RuntimeException::new);
		categoriesEntity.setCategoryTitle(categoriesDto.getCategoryTitle());
		return categoryRepository.save(categoriesEntity);
	}

	@Override
	public ProductEntity updateProduct(ProductsDto productsDto) {
		ProductEntity productEntity = productRepository.findById(productsDto.getProductId())
				.orElseThrow(RuntimeException::new);
		productEntity.setProductTitle(productsDto.getProductTitle());
		return productRepository.save(productEntity);
	}

	@Override
	public VariationsEntity updateVariation(VariationsDto variationsDto) {
		VariationsEntity variationsEntity = variationRepository.findById(variationsDto.getVariationId())
				.orElseThrow(RuntimeException::new);
		variationsEntity.setVariationTitle(variationsDto.getVariationTitle());
		return variationRepository.save(variationsEntity);
	}

	@Override
	public VariationTypesEntity updateVariatioType(VariationTypesDto variationTypesDto) {
		VariationTypesEntity variationTypesEntity = variationTypeRepository
				.findById(variationTypesDto.getVariationTypeId()).orElseThrow(RuntimeException::new);
		variationTypesEntity.setVariationTypeTitle(variationTypesDto.getVariationTypeTitle());
		return variationTypeRepository.save(variationTypesEntity);
	}

	@Override
	public OptionsEntity updateOptions(OptionsDto optionsDto) {
		OptionsEntity optionsEntity = optionsRepository.findById(optionsDto.getOptionId())
				.orElseThrow(RuntimeException::new);
		optionsEntity.setOptionTitle(optionsDto.getOptionTitle());
		return optionsRepository.save(optionsEntity);
	}

	@Override
	public OptionTypesEntity updateOptionType(OptionTypesDto optionTypesDto) {
		OptionTypesEntity optionTypesEntity = optionTypeRepository.findById(optionTypesDto.getOptionTypeId())
				.orElseThrow(RuntimeException::new);
		optionTypesEntity.setOptionTypeTitle(optionTypesDto.getOptionTypeTitle());
		return optionTypeRepository.save(optionTypesEntity);
	}

	@Override
	public Boolean deleteProduct(ProductsDto productsDto) {
		ProductEntity entity = productRepository.findById(productsDto.getProductId())
				.orElseThrow(RuntimeException::new);
		productRepository.deleteById(entity.getProductId());
		return true;
	}

	@Override
	public Boolean deleteOption(OptionsDto optionsDto) {
		OptionsEntity entity = optionsRepository.findById(optionsDto.getOptionId()).orElseThrow(RuntimeException::new);
		optionsRepository.deleteById(entity.getOptionId());
		return true;
	}

	@Override
	public Boolean deleteOptionTypes(OptionTypesDto optionTypesDto) {
		OptionTypesEntity entity = optionTypeRepository.findById(optionTypesDto.getOptionTypeId())
				.orElseThrow(RuntimeException::new);
		optionTypeRepository.deleteById(entity.getOptionTypeId());
		return true;
	}

	@Override
	public List<ProductEntity> sortProducts() {
		List<ProductEntity> findAll = productRepository.findAll();
		return findAll.stream().sorted((s1, s2) -> s1.getProductTitle().compareTo(s2.getProductTitle()))
				.collect(Collectors.toList());
	}

	@Override
	public List<VariationsEntity> sortByVariation() {
		List<VariationsEntity> findAll = variationRepository.findAll();
		return findAll.stream().sorted((s1, s2) -> s1.getVariationTitle().compareTo(s2.getVariationTitle()))
				.collect(Collectors.toList());
	}

	@Override
	public List<VariationTypesEntity> sortByVariationType() {
		List<VariationTypesEntity> findAll = variationTypeRepository.findAll();
		return findAll.stream().sorted((s1, s2) -> s1.getVariationTypeTitle().compareTo(s2.getVariationTypeTitle()))
				.collect(Collectors.toList());
	}

	@Override
	public List<OptionsEntity> sortByOption() {
		List<OptionsEntity> findAll = optionsRepository.findAll();
		return findAll.stream().sorted((s1, s2) -> s1.getOptionTitle().compareTo(s2.getOptionTitle()))
				.collect(Collectors.toList());
	}

	@Override
	public List<OptionTypesEntity> sortByOptionType() {
		List<OptionTypesEntity> findAll = optionTypeRepository.findAll();
		return findAll.stream().sorted((s1, s2) -> s1.getOptionTypeTitle().compareTo(s2.getOptionTypeTitle()))
				.collect(Collectors.toList());
	}

	@Override
	public List<SearchProductDto> serachProduct(int productsId) {
		DepartmentsEntity entity = repository.findById(productsId).orElseThrow(RuntimeException::new);
		List<SearchProductDto> productsDto = new ArrayList<>();
		List<ProductEntity> productEntities = entity.getProductEntity();
			for (ProductEntity productEntity : productEntities) {
				int productId = productEntity.getProductId();
				String productTitle = productEntity.getProductTitle();
				productsDto.add(new SearchProductDto(productId, productTitle));
		}
			return productsDto;
	}

	@Override
	public List<SearchCategoryDto> serachCategory(int categorystId) {
		DepartmentsEntity entity = repository.findById(categorystId).orElseThrow(RuntimeException::new);
		List<SearchCategoryDto> categoryDtos = new ArrayList<>();
		List<CategoriesEntity> categoriesEntities = entity.getCategoriesEntities();
			for (CategoriesEntity categoriesEntity : categoriesEntities) {
				int categoryId = categoriesEntity.getCategoryId();
				String categoryTitle = categoriesEntity.getCategoryTitle();
				categoryDtos.add(new SearchCategoryDto(categoryId, categoryTitle));
			}
			return categoryDtos;
	}

	@Override
	public DepartmentsEntity register(DepartmentsEntity departmentsEntity) {
		return repository.save(departmentsEntity);
	}

}
