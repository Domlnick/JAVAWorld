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


public class DiaryDTO {
	private int diaryId;
	private String userId;
	private String diaryTitle;
	private String diaryContent;
	private java.util.Date diaryDate;
	private String diaryImage;
}
