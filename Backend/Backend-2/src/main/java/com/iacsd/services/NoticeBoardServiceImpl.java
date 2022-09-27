package com.iacsd.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacsd.daos.NoticeBoardDao;
import com.iacsd.daos.OwnerDao;
import com.iacsd.dtos.NoticeBoardDTO;
import com.iacsd.dtos.VehicleDTO;
import com.iacsd.entities.NoticeBoard;
import com.iacsd.entities.Vehicle;

@Transactional
@Service


public class NoticeBoardServiceImpl {

	@Autowired
	private NoticeBoardDao noticeBoardDao;
	
	@Autowired
	private OwnerDao ownerDao;
	
	@Autowired
	private NoticeBoardDTO noticeBoardDto;
	
	public List<NoticeBoard> findAllNoticeBoard()
	{
		return  noticeBoardDao.findAll();
		
	}
	
	public NoticeBoard saveNotice(NoticeBoardDTO noticeBoard) {
		return noticeBoardDao.save(noticeBoardDto.toNoticeEntity(noticeBoard, ownerDao.findById(noticeBoard.getOwnerId())));
	}
	
	public NoticeBoardDTO changeNotice(int id , NoticeBoardDTO noticeBoardDto) {
		NoticeBoard noticeBoard= noticeBoardDao.findById(id);
		noticeBoard.setNoticemsg(noticeBoardDto.getNoticemsg());
		return noticeBoardDto;
		
	}
	
	
	public Map<String, Object> deleteNoticeBoard(int id) {
		if(noticeBoardDao.existsById(id)) {
			noticeBoardDao.deleteById(id);
			return Collections.singletonMap("affectedRows", 1);
		}
		return Collections.singletonMap("affectedRows", 0);
	} 
}