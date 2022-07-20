package kr.pe.javaworld.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.pe.javaworld.model.entity.Users;

public class ControllerCodeBackUp {
/*
@GetMapping("/login")
	public ModelAndView loginReq(Model model, Users users, @RequestParam String userId, @RequestParam String userPw) {
		ModelAndView mv = new ModelAndView();
		
		String dBUserId = javaworldService.findOnlyId(userId);
		String dBUserPw = javaworldService.findPwById(dBUserId);
		
		if(userId.equals(dBUserId)&&userPw.equals(dBUserPw)) {
			System.out.println(userId + "  =  " + dBUserId + " 존재하는 아이디!");
			System.out.println(userPw + "  =  " + dBUserPw + " 해당아이디의 비밀번호 일치!");
			
			List<Users> loginUser = javaworldService.findAllById(userId);
			
			mv.addObject("users", loginUser);
			mv.setViewName("redirect:/javaHomepage.html");
			
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
 
 
 
 */
}
