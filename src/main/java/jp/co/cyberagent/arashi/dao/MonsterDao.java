package jp.co.cyberagent.arashi.dao;

import java.util.Set;

public interface MonsterDao {

	String ping();

	long dbSize();

	void del(String key);

	void del(byte[] key);

	void set(byte[] key, byte[] value, int liveTime);

	void set(String key, String value, int liveTime);

	void set(String key, String value);

	void set(byte[] key, byte[] value);

	String get(String key);

	byte[] get(byte[] key);

	Set<String> keys(String pattern);

	boolean exists(String key);

	String flushDB();

}
