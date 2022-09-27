
package com.iacsd.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iacsd.dtos.NoticeBoardDTO;
import com.iacsd.dtos.Response;
import com.iacsd.dtos.TenantDTO;
import com.iacsd.dtos.VehicleDTO;
import com.iacsd.entities.NoticeBoard;
import com.iacsd.entities.Tenant;
import com.iacsd.services.NoticeBoardServiceImpl;
@CrossOrigin
@RestController
public class NoticeBoardControllerImpl {

	@Autowired
	private NoticeBoardServiceImpl noticeBoardService;
	
	@Autowired
	private NoticeBoardDTO noticeDto;

	@GetMapping("/noticeBoard/noticeBoardlist")
	public ResponseEntity<?> getAllNotice()
	{
		List<NoticeBoard> noticeList = noticeBoardService.findAllNoticeBoard();
		List<NoticeBoardDTO> noticedtoList = new ArrayList();
		for(NoticeBoard notice : noticeList) {
			noticedtoList.add(noticeDto.toNoticeDto(notice));
		}
		return Response.success(noticedtoList);
	}

	@PostMapping("/noticeBoard/addnoticeBoard")
	public ResponseEntity<?> addNotice(@RequestBody NoticeBoardDTO noticeBoardDto){
		NoticeBoard result=noticeBoardService.saveNotice(noticeBoardDto);
		return Response.success(result);
		
	}

	@PutMapping("/noticeBoard/updatenotice/{id}")

	public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody NoticeBoardDTO noticeBoardDto)
	{
	    NoticeBoardDTO result = noticeBoardService.changeNotice(id, noticeBoardDto);
		return Response.success(result);
	}
	

	@DeleteMapping("/noticeBoard/deletebyid/{id}")
	public ResponseEntity<?> deleteNoticeBoardById(@PathVariable("id") int id) {
		Map<String, Object> result = noticeBoardService.deleteNoticeBoard(id);
		return Response.success(result);
	}
	
	}