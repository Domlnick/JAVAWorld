package kr.pe.javaworld.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "oneline_guest_book")
public class OnelineGuestBook {
	@Column(name = "one_g_b_id")
	private @Id @GeneratedValue int oneGBId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users users;
	
	private String oneGBContent;
	private java.util.Date oneGBDAte;
}	
