package jp.co.cyberagent.arashi.dao.impl;

import jp.co.cyberagent.arashi.dao.QuestDao;
import jp.co.cyberagent.arashi.model.redis.Quest;
import jp.co.cyberagent.arashi.uitl.JsonRedisSeriaziler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository  
public class QuestDaoImpl implements QuestDao {  
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	@Autowired
	private JsonRedisSeriaziler seriaziler;

	public void insertQuest(Quest quest) {
		ValueOperations<String, String> operations = redisTemplate
				.opsForValue();
		operations.set("quest:" + quest.getId(),
				seriaziler.seriazileAsString(quest));
	}

	public Quest getQuest(int id) {
		ValueOperations<String, String> operations = redisTemplate
				.opsForValue();
		String json = operations.get("quest:" + id);
		return seriaziler.deserializeAsObject(json, Quest.class);
	}
}  