package kr.pe.javaworld.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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


@Entity
@Table(name = "diary")
public class Diary {
	
	private @Id @GeneratedValue @Column(name = "diary_id") int diaryId;

	@ManyToOne
	@JoinColumn(name="user_id")
	private Users users;
	
	private String diaryTitle;
	private String diaryContent;
	private java.util.Date diaryDate;
	private String diaryImage;
	
	@OneToOne
	@JoinColumn(name="album_id")
	private Album album;

}
