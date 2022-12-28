package com.te.pcm.pcmServiceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.te.pcm.pcmDto.CategoriesDto;
import com.te.pcm.pcmDto.DepartmentsDto;
import com.te.pcm.pcmDto.EmployeeDto;
import com.te.pcm.pcmDto.OptionTypesDto;
import com.te.pcm.pcmDto.OptionsDto;
import com.te.pcm.pcmDto.ProductByIdDto;
import com.te.pcm.pcmDto.ProductsDto;
import com.te.pcm.pcmDto.SearchCategoryDto;
import com.te.pcm.pcmDto.SearchProductDto;
import com.te.pcm.pcmDto.VariationTypesDto;
import com.te.pcm.pcmDto.VariationsDto;
import com.te.pcm.pcmEntity.AppUser;
import com.te.pcm.pcmEntity.CategoriesEntity;
import com.te.pcm.pcmEntity.DepartmentsEntity;
import com.te.pcm.pcmEntity.EmployeeEntity;
import com.te.pcm.pcmEntity.OptionTypesEntity;
import com.te.pcm.pcmEntity.OptionsEntity;
import com.te.pcm.pcmEntity.ProductEntity;
//import com.te.pcm.pcmEntity.Roles;
import com.te.pcm.pcmEntity.VariationTypesEntity;
import com.te.pcm.pcmEntity.VariationsEntity;
import com.te.pcm.pcmRepository.CategoryRepository;
import com.te.pcm.pcmRepository.EmpRegisterRepository;
import com.te.pcm.pcmRepository.OptionTypeRepository;
import com.te.pcm.pcmRepository.OptionsRepository;
import com.te.pcm.pcmRepository.ProductRepository;
import com.te.pcm.pcmRepository.RegisterRepository;
//import com.te.pcm.pcmRepository.RolesRepository;
import com.te.pcm.pcmRepository.UserRepository;
import com.te.pcm.pcmRepository.VariationRepository;
import com.te.pcm.pcmRepository.VariationTypeRepository;
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
	
//	@Autowired
//	private RolesRepository rolesRepository;

	@Override
	public DepartmentsEntity register(DepartmentsEntity departmentsEntity) {
		return repository.save(departmentsEntity);
	}
	
	@Override
	public EmployeeEntity empRegister(EmployeesDto employeeDto) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employeeDto,employeeEntity );
		String empPassword = employeeDto.getEmpPassword();
		String encode = new BCryptPasswordEncoder().encode(empPassword);
		AppUser appUser =new AppUser();
