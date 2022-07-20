package kr.pe.javaworld.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class UsersDTO {
		private String userId;
		private String userNickname;
		private String userEmail;
		private String userPW;
		private String userPhone;
		private String friendId;
}
