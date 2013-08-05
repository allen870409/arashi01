package jp.co.cyberagent.arashi.dto;


public class UserDto {  
    private Integer id;  
    private String name;  
    private Integer age; 
    private Integer sex;
      
    public UserDto() {  
        super();  
    }  
    public Integer getId() {  
        return id;  
    }  
    public void setId(Integer id) {  
        this.id = id;  
    }  
      
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
      
    public Integer getAge() {  
        return age;  
    }  
    public void setAge(Integer age) {  
        this.age = age;  
    }  
      
    public Integer getSex() {  
        return sex;  
    }  
    public void setSex(Integer sex) {  
        this.sex = sex;  
    }  
}