//		Roles roles = new Roles();
		EmployeeEntity findByEmpName = empRegisterRep.findByEmpName(employeeDto.getEmpName());
		appUser.setUserName(employeeDto.getEmpName());
		appUser.setPassword(encode);
		appUser.setRoles(employeeDto.getEmpRoles());
		userRepository.save(appUser);
		return empRegisterRep.save(employeeEntity);
	}

	@Override
	public List<DepartmentsEntity> getall() {
		List<DepartmentsEntity> findAll = repository.findAll();
		return findAll;
	}

	@Override
	public List<EmployeeDto> getEmployee() {
		List<EmployeeEntity> findAll = empRegisterRep.findAll();
		List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();
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
		List<DepartmentsEntity> findAll = repository.findAll();
//		Stream<DepartmentsEntity> sorted = findAll.stream().sorted();
		return findAll;
	}

	@Override
	public DepartmentsEntity updateCategoryTitle(CategoriesDto categoriesDto) {
//	DepartmentsEntity departmentsEntity = new DepartmentsEntity();
		CategoriesEntity categoriesEntity = new CategoriesEntity();
		BeanUtils.copyProperties(categoriesDto, categoriesEntity);
		DepartmentsEntity entity = repository.findById(categoriesDto.getDepartmentId()).orElse(null);
		if (entity != null) {
//		List<CategoriesEntity> category = entity.getCategoriesEntities().stream().filter(c -> c.getCategoryId()>0).collect(Collectors.toList());
			List<CategoriesEntity> category = entity.getCategoriesEntities();
			for (CategoriesEntity categoriesEntitys : category) {
//				categoriesEntitys.setCategoryId(categoriesDto.getCategoryId());
				categoriesEntitys.setCategoryTitle(categoriesDto.getCategoryTitle());
			}
			entity.setCategoriesEntities(category);
			return repository.save(entity);
		}
		return null;
	}

	@Override
	public CategoriesEntity updateCategory(CategoriesDto categoriesDto) {
		CategoriesEntity categoriesEntity = categoryRepository.findById(categoriesDto.getCategoryId()).orElse(null);
		categoriesEntity.setCategoryTitle(categoriesDto.getCategoryTitle());
		return categoryRepository.save(categoriesEntity);
	}

	@Override
	public ProductEntity updateProduct(ProductsDto productsDto) {
		ProductEntity productEntity = productRepository.findById(productsDto.getProductId()).orElse(null);
		productEntity.setProductTitle(productsDto.getProductTitle());
		return productRepository.save(productEntity);
	}

	@Override
	public VariationsEntity updateVariation(VariationsDto variationsDto) {
		VariationsEntity variationsEntity = variationRepository.findById(variationsDto.getVariationId()).orElse(null);
		variationsEntity.setVariationTitle(variationsDto.getVariationTitle());
		return variationRepository.save(variationsEntity);
	}

	@Override
	public VariationTypesEntity updateVariatioType(VariationTypesDto variationTypesDto) {
		VariationTypesEntity variationTypesEntity = variationTypeRepository
				.findById(variationTypesDto.getVariationTypeId()).orElse(null);
		variationTypesEntity.setVariationTypeTitle(variationTypesDto.getVariationTypeTitle());
		return variationTypeRepository.save(variationTypesEntity);
	}

	@Override
	public OptionsEntity updateOptions(OptionsDto optionsDto) {
		OptionsEntity optionsEntity = optionsRepository.findById(optionsDto.getOptionId()).orElse(null);
		optionsEntity.setOptionTitle(optionsDto.getOptionTitle());
		return optionsRepository.save(optionsEntity);
	}

	@Override
	public OptionTypesEntity updateOptionType(OptionTypesDto optionTypesDto) {
		OptionTypesEntity optionTypesEntity = optionTypeRepository.findById(optionTypesDto.getOptionTypeId())
				.orElse(null);
		optionTypesEntity.setOptionTypeTitle(optionTypesDto.getOptionTypeTitle());
		return optionTypeRepository.save(optionTypesEntity);
	}

	@Override
	public Boolean deleteProduct(ProductsDto productsDto) {
		ProductEntity productEntity = new ProductEntity();
		BeanUtils.copyProperties(productsDto, productEntity);
		if (productRepository.findById(productsDto.getProductId()) != null) {
			productRepository.delete(productEntity);
		}
		return true;
	}

	@Override
	public Boolean deleteOption(OptionsDto optionsDto) {
		OptionsEntity optionsEntity = new OptionsEntity();
		BeanUtils.copyProperties(optionsDto, optionsEntity);
		if (optionsRepository.findById(optionsDto.getOptionId()) != null) {
			optionsRepository.delete(optionsEntity);
		}
		return true;
	}

	@Override
	public Boolean deleteOptionTypes(OptionTypesDto optionTypesDto) {
		OptionTypesEntity optionTypesEntity = new OptionTypesEntity();
		BeanUtils.copyProperties(optionTypesDto, optionTypesEntity);
		if (optionTypeRepository.findById(optionTypesDto.getOptionTypeId()) != null) {
			optionTypeRepository.delete(optionTypesEntity);
		}
		return true;
	}

	@Override
	public List<ProductEntity> sortProducts() {
//		List<ProductEntity> findById = productRepository.findById(productsDto.getProductId());
		List<ProductEntity> findAll = productRepository.findAll();
		List<ProductEntity> collect = findAll.stream()
				.sorted((s1, s2) -> s1.getProductTitle().compareTo(s2.getProductTitle())).collect(Collectors.toList());
		return collect;
	}

	@Override
	public List<VariationsEntity> sortByVariation() {
	List<VariationsEntity> findAll = variationRepository.findAll();
		List<VariationsEntity> collect = findAll.stream()
				.sorted((s1, s2) -> s1.getVariationTitle().compareTo(s2.getVariationTitle()))
				.collect(Collectors.toList());
		return collect;
	}

	@Override
	public List<VariationTypesEntity> sortByVariationType() {
List<VariationTypesEntity> findAll = variationTypeRepository.findAll();
		List<VariationTypesEntity> collect = findAll.stream()
				.sorted((s1, s2) -> s1.getVariationTypeTitle().compareTo(s2.getVariationTypeTitle()))
				.collect(Collectors.toList());
		return collect;
	}

	@Override
	public List<OptionsEntity> sortByOption() {
		List<OptionsEntity> findAll = optionsRepository.findAll();
		List<OptionsEntity> collect = findAll.stream()
				.sorted((s1, s2) -> s1.getOptionTitle().compareTo(s2.getOptionTitle())).collect(Collectors.toList());
		return collect;
	}

	@Override
	public List<OptionTypesEntity> sortByOptionType() {
		List<OptionTypesEntity> typesEntities = new ArrayList<OptionTypesEntity>();
//		BeanUtils.copyProperties(optionTypesDto, typesEntities);
//		Optional<OptionTypesEntity> findById = optionTypeRepository.findById(optionTypesDto.getOptionTypeId());
		List<OptionTypesEntity> findAll = optionTypeRepository.findAll();
		List<OptionTypesEntity> collect = findAll.stream()
				.sorted((s1, s2) -> s1.getOptionTypeTitle().compareTo(s2.getOptionTypeTitle()))
				.collect(Collectors.toList());
		return collect;
	}

	@Override
	public List<SearchProductDto> serachProduct(int productsId) {
		DepartmentsEntity entity = repository.findById(productsId).orElse(null);
		List<SearchProductDto> productsDto = new ArrayList<SearchProductDto>();
		List<ProductEntity> productEntities = entity.getProductEntity();
		if(entity!=null) {
		for (ProductEntity productEntity : productEntities) {
			int productId = productEntity.getProductId();
			String productTitle = productEntity.getProductTitle();
			productsDto.add(new SearchProductDto(productId,productTitle));
			}
			return productsDto;
		}
		return null;
	}

	@Override
	public List<SearchCategoryDto> serachCategory(int categorystId) {
		DepartmentsEntity entity = repository.findById(categorystId).orElse(null);
		List<SearchCategoryDto> categoryDtos = new ArrayList<SearchCategoryDto>();
		List<CategoriesEntity> categoriesEntities = entity.getCategoriesEntities();
		if(entity!=null) {
			for (CategoriesEntity categoriesEntity : categoriesEntities) {
				int categoryId = categoriesEntity.getCategoryId();
				String categoryTitle = categoriesEntity.getCategoryTitle();
				categoryDtos.add(new SearchCategoryDto(categoryId,categoryTitle));
			}
			return categoryDtos;
		}
		return null;
	}






	

}
