package controllers;

import mongo.entity.cases.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.CaseService;

import java.util.List;

/**
 * Created by Administrator on 2018/3/27.
 */
@RestController
@RequestMapping(value="/case")
public class CaseController {

	@Autowired
	private CaseService caseService;

	@RequestMapping(value="/all")
	public List<? extends Case> findAllCases(@RequestParam(name="type") String type){
		List<? extends Case> cases = null;
		cases = caseService.findAll(type);
		return cases;
	}

	@RequestMapping(method= RequestMethod.POST, value="/addCase")
	public void addCase(@RequestParam(name="type") String type, @RequestBody Case cases){
		caseService.insert(type, cases);
	}

}
