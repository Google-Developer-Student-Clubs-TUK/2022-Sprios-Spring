package com.sprios.sprios_spring.domain.member.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "mamber_id")
  private Long id;
}
