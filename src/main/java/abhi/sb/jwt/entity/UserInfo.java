package abhi.sb.jwt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserInfo {

	private Long id;
	private String username;
	private String password;
	private String roles;
}


//	id, username, password, roles