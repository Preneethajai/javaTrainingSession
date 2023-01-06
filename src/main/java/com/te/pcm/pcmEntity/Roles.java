package com.te.pcm.pcmentity;
//package com.te.pcm.pcmEntity;
//
//import java.util.List;
//
//import javax.annotation.Generated;
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//
//import org.hibernate.annotations.ValueGenerationType;
//
//import com.google.common.collect.Lists;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//
//@Entity
//@Builder
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Roles {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer roleId;
//	private String roles;
//	
//	@OneToMany(cascade = CascadeType.ALL)
////	@JoinColumn(name = "roleId")
//	private List<AppUser> appUser;
//
//}
