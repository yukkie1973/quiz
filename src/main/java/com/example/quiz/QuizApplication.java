package com.example.quiz;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.quiz.entity.Quiz;
import com.example.quiz.repository.QuizRepository;

@SpringBootApplication
public class QuizApplication {

	/** 起動メソッド */
	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args).getBean(QuizApplication.class).execute();
	}
	/** 注入 */
	@Autowired
	QuizRepository repository;
	/** 実行メソッド */
	private void execute() {
		// 登録処理
		//setup();
		// 全件取得
		//showList();
		// 1件取得
		showOne();
	}
	/** === クイズを2件登録します === */
	private void setup() {
		// エンティティ生成
		Quiz quiz1 = new Quiz(null, "「Spring」はフレームワークですか？", true, "登録太郎");
		// 登録実行
		quiz1 = repository.save(quiz1);
		// 登録完了
		System.out.println("登録したデータは、" + quiz1 + "です。");
		// エンティティ生成
		Quiz quiz2 = new Quiz(null, "「Spring MVC」はバッチ処理機能を提供しますか？", false, "登録太郎");
		// 登録実行
		quiz2 = repository.save(quiz2);
		// 登録完了
		System.out.println("登録したデータは、" + quiz2 + "です。");
	}

	/** === 全件取得 === */
	private void showList() {
		System.out.println("--- 全件取得開始 ---");
		// リポジトリを使用して全件取得を実施、結果を取得
		Iterable<Quiz> quizzes = repository.findAll();
		for (Quiz quiz : quizzes) {
			System.out.println(quiz);
		}
		System.out.println("--- 全件取得完了 ---");
	}

	/** === 1件取得 === */
	private void showOne() {
		System.out.println("--- 1件取得開始 ---");
		// リポジトリを使用して1件取得を実施、結果を取得（戻り値はOptional）
		Optional<Quiz> quizOpt = repository.findById(1);
		// 値存在チェック
		if (quizOpt.isPresent()) {
			System.out.println(quizOpt.get());
		} else {
			System.out.println("該当する問題が存在しません・・・");
		}
		System.out.println("--- 1件取得完了 ---");
	}
}
