package com.guilherme.vitrine.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ImageCarrocel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL -- H2  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 100, nullable = false)
  private String descricao;

  @Column(length = 254, nullable = false)
  private String enderecoImagem;
}
