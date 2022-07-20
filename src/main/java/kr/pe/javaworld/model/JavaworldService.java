package kr.pe.javaworld.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.pe.javaworld.model.dto.UsersDTO;
import kr.pe.javaworld.model.entity.Users;

@Service
public class JavaworldService {
	
	@Autowired
	private UsersDAO usersDAO;
	
	public Users insertUsers(Users users) {
		
		usersDAO.save(users);
		
		return users;
	}

//	public boolean loginCheck(UsersDTO usersDTO, Model model) {
//		boolean result = usersDAO.loginCheck(usersDTO);
//		if(result) {
//			Users loginUser = usersDAO.viewUser(usersDTO);
//			model.addAttribute("sessionUserId", loginUser.getUserId());
//		}
//		return result;
//	}
	
	
	
	
	
	
	
	

	public String findOnlyId(String userId) {
		return usersDAO.findIdById(userId);
	}

	public String findOnlyFId(String userId) {
		return usersDAO.findIdByFId(userId);
	}
	
	public String findOnlyEmail(String userEmail) {
		return usersDAO.findEmailByEmail(userEmail);
	}
	
	public String findPwById(String userId) {
		return usersDAO.findPwById(userId);
	}
	
	public List<Users> findAllById(String userId){
		return usersDAO.findAllByUserId(userId);
	}

	public String findFIDById(String userId) {
		return usersDAO.findFIDById(userId); //tester1, tester2
	}
	
	
	
	public List<String> fndList(String userId){
		
		JSONObject jsonUserFID = new JSONObject();
		List<String> dBFndList = new ArrayList<>();
		
		String dBUserId = findOnlyId(userId); //로그인유저 아이디
		String dBUserFId = findFIDById(dBUserId); //tester1, tester2
		jsonUserFID.put("friendIds", dBUserFId); //, 구분자로 친구 아이디 String으로 반환
		
		String[] fndArr = jsonUserFID.getString("friendIds").split(", "); 
		
		for(int i=0; i< fndArr.length; i++) {
			dBFndList.add(fndArr[i]);
		}
		return dBFndList;
	}
	
	public List<String> fndNickList(String userId) {
		List<String> myFriends = new ArrayList<>();
		List<String> a = fndList(userId);
		
		for(int i=0; i< a.size(); i++) {
			myFriends.add(findNickById(a.get(i)));
		}
		
		return myFriends;
	}
	
	
	
	public String findNickById(String string) {
		return usersDAO.findNickById(string);
	}
	
	
}
