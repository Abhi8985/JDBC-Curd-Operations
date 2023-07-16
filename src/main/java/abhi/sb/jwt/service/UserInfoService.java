package abhi.sb.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abhi.sb.jwt.dao.UserInfoDao;
import abhi.sb.jwt.entity.UserInfo;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoDao uDao;
	

	public String greatMethod() {
		return uDao.greatings();
	}
	
	public int saveMethod(UserInfo userInfo){
		return uDao.createUser(userInfo);
	}
	
	public List<UserInfo> getAllUsersMethod(){
		return uDao.getAllUsers();
	}

	public UserInfo getUserByIdMethod(Long id) {
		return uDao.getUserById(id);
	}

	public UserInfo getUserByNameMethod(String username) {
		return uDao.getUserByName(username);
	}

	public int updateUserNameByIdMethod( Long id, String username) {
		return uDao.updateUserNameById(id, username);
	}

	public int deleteUserByIdMethod(Long id) {
		return uDao.deleteUserById(id);
	}

	public int deleteAllUsersMethod() {
		return uDao.deleteAllUsers();
	}

	
//	***************************>> Batch CURD <<**************************************
//	Insert, Update

	public void batchInsertMethod(List<UserInfo> list) {
		uDao.batchInsert(list);
	}

//	public void batchUpdateMethod(List<UserInfo> list) {
//		uDao.batchUpdatet(list);
//	}
}
