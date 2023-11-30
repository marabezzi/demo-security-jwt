package com.guilherme.vitrine.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contact {
  private String contactEmail;
  private String contactName;
  private String contactPhone;
  private String contactCell;
  private String contactMotive;
  private String contactMessage;
}
