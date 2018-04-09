package controllers;

import mongo.entity.news.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.NewsService;

import java.util.List;

/**
 * Created by Administrator on 2018/3/27.
 */
@RestController
@RequestMapping("/news")
public class NewsController {

	@Autowired
	private NewsService newsService;

	@RequestMapping(method = RequestMethod.GET, value = "/size")
	public int size(@RequestParam(name = "type") String type) {
		int size = newsService.countNewsSize(type);
		return size;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/page")
	public List<? extends News> page(@RequestParam(name="type") String type, @RequestParam("page") int page,
	                       @RequestParam("pageSize") int pageSize){
		List<? extends News> page_list = newsService.page(page, pageSize, type);
		return page_list;
	}

	@RequestMapping(method= RequestMethod.POST, value="/addNews")
	public void addNews(@RequestParam(name="type") String type, @RequestBody News news){
		newsService.insertNews(type, news);
	}

}
