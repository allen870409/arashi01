package jp.co.cyberagent.arashi.controller;

import java.util.LinkedList;

import jp.co.cyberagent.arashi.dao.QuestDao;
import jp.co.cyberagent.arashi.model.redis.Quest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuestController {
	
	private final QuestDao questDao;
	@Autowired
	public QuestController(QuestDao questDao) {
		this.questDao = questDao;
	}
	
	@RequestMapping(value = "/showQuest/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Quest showQuest(@PathVariable int id){
		return questDao.getQuest(id);
	}
	
	@RequestMapping(value = "/createQuest/{id}/{name}/{des}", method = RequestMethod.GET)
	@ResponseBody
	public void createQuest(@PathVariable int id,@PathVariable String name,@PathVariable String des){
		Quest quest = new Quest(id,name,des,new LinkedList<Integer>());
		questDao.insertQuest(quest);
		
	}
}
