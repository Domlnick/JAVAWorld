package kr.pe.javaworld.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

@Entity
@Table(name="users")
public class Users {
	
	
	private @Id @Column(name = "user_id") String userId;
	private String userNickname;
	private @Column(unique = true) String userEmail;
	private String userPW;
	private String userPhone;
	private String friendId;
	
	@OneToMany(mappedBy = "users")
	private List<Users> users = new ArrayList<>();
	
	
}
