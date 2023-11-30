package com.guilherme.vitrine.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Newsletter {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL -- H2  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(length = 200, nullable = false)
  private String nome;

  @Column(length = 200, nullable = false, unique = true)
  private String email;
}
