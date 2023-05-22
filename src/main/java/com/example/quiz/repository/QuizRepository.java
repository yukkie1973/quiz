package com.example.quiz.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.quiz.entity.Quiz;

/** Quizテーブル:ReporitoryInpm */
public interface QuizRepository extends CrudRepository<Quiz, Integer> {

	@Query("SELECT id FROM quiz ORDER BY RANDOM() Limit 1")
	Integer getRandomId();
}
