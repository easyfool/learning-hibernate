package com.wangfengbabe.learning;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by wangfeng on 31/07/2017.
 */
@Entity
public class Message {

  @Id
  @GeneratedValue
  private Long id;
  private String text;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return "Message{" +
        "id=" + id +
        ", text='" + text + '\'' +
        '}';
  }
}
