package kr.pe.javaworld.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.pe.javaworld.model.JavaworldService;
import kr.pe.javaworld.model.entity.Users;

@RestController
@ComponentScan(basePackages = {"kr.pe.javaworld.model"})
@SessionAttributes({"sessionUserId"})
public class Controller {
	
	@Autowired
	private JavaworldService javaworldService;
	
	//로그인
	@PostMapping("/login")
	public ModelAndView loginReq(Model model, @RequestParam String userId, @RequestParam String userPw, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView();
		Cookie userCookie = new Cookie("userId", null);
		
		
		String dBUserId = javaworldService.findOnlyId(userId);
		String dBUserPw = javaworldService.findPwById(dBUserId);
		
		if(userId.equals(dBUserId)&&userPw.equals(dBUserPw)) {
			System.out.println(userId + "  =  " + dBUserId + " 존재하는 아이디!");
			System.out.println(userPw + "  =  " + dBUserPw + " 해당아이디의 비밀번호 일치!");
			
			List<Users> loginUser = javaworldService.findAllById(userId);
			
			userCookie.setMaxAge(60*60*2);
			userCookie.setValue(dBUserId);
			response.addCookie(userCookie);
			
			model.addAttribute("sessionUserId", userId);
			System.out.println("session Id : " + model.getAttribute("sessionUserId"));
			
			mv.addObject("friendsId", javaworldService.fndNickList(userId));
			mv.addObject("jsonUserFId", javaworldService.fndList(userId));
			mv.addObject("users", loginUser);
			mv.setViewName("javaHomepage");
			
			return mv;
			
		}else if(!userId.equals(dBUserId)) {
			mv.addObject("msg", "없는 아이디입니다.\n회원가입 하시겠습니까?");
			mv.setViewName("loginFail");
			
			return mv;
		}else {
			mv.addObject("msg", "비밀번호가 틀렸습니다.\n다시 입력해주세요.");
			mv.setViewName("loginFail");
			
			return mv;
		}
	}
	
	//회원가입
	@PostMapping("/signUp")
	public ModelAndView signUpReq(@ModelAttribute Users users ,@RequestParam String userId, @RequestParam String nickname, 
							@RequestParam String userEmail, @RequestParam String userPw, 
							@RequestParam String userRePw, @RequestParam String phoneNo) {
		
		ModelAndView mv = new ModelAndView();
		
		String dBUserId = javaworldService.findOnlyId(userId);
		String dBUserEmail = javaworldService.findOnlyEmail(userEmail);
		
		if(!userId.equals(dBUserId)&&!userEmail.equals(dBUserEmail)) {
			
			if(userPw.equals(userRePw)) {
				System.out.println("++++++++++" + userPw + "  =  " + userRePw + " 일치하네요!");
				
				Users userSet = Users.builder().userId(userId)
						.userNickname(nickname)
						.userEmail(userEmail)
						.userPW(userPw)
						.userPhone(phoneNo).build();
				
				javaworldService.insertUsers(userSet);
				
				mv.addObject("msg", "회원가입을 축하드립니다.");
				mv.setViewName("signUpSuccess");
				
				return mv;
				
			}else {
				System.out.println(userPw + "  =  " + userRePw + " 일치하지 않습니다!");
				mv.addObject("msg", "비밀번호가 서로 일치 하지 않습니다.\n확인 부탁드립니다.");
				mv.setViewName("signUpFail");
				
				return mv;
				
			}
		}else if(userId.equals(dBUserId)){
			System.out.println("에러 : " + userId + " = " + dBUserId + " 일치 " );
			mv.addObject("msg", "이미 존재하는 아이디 입니다.\n확인 부탁드립니다.");
			mv.setViewName("signUpFail");
			
			return mv;
			
		}else {
			System.out.println("에러 : " + userEmail + " = " + dBUserEmail + " 일치 " );
			mv.addObject("msg", "이미 존재하는 이메일입니다.\n확인 부탁드립니다.");
			mv.setViewName("signUpFail");
			
			return mv;
			
		}
	}
}
