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

public class ProfileDTO {
	private int profileId;
	private String userId;
	private String profileName;
	private String proileContent;
	private String profileImage;
	private java.util.Date profileDate;
}
