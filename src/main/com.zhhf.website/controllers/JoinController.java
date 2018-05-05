package controllers;

import mongo.entity.join.PTrain;
import mongo.entity.join.Recruit;
import mongo.repository.join.PersonalTrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.JoinService;

import java.util.List;

/**
 * Created by Administrator on 2018/4/27.
 */
@RestController
public class JoinController {

	@Autowired
	private JoinService joinService;

	@RequestMapping(value="/join/personal_training/size", method = RequestMethod.GET)
	public int getTrainingSize(){
		return joinService.getPTrainSize();
	}

	@RequestMapping(value="/join/personal_training", method=RequestMethod.GET)
	public List<PTrain> p_train_page(@RequestParam(name="page")int page, @RequestParam(name="pageSize") int pageSize){
		return joinService.query_ptrain_page(page, pageSize);
	}

	@RequestMapping(value="/recruit/size", method = RequestMethod.GET)
	public int getRecruitSize(){
		return joinService.getRecruitSize();
	}

	@RequestMapping(value="/recruit", method = RequestMethod.GET)
	public List<Recruit> recruit_page(@RequestParam(name="page")int page, @RequestParam(name="pageSize")int pageSize){
		return joinService.query_recruit_page(page, pageSize);
	}

	@ResponseBody
	@RequestMapping(value="/join/recruit", method=RequestMethod.POST)
	public String uploadRecruits(@RequestBody List<Recruit> recruits){
		joinService.saveRecruits(recruits);
		return "{\"flag\":\"success\"}";
	}

	@ResponseBody
	@RequestMapping(value="/join/recruit", method=RequestMethod.GET)
	public List<Recruit> loadRecruits(){
		return joinService.loadRecruits();
	}
}
