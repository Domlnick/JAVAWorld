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

public class GuestBookDTO {
	private int guestBookNo;
	private String userId;
	private String gBContent;
	private java.util.Date gBDate;

}
