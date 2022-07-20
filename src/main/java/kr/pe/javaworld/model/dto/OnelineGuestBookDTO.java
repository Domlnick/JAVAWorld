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

public class OnelineGuestBookDTO {
	private int oneGBNo;
	private String userId;
	private String oneGBContent;
	private java.util.Date oneGBDAte;
}	
