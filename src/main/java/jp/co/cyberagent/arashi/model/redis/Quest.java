package jp.co.cyberagent.arashi.model.redis;

import java.io.Serializable;
import java.util.List;

public class Quest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3787710974740716142L;
	private int id;
	private String name;
	private String des;
	List<Integer> monsters;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public List<Integer> getMonsters() {
		return monsters;
	}

	public void setMonsters(List<Integer> monsters) {
		this.monsters = monsters;
	}

	public Quest(int id, String name, String des, List<Integer> monsters) {
		super();
		this.id = id;
		this.name = name;
		this.des = des;
		this.monsters = monsters;
	}

	public Quest() {
		super();
	}

}
