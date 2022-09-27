package com.iacsd.daos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iacsd.entities.NoticeBoard;


public interface NoticeBoardDao extends JpaRepository<NoticeBoard, Integer> {

	NoticeBoard findById(int id);
	List<NoticeBoard> findAll();
}