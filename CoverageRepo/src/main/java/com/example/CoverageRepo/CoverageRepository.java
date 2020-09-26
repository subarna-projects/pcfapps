package com.example.CoverageRepo;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoverageRepository extends JpaRepository<CoverageRepoBean,Integer>{

	CoverageRepoBean findByPremiumAndYear(long premium, int year);
	

}
