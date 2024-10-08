package com.example.demo.answer;

import com.example.demo.question.Question;
import com.example.demo.question.QuestionService;
import com.example.demo.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {
  private final AnswerRespository answerRespository;

  public void create(Question question, String content, SiteUser author) {
    Answer answer = new Answer();
    answer.setQuestion(question);
    answer.setContent(content);
    answer.setCreateDate(LocalDateTime.now());
    answer.setAuthor(author);
    answerRespository.save(answer);
  }
}
