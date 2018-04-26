package services;

import mongo.entity.cases.Case;
import mongo.entity.cases.CommercialCase;
import mongo.entity.cases.HotelCase;
import mongo.entity.cases.OfficeCase;
import mongo.repository.cases.HotelRepository;
import mongo.repository.cases.OfficeRepository;
import mongo.repository.cases.CommercialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/3/31.
 */
@Service
public class CaseService {

	@Autowired
	private CommercialRepository publicRepository;
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private OfficeRepository houseRepository;

	/**
	 * 查询装修案例的总数
	 * @param type
	 */
	public int count_size(String type){
		int size = 0;
		switch(type){
			case "public":
				size = (int)publicRepository.count();
				break;
			case "house":
				size = (int)houseRepository.count();
				break;
			case "hotel":
				size = (int)hotelRepository.count();
				break;
		}
		return size;
	}

	/**
	 * 分页查询案例信息
	 * @param page
	 * @param pageSize
	 * @param type
	 */
	public List<? extends Case> page(int page, int pageSize, String type){
		PageRequest pageRequest = new PageRequest(page, pageSize);
		List<? extends Case> pageList = null;
		switch(type){
			case "public":
				Page<CommercialCase> public_page = publicRepository.findAll(pageRequest);
				pageList = public_page.getContent();
				break;
			case "hotel":
				Page<HotelCase> hotel_page = hotelRepository.findAll(pageRequest);
				pageList = hotel_page.getContent();
				break;
			case "house":
				Page<OfficeCase> house_page = houseRepository.findAll(pageRequest);
				pageList = house_page.getContent();
				break;
		}
		return pageList;
	}

	/**
	 * 插入一条装修案例
	 * @param type
	 * @param cases
	 */
	public void insert(String type, Case cases){
		switch(type){
			case "public":
				publicRepository.insert((CommercialCase)cases);
				break;
			case "hotel":
				hotelRepository.insert((HotelCase)cases);
				break;
			case "house":
				houseRepository.insert((OfficeCase)cases);
				break;
		}
	}

	/**
	 * 查询所有的案例
	 * @param type
	 * @return
	 */
	public List<? extends Case> findAll(String type){
		List<? extends Case> cases = null;
		switch(type){
			case "public":
				cases = publicRepository.findAll();
				break;
			case "hotel":
				cases = hotelRepository.findAll();
				break;
			case "house":
				cases = houseRepository.findAll();
				break;
		}
		return cases;
	}
}
