package abhi.sb.jwt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import abhi.sb.jwt.entity.UserInfo;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public String greatings() {
		return "Wellcome to Home Page";
	}
	
	
	@Override
//	public UserInfo createUser(UserInfo userInfo) {
	public int createUser(UserInfo userInfo) {
		String sql = "INSERT INTO abhi_db.UserInfo(username, password, roles) VALUES (?, ?, ?)";
//		id, userInfo.getId() ==> Auto Genaration
		Object[] args = {userInfo.getUsername(), userInfo.getPassword(), userInfo.getRoles()};
		
		int update = jdbcTemplate.update(sql, args);
		
		return update;
	}	
	
	
	@Override
//	public UserInfo createUser(UserInfo userInfo) {
	public List<UserInfo> getAllUsers() {
		
		String sql = "SELECT * FROM abhi_db.userinfo";
		
		List<UserInfo> listOfUserInfo = jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
		
		return listOfUserInfo;
	}
	
	
	@Override
	public UserInfo getUserById(Long id) {
		UserInfo queryForObject = jdbcTemplate.queryForObject("SELECT * FROM abhi_db.userinfo WHERE id = ?",
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class), id);
		
		return queryForObject;
	}


	@Override
	public UserInfo getUserByName(String username) {
		UserInfo queryForObject = jdbcTemplate.queryForObject("SELECT * FROM abhi_db.userinfo WHERE username = ?",
				new BeanPropertyRowMapper<UserInfo>(UserInfo.class), username);
		
		return queryForObject;
	}


	@Override
	public int updateUserNameById(Long id, String username) {
		
//		String sql = "UPDATE abhi_db.UserInfo SET username = ?";
//		Object[] args = {username};	
//		int update = jdbcTemplate.update(sql, args);
		
		int update = jdbcTemplate.update("UPDATE abhi_db.UserInfo SET username = ?", username);
		return update;
	}


	@Override
	public int deleteUserById(Long id) {
		int rows = jdbcTemplate.update("DELETE FROM abhi_db.userinfo WHERE id = ?", id);
		return rows;
	}


	@Override
	public int deleteAllUsers() {
		
//		Wonn't show affeted rows Number
//		int rows = jdbcTemplate.update("TRUNCATE TABLE abhi_db.userinfo");
//		System.out.println("TRUNCATE :"+rows);
//		return rows;
		
		int rows = jdbcTemplate.update("DELETE FROM abhi_db.userinfo");
		System.out.println("DELETE :"+rows);
		return rows;
	}

		
//		***************************>> Batch CURD <<**************************************
//		Insert, Update

	@Override
	public void batchInsert(List<UserInfo> list) {
		
		String sql = "INSERT INTO abhi_db.UserInfo(username, password, roles) VALUES (?, ?, ?)";

		ArrayList<Object[]> sqlArgs = new ArrayList<>();
		
		for(UserInfo tempuserInfo : list) {
			
			Object[] args = {
//					tempuserInfo.getId(),
					tempuserInfo.getUsername(),
					tempuserInfo.getPassword(),
					tempuserInfo.getRoles()};
			sqlArgs.add(args);
		}
		
		jdbcTemplate.batchUpdate(sql, sqlArgs);
		System.out.println("batchInsert() is Compleated...!");
	}


//	@Override
//	public void batchUpdatet(List<UserInfo> list, String username) {
//		
////		String sql = "INSERT INTO abhi_db.UserInfo(username, password, roles) VALUES (?, ?, ?)";
////
////		Object[] args = {userInfo.getUsername(), userInfo.getPassword(), userInfo.getRoles()};
////		
////		int update = jdbcTemplate.update(sql, args);
//	}
}













