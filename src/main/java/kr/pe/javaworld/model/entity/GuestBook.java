package kr.pe.javaworld.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "guest_book")
public class GuestBook {
	@Column(name = "guest_book_no")
	private @Id @GeneratedValue int guestBookNo;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users users;
	
	private String gBContent;
	private java.util.Date gBDate;

}
