package com.ycraah.doit241019;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Answer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(columnDefinition = "Text")
  private String content;

  private LocalDateTime createDate;

  @ManyToOne
  private Question question;
}
