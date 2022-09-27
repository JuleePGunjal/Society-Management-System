package com.iacsd.entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="noticeboard")
public class NoticeBoard {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
	private int id;
@Column(name="noticeDate",insertable = false ,updatable = false)
//@Temporal(TemporalType.TIMESTAMP)
private LocalDateTime noticeDate  ;

@Column(name="noticemsg ")
	private String noticemsg ;
@JsonIgnore
@ManyToOne
@JoinColumn(name="ownerId")
private Owner owner;



public NoticeBoard() {
	super();
}

public NoticeBoard(int id, LocalDateTime noticeDate, String noticemsg) {
	super();
	this.id = id;
	this.noticeDate = noticeDate;
	this.noticemsg = noticemsg;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public LocalDateTime getNoticeDate() {
	return noticeDate;
}



public void setNoticeDate(LocalDateTime noticeDate) {
	this.noticeDate = noticeDate;
}

public String getNoticemsg() {
	return noticemsg;
}

public void setNoticemsg(String noticemsg) {
	this.noticemsg = noticemsg;
}

public Owner getOwner() {
	return owner;
}

public void setOwner(Owner owner) {
	this.owner = owner;
}

@Override
public String toString() {
	return "NoticeBoard [id=" + id + ", noticeDate=" + noticeDate + ", noticemsg=" + noticemsg + ", owner=" + owner
			+ "]";
}


}
