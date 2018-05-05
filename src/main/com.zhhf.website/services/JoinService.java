package services;

import mongo.entity.join.PTrain;
import mongo.entity.join.Recruit;
import mongo.repository.join.PersonalTrainRepository;
import mongo.repository.join.RecruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/4/27.
 */
@Service
public class JoinService {

	@Autowired
	private PersonalTrainRepository pTrainRepository;
	@Autowired
	private RecruitRepository recruitRepository;

	public int getPTrainSize(){
		return (int)pTrainRepository.count();
	}

	public List<PTrain> query_ptrain_page(int page, int pageSize){
		PageRequest pageRequest = new PageRequest(page, pageSize);
		Page<PTrain> pTrainPage = pTrainRepository.findAll(pageRequest);
		List<PTrain> pTrains = pTrainPage.getContent();
		return pTrains;
	}

	public int getRecruitSize(){
		return (int)recruitRepository.count();
	}

	public List<Recruit> query_recruit_page(int page, int pageSize){
		PageRequest pageRequest = new PageRequest(page, pageSize);
		Page<Recruit> recruit_page = recruitRepository.findAll(pageRequest);
		List<Recruit> recruits = recruit_page.getContent();
		return recruits;
	}

	public void saveRecruits(List<Recruit> recruits){
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = dateFormat.format(date);
		for(Recruit recruit: recruits){
			recruit.setDate(dateStr);
		}
		recruitRepository.deleteAll();
		recruitRepository.save(recruits);
	}

	public List<Recruit> loadRecruits(){
		return recruitRepository.findAll();
	}
}
