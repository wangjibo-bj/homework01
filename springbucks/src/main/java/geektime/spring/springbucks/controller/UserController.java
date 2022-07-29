package geektime.spring.springbucks.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import geektime.spring.springbucks.model.Student;
import geektime.spring.springbucks.model.User;
import geektime.spring.springbucks.service.CacheService;
import geektime.spring.springbucks.service.UserService01;
import geektime.spring.springbucks.util.BitMap;
import geektime.spring.springbucks.util.IdGenerateUtil;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/userInfo")
@Api(tags = "用户模块--作业")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService01 userService;

	@Autowired
	private CacheService cacheService;

	/**
	 * （1）实现：查询，查询时需要实现翻页 查询时增加将结果缓存到 redis
	 * 
	 * URL：http://localhost:58081/userInfo/getUserInfoByPage
	 */
	@GetMapping("/getUserInfoByPage")
	public void getUserInfoByPage() {
		// 分页查询--将结果缓存到 redis
		int pageNum = 1; // 页数
		int pageSize = 2; // 每页大小
		PageInfo<User> userPageInfo = userService.getUserByPage(pageNum, pageSize);
		List<User> userPageList = userPageInfo.getList();
		for (User user : userPageList) {
			// 查询时增加将结果缓存到 redis
			try {
				cacheService.add(user.getUsername(), user.getPassword());
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("缓存结果：{}, 写入失败", cacheService.get(user.getUsername()));
			}

			logger.info("缓存结果：{}", cacheService.get(user.getUsername()));
		}
	}

	/**
	 * （1）实现：查询，查询时需要实现根据主键批量查询 查询时增加将结果缓存到 redis
	 * URL：http://localhost:58081/userInfo/getUserInfoById?id=01
	 */
	@GetMapping("/getUserInfoById")
	public void getUserInfoById(int id) {
		// 根据主键查询--将结果缓存到 redis
		User user = userService.getUser(id);

		try {
			cacheService.add(user.getUsername(), user.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("缓存结果：{}, 写入失败", cacheService.get(user.getUsername()));
		}
		// 输出缓存结果
		logger.info("缓存结果：{}", cacheService.get(user.getUsername()));
	}

	/**
	 * （1）新增-加入事务管理，通过注解 
	 * URL：http://localhost:58081/userInfo/addUserInfo
	 */
	@GetMapping("/addUserInfo")
	public void addUserInfo() {
		User user = new User();
		user.setUsername("测试");
		user.setPassword(String.valueOf(System.currentTimeMillis()));
		userService.addUser(user);
	}

	/**
	 * （1）修改加入事务管理，通过注解 url:http://localhost:58081/userInfo/updateUserInfo?id=2
	 */
	@Transactional
	@GetMapping("/updateUserInfo")
	public void updateUserInfo(int id) {

		User user = userService.getUser(id);
		user.setPassword(String.valueOf(System.currentTimeMillis()));
		userService.updateUser(user);
	}

	/**
	 * （1）删除加入事务管理，通过注解 
	 * URL：http://localhost:58081/userInfo/deleteUserInfo?id=2
	 */
	@Transactional
	@GetMapping("/deleteUserInfo")
	public void deleteUserInfo(int id) {

		User userList = userService.getUser(id);

		if (!ObjectUtils.isEmpty(userList)) {
			User user = new User();
			user.setId(Long.valueOf(id));
			try {
				userService.deleteUser(user);
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("用户删除失败不存在");
			}
		} else {
			logger.info("用户不存在");
		}
	}

	/**
	 * （5）实现分数排名或者排行榜；
	 * url:http://localhost:58081/userInfo/getStudentScore
	 */
	@GetMapping("/getStudentScore")
	public void getStudentScore() {
		List<Student> list = new ArrayList<>();
		list.add(new Student("张三", new BigDecimal("90")));
		list.add(new Student("李四", new BigDecimal("89")));
		list.add(new Student("王五", new BigDecimal("99.5")));
		list.add(new Student("赵四", new BigDecimal("62")));

		list.sort(new Comparator<Student>() {
			@Override
			public int compare(Student student1, Student student2) {
				BigDecimal score1 = student1.getScore();
				BigDecimal score2 = student2.getScore();
				return score2.compareTo(score1);
			}
		});
		int i = 1;
		for (Student stu : list) {

			logger.info("姓名：{}，成绩：{}，名次：{}", stu.getUsername(), stu.getScore(), i);
			i++;
		}
	}

	/**
	 * （5）实现全局 ID 生成；
	 * url:http://localhost:58081/userInfo/getIdGenerate
	 */
	@GetMapping("/getIdGenerate")
	public void getIdGenerate() {
		IdGenerateUtil util = new IdGenerateUtil();
		logger.info("{}", util.nextId());
	}

	/**
	 * （5）基于 Bitmap 实现 id 去重；
	 * url:http://localhost:58081/userInfo/bitMapQuChong
	 */
	@GetMapping("/bitMapQuChong")
	public void bitMapQuChong() {
		new BitMap().findDuplicate();
		new BitMap().findDup_jdk();
	}
}
