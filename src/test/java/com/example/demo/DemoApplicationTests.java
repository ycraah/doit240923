package com.example.demo;

import com.example.demo.answer.Answer;
import com.example.demo.question.Question;
import com.example.demo.question.QuestionRepository;
import com.example.demo.question.QuestionService;
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
  private QuestionService questionService;

  @Test
  void testJpa() {
   for(int i = 1; i <= 300; i++){
     String subject = String.format("테스터 데이터입니다:[%03d]", i);
     String content = "내용 없음 ";
     this.questionService.create(subject, content);
   }
  }
}
