package com.example.CoverageRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoverageRepoController {
	//https://pcf-demo-repo-app1.cfapps.io/retrunInterestService/1000/for/5
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CoverageRepository repository;
	
	//https://pcf-demo-coverage-repo.cfapps.io/hello/ pcf link
	
	
	@GetMapping("/hello")
	public String hello( ){
		
		return "hello";
		
		
	}
	@GetMapping("/retrunInterestService/{premium}/for/{year}")
	public CoverageRepoBean retrunInterest(@PathVariable long premium ,@PathVariable int year ){
		
		CoverageRepoBean coveragerepo= repository.findByPremiumAndYear(premium,year);
		coveragerepo.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return coveragerepo;
		
		
	}
	@PostMapping("/saveInterests")
	public void saveInterest(@RequestBody CoverageRepoBean repo ){
		
		repository.save(repo);
			
	}

}
