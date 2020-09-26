package com.example.CoverageCalculator;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="interest-repo-service" ,url="http://localhost:8888")
@FeignClient(name="pcf-interest-repo-service", url="${REPO_URI:http://localhost:8888}")
//@RibbonClient(name ="pcf-interest-repo-service")
public interface CoverageFeignProxy {
	
	@GetMapping("retrunInterestService/{premium}/for/{year}")
	public CoverageCalculatorBean coverageCalculatorFeign(@PathVariable ("premium") long premium, @PathVariable("year") int year);
	

}
