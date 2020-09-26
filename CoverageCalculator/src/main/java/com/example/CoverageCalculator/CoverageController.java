package com.example.CoverageCalculator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//http://pcf-demo-calc-app1.cfapps.io/coverageCalculationFeign/1000/for/5
@RestController
public class CoverageController {
	@Autowired
	private CoverageFeignProxy proxy;
	@GetMapping("coverageCalculation/{premium}/for/{year}")
	public CoverageCalculatorBean coverageCalculator(@PathVariable long premium, @PathVariable int year)
	{
		Map<String,Object> uriVariables=new HashMap<>();
		uriVariables.put("premium",premium);
		uriVariables.put("year",year);
		
		
		ResponseEntity <CoverageCalculatorBean> responseentity= new RestTemplate().
				getForEntity("http://localhost:8888/retrunInterestService/{premium}/for/{year}", CoverageCalculatorBean.class,uriVariables);
		CoverageCalculatorBean response=responseentity.getBody();
		return new CoverageCalculatorBean(response.getId(),premium,year,response.getInterest(),response.getInterest().multiply(BigDecimal.valueOf(premium)),response.getPort());
	}
	@GetMapping("coverageCalculationFeign/{premium}/for/{year}")
	public CoverageCalculatorBean coverageCalculatorFeign(@PathVariable long premium, @PathVariable int year)
	{
		
		CoverageCalculatorBean response= proxy.coverageCalculatorFeign(premium, year);
		return new CoverageCalculatorBean(response.getId(),premium,year,response.getInterest(),response.getInterest().multiply(BigDecimal.valueOf(premium)),response.getPort());
	}
	

}
