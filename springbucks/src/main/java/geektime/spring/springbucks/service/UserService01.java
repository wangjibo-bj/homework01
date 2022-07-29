package geektime.spring.springbucks.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import geektime.spring.springbucks.mapper.UserMapper;
import geektime.spring.springbucks.model.User;


@Service
public class UserService01 {

	
	private final Logger logger = LoggerFactory.getLogger(UserService01.class);

	@Autowired
	private UserMapper userMapper;

	public User getUser(int id) {
		return userMapper.getUser(id);
	}

	public PageInfo<User> getUserByPage(int pageNum, int pagesize) {
		// 开始分页
		PageHelper.startPage(pageNum, pagesize);
		List<User> user = userMapper.getAllUser();
		PageInfo<User> userPageInfo = new PageInfo<>(user);
		return userPageInfo;
	}

	public void addUser(User user) {
		int size = userMapper.addUser(user);
		if (size != 1) {
			logger.info("数据插入失败");
		}
	}

	public void updateUser(User user) {
		int size = userMapper.updateUser(user);
		if (size != 1) {
			logger.info("数据更新失败");
		}
	}

	public void deleteUser(User user) {
		int size = userMapper.deleteUser(user);
		if (size != 1) {
			logger.info("数据删除更新失败");
		}
	}

}
