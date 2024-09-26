package com.example.demo.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {
  private final QuestionRepository questionRepository;

  public List<Question> getList(){
    return questionRepository.findAll();
  }

  public Question getQuestion(Integer id){
    Optional<Question> question = questionRepository.findById(id);
    return question.get();
  }

  public void create(String subject, String content){
    Question q = new Question();
    q.setSubject(subject);
    q.setContent(content);
    q.setCreateDate(LocalDateTime.now());
    this.questionRepository.save(q);
  }
}
