package jp.co.cyberagent.arashi.dao;

import jp.co.cyberagent.arashi.model.redis.Quest;

public interface QuestDao {

	public void insertQuest(Quest quest);

	public Quest getQuest(int id);

}
