package sof3.hh.bookstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "id")
    private Long categoryid;
    private String name;

    // parametrillinen konstruktori
    public Category(
        String name
    ) {
        this.name = name;
    }

    // parametritön konstruktori
    public Category() {
        this.name = null;
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category [id=" + categoryid + ", name=" + name + "]";
    }
}
