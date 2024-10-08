package com.example.demo.question;

import com.example.demo.user.SiteUser;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {
  private final QuestionRepository questionRepository;

  public Page<Question> getList(int page){
    List<Sort.Order> sorts = new ArrayList<>();
    sorts.add(Sort.Order.desc("createDate"));
    Pageable pageable = (Pageable) PageRequest.of(page, 10, Sort.by(sorts));
    return this.questionRepository.findAll(pageable);
  }

  public Question getQuestion(Integer id){
    Optional<Question> question = questionRepository.findById(id);
    return question.get();
  }

  public void create(String subject, String content, SiteUser user){
    Question q = new Question();
    q.setSubject(subject);
    q.setContent(content);
    q.setCreateDate(LocalDateTime.now());
    q.setAuthor(user);
    this.questionRepository.save(q);
  }
}
