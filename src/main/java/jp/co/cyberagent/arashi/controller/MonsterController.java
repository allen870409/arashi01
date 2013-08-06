package jp.co.cyberagent.arashi.controller;

import java.util.Set;

import jp.co.cyberagent.arashi.dao.MonsterDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MonsterController {
	
	private final MonsterDao monsterDao;
	@Autowired
	public MonsterController(MonsterDao monsterDao) {
		this.monsterDao = monsterDao;
	}
	
	@RequestMapping(value = "/testredis", method = RequestMethod.GET)
	@ResponseBody
	public void listUser(){
		String ping = monsterDao.ping();//测试是否连接成功,连接成功输出PONG
        System.out.println(ping);

        //首先,我们看下redis服务里是否有数据
        long dbSizeStart = monsterDao.dbSize();
        System.out.println(dbSizeStart);

        monsterDao.set("username", "oyhk");//设值(查看了源代码,默认存活时间30分钟)
        String username = monsterDao.get("username");//取值 
        System.out.println(username);
        monsterDao.set("username1", "oyhk1", 1);//设值,并且设置数据的存活时间(这里以秒为单位)
        String username1 = monsterDao.get("username1");
        System.out.println(username1);
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//我睡眠一会,再去取,这个时间超过了,他的存活时间
        String liveUsername1 = monsterDao.get("username1");
        System.out.println(liveUsername1);//输出null

        //是否存在
        boolean exist = monsterDao.exists("username");
        System.out.println(exist);

        //查看keys
        Set<String> keys = monsterDao.keys("*");//这里查看所有的keys
        System.out.println(keys);//只有username username1(已经清空了)

        //删除
        monsterDao.set("username2", "oyhk2");
        String username2 = monsterDao.get("username2");
        System.out.println(username2);
        monsterDao.del("username2");
        String username2_2 = monsterDao.get("username2");
        System.out.println(username2_2);//如果为null,那么就是删除数据了

        //dbsize
        long dbSizeEnd = monsterDao.dbSize();
        System.out.println(dbSizeEnd);

        //清空reids所有数据
        //monsterDao.flushDB();
		
	}
}
