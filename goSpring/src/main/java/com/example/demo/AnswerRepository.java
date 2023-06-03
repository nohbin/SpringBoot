package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
	
	List<Answer> findById(int id);
	List<Answer> findByQuestionId(int id);
}