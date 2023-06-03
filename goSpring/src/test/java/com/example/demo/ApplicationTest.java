package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationTest {
	
	@Autowired
	private QuestionRepository qr;
	
	@Autowired
	private AnswerRepository ar;
	
	
	public void test1() {
		Question q = new Question();
		q.setSubject("안녕하세요 제목1");
		q.setContent("반갑습니다 게시글1");
		q.setCreateDate(LocalDateTime.now());
		qr.save(q);
		
		Question q2 = new Question();
		q2.setSubject("안녕하세요 제목1");
		q2.setContent("반갑습니다 게시글1");
		q2.setCreateDate(LocalDateTime.now());
		qr.save(q2);
	}
	
	public void test2() {
		Question q= new Question();
		List<Question> lists = qr.findBySubject("안녕하세요 제목1");
		q = lists.get(0);
		assertNotNull(q);
		
		Answer a = new Answer();
		a.setContent("스프부트는 경량 FrameWork 입니다. 또한 자주 사용하는 설정을)"
				+ "미리 셋팅할수 있고 그밖에 많은 장점들이 있습니다");
		a.setCreateDate(LocalDateTime.now());
		a.setQuestion(q);
		ar.save(a);
		
	}
	
	/**
	 * 답변에 연결된 질문 찾기
	 */
	@Test
	public void test3() {
	  Question q = new Question();
	  Optional<Question> list = qr.findById(1);
	  if(list.isPresent()) {
		  q = list.get();
	  }
	  
	  List<Answer> al = ar.findByQuestionId(q.getId());
	  
	  ar.deleteAll(al);
 
	}

}
