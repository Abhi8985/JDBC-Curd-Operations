package abhi.sb.jwt.dao;

import java.util.List;

import abhi.sb.jwt.entity.UserInfo;

public interface UserInfoDao {

	public String greatings();
	
//	public UserInfo createUser(UserInfo userInfo);
	public int createUser(UserInfo userInfo);
	
	public List<UserInfo> getAllUsers();
	
	public UserInfo getUserById(Long id);

	public UserInfo getUserByName(String username);

	public int updateUserNameById(Long id, String username);

	public int deleteUserById(Long id);

	public int deleteAllUsers();

	
	
	
//	***************************>> Batch CURD <<**************************************
//	Insert, Update

	public void batchInsert(List<UserInfo> list);

//	public void batchUpdatet(List<UserInfo> list, String username);
}
