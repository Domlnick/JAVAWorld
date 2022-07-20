package kr.pe.javaworld.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
public class Album {
	@Id
	@GeneratedValue
	@Column(name="album_id")
	int album_id;
	
	@OneToOne
	@JoinColumn(name = "profile_id")
	private Profile profile;
	
	@OneToOne
	@JoinColumn(name = "diary_id")
	private Diary diary;
	
}
