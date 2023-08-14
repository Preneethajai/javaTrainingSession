package com.maveric.unobank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maveric.unobank.entity.Audit_Details;

public interface Audit_detailsRepository extends JpaRepository<Audit_Details, Integer> {

	List<Audit_Details> findAllByCaseId(String id);
}
