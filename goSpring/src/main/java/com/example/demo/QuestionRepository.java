package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

	List<Question> findBySubject(String str);
	List<Question> findBySubjectAndContent(String subject , String content); // AND
	List<Question> findBySubjectLike(String str); // LIKE
	List<Question> deleteByid(int id);
	
}
