package abhi.sb.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import abhi.sb.jwt.entity.UserInfo;
import abhi.sb.jwt.service.UserInfoService;

@RestController
@RequestMapping("/home")
public class HomeControllers {

	@Autowired
	private UserInfoService uservice;
	
	@GetMapping("/great")
	public String greatApi() {
		return uservice.greatMethod();
	}
	
	@PostMapping("/save-user")
	public String saveApi(@RequestBody UserInfo userInfo) {
		 int rows = uservice.saveMethod(userInfo);
		 return "No Rows Saved In the DB are :"+rows;
	}
	
	@GetMapping("/all-users")
	public List<UserInfo> getAllUsersApi() {
		return uservice.getAllUsersMethod();
	}
	
	@GetMapping("/user-id/{id}")
	public UserInfo getUserByIdApi(@PathVariable Long id) {
		return uservice.getUserByIdMethod(id);
	}
	
	@GetMapping("/user-name/{username}")
	public UserInfo getUserByIdApi(@PathVariable String username) {
		return uservice.getUserByNameMethod(username);
	}
	
	
	@PutMapping("/user-update-id-name/{id}/{username}")
	public String updateUserNameByIdApi(@PathVariable Long id, @PathVariable String username) {
		int updateUserNameById = uservice.updateUserNameByIdMethod(id, username);
		System.out.println("updateUserNameById"+ updateUserNameById);
		return "No Of Rows Updated :"+updateUserNameById;
	}
	
	
	@DeleteMapping("/delete-user-id/{id}")
	public String deleteUserByIdApi(@PathVariable Long id) {
		int deleteUserById = uservice.deleteUserByIdMethod(id);
		return "No Of Rows Deleted :"+deleteUserById;
	}
	
	
	@DeleteMapping("/delete-all-users")
	public String deleteAllUsersApi() {
		int deleteAllUsers = uservice.deleteAllUsersMethod();
		return "No Of Rows Deleted :"+deleteAllUsers;
	}
	
	
//	***************************>> Batch CURD <<**************************************
//	Insert, Update

	@PostMapping("/batch-insert")
	public String batchInsertApi(@RequestBody List<UserInfo> list) {
		uservice.batchInsertMethod(list);
		return "Batch Insert Api Compleated...!";
	}
//	
//	@PostMapping("/batch-update")
//	public String batchUpdateApi(List<UserInfo> list) {
//		uservice.batchUpdateMethod(list);
//		return "Batch Update Api Compleated...!";
//	}
}








