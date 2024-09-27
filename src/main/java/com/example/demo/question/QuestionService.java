package com.example.demo.question;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {
  private final QuestionRepository questionRepository;

  public Page<Question> getList(int page){
    Pageable pageable = (Pageable) PageRequest.of(page, 10);
    return this.questionRepository.findAll(pageable);
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
