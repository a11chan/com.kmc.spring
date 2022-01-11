package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
//import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j // Logger 객체(log.xxx)를 생성
public class BoardServiceTests {

	@Setter(onMethod_ = { @Autowired })
	private BoardService service;

	public void testExist() { // BoardServcie 객체 주입 여부 확인
		log.info(service);
		assertNotNull(service);
	}

	public void testRegister() { // 등록 작업 테스트: 생성된 게시물 번호 확인
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");

		service.register(board);

		log.info("생성된 게시물의 번호: " + board.getBno());
		// BoardServiceImpl 클래스에서 mapper.insertSelectKey() 정의필
	}
	
	public void testGetList() { // 목록 작업 테스트
		service.getList().forEach(board -> log.info(board));
	}

//   public void testGetList( ) { // 목록 작업 테스트
//      // service.getList().forEach(board -> log.info(board));
//      service.getList(new Criteria(2, 10)).forEach(board -> log.info(board));
//   }
	
	public void testGet() { // 조회작업 테스트
		log.info(service.get(2L));
	}

	public void testDelete() { // 게시물이 존재할 때 true 반환
		// 게시물 번호의 존재 여부를 확인하고 테스트할 것
		log.info("REMOVE RESULT: " + service.remove(2L));
	}
	
	@Test
	public void testUpdate() { // 수정 작업 테스트: 특정 게시물을 먼저 조회하고, title 값을 수정한 후 업데이트
		BoardVO board = service.get(4L);

		if (board == null) {
			return;
		}

		board.setTitle("제목 수정합니다.");
		log.info("MODIFY RESULT: " + service.modify(board));
	}

}