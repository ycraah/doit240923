package com.example.demo;

import com.example.demo.answer.Answer;
import com.example.demo.question.Question;
import com.example.demo.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DemoApplicationTests {

  @Autowired
  private QuestionRepository questionRepository;

  @Test
  void testJpa() {
    Question q1 = new Question();
    q1.setSubject("테스트 제목");
    q1.setContent("테스트 내용");
    q1.setCreateDate(LocalDateTime.now());
    this.questionRepository.save(q1);

    Question q2 = new Question();
    q2.setSubject("테스트 제목2");
    q2.setContent("테스트 내용2");
    q2.setCreateDate(LocalDateTime.now());
    this.questionRepository.save(q2);
  }
}
