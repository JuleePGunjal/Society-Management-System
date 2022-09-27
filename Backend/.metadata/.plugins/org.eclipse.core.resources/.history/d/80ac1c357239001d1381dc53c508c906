package com.iacsd.dtos;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.iacsd.entities.NoticeBoard;
import com.iacsd.entities.Owner;

@Component
public class NoticeBoardDTO {
	private int id;
	private String noticemsg;
	private LocalDateTime noticeDate;
	private int ownerId;
	
	public NoticeBoardDTO() {
		super();
	}


	public NoticeBoardDTO(int id, String noticemsg) {
		super();
		this.id = id;
		this.noticemsg = noticemsg;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	

	


	public int getOwnerId() {
		return ownerId;
	}


	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
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
	public NoticeBoardDTO toNoticeDto(NoticeBoard entity) {
		NoticeBoardDTO dto = new NoticeBoardDTO();
		dto.setId(entity.getId());
		dto.setNoticemsg(entity.getNoticemsg());
		dto.setNoticeDate(entity.getNoticeDate());
		return dto;
	}
	
	public NoticeBoard toNoticeEntity(NoticeBoardDTO dto, Owner owner) {
		NoticeBoard entity = new NoticeBoard();
		entity.setId(dto.getId());
		entity.setNoticemsg(dto.getNoticemsg());
		entity.setOwner(owner);
		return entity;		
	}

	@Override
	public String toString() {
		return "NoticeBoardDTO [id=" + id + ", noticemsg=" + noticemsg + "]";
	}
	
	

}
