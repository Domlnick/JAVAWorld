package kr.pe.javaworld.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kr.pe.javaworld.model.dto.UsersDTO;
import kr.pe.javaworld.model.entity.Users;

public interface UsersDAO extends JpaRepository<Users, String>{
	
	
//	public boolean loginCheck(UsersDTO usersDTO);
	
//	public Users viewUser(UsersDTO usersDTO);
	
	
	
	
	@Query(value ="select user_id from users where user_id = ?1", nativeQuery = true)
	String findIdById(@Param("user_id") String userId);

	@Query(value ="select user_id from users where user_id = ?1", nativeQuery = true)
	String findIdByFId(@Param("user_id") String userId);
	
	@Query(value ="select user_email from users where user_email = ?1", nativeQuery = true)
	String findEmailByEmail(@Param("user_email") String userEmail);
	
	@Query(value = "select userpw from users where user_id = ?1", nativeQuery = true)
	String findPwById(@Param("user_id") String userId);

	List<Users> findAllByUserId(String userId);
	
	@Query(value = "select friend_id from users where user_id = ?1", nativeQuery = true)
	String findFIDById(@Param("user_id") String userId);
	
	@Query(value = "select user_nickname from users where user_id = ?1", nativeQuery = true)
	String findNickById(@Param("user_id") String string);
	
	
	
}
