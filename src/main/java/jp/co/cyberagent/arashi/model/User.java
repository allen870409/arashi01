package jp.co.cyberagent.arashi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name = "user", catalog = "maple")  
public class User {  
    private Integer id;  
    private String name;  
    private Integer age; 
    private Integer sex;
      
    public User() {  
        super();  
    }  
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
    @Column(name = "id")  
    public Integer getId() {  
        return id;  
    }  
    public void setId(Integer id) {  
        this.id = id;  
    }  
      
    @Column(name = "name")  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
      
    @Column(name = "age")  
    public Integer getAge() {  
        return age;  
    }  
    public void setAge(Integer age) {  
        this.age = age;  
    }  
      
    @Column(name = "sex")  
    public Integer getSex() {  
        return sex;  
    }  
    public void setSex(Integer sex) {  
        this.sex = sex;  
    }  
}