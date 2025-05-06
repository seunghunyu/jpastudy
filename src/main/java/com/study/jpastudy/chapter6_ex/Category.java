package com.study.jpastudy.chapter6_ex;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "CATEGORY")
public class Category {

    @Id
    @Column(name = "CATEGORY_ID")
    @GeneratedValue
    private Long id;

    @Column(name = "CATEGORY_NAME")
    private String name;

    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM", joinColumns = @JoinColumn(name = "CATEGORY_ID"),
                inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
    private List<Item> items = new ArrayList<>();

    //카테고리의 계층 구조를 위한 필드들
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> item) {
        this.items = item;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Category> getChild() {
        return child;
    }

    public void setChild(List<Category> child) {
        this.child = child;
    }

    //연관 관계 메소드
    public void addChildCategory(Category child){
        this.child.add(child);
        child.setParent(this);
    }
    public void addItem(Item item){
        items.add(item);
    }
}
