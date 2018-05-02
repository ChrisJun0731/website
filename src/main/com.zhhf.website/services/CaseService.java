package services;

import mongo.entity.cases.*;
import mongo.repository.cases.*;
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
	private OfficeRepository officeRepository;
	@Autowired
	private CommercialRepository commRepository;
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private RestaurantRepository restRepository;
	@Autowired
	private EduRepository eduRepository;

	/**
	 * 查询装修案例的总数
	 * @param type
	 */
	public int count_size(String type){
		int size = 0;
		switch(type){
			case "office":
				size = (int)officeRepository.count();
				break;
			case "commercial":
				size = (int)commRepository.count();
				break;
			case "hotel":
				size = (int)hotelRepository.count();
				break;
			case "restaurant":
				size = (int)restRepository.count();
				break;
			case "edu":
				size = (int)eduRepository.count();
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
			case "office":
				Page<OfficeCase> office_page = officeRepository.findAll(pageRequest);
				pageList = office_page.getContent();
				break;
			case "hotel":
				Page<HotelCase> hotel_page = hotelRepository.findAll(pageRequest);
				pageList = hotel_page.getContent();
				break;
			case "commercial":
				Page<CommercialCase> comm_page = commRepository.findAll(pageRequest);
				pageList = comm_page.getContent();
				break;
			case "restaurant":
				Page<RestaurantCase> rest_page = restRepository.findAll(pageRequest);
				pageList = rest_page.getContent();
				break;
			case "edu":
				Page<EduCase> edu_page = eduRepository.findAll(pageRequest);
				pageList = edu_page.getContent();
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
			case "office":
				officeRepository.insert((OfficeCase) cases);
				break;
			case "hotel":
				hotelRepository.insert((HotelCase)cases);
				break;
			case "commercial":
				commRepository.insert((CommercialCase)cases);
				break;
			case "restaurant":
				restRepository.insert((RestaurantCase)cases);
				break;
			case "edu":
				eduRepository.insert((EduCase)cases);
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
			case "office":
				cases = officeRepository.findAll();
				break;
			case "commercial":
				cases = commRepository.findAll();
				break;
			case "restaurant":
				cases = restRepository.findAll();
				break;
			case "hotel":
				cases = hotelRepository.findAll();
				break;
			case "edu":
				cases = eduRepository.findAll();
				break;
		}
		return cases;
	}
}
