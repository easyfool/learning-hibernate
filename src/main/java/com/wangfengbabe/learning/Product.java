package com.wangfengbabe.learning;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by wangfeng on 01/08/2017.
 */
@Entity
public class Product {

  @Id
  @GeneratedValue
  private Integer id;
  private String sku;
  private String name;
  @Column(name = "comment")
  private String description;

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
