package jpabook.start;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBER") //class와 table의 이름이 같기때문에 생략가능
public class Member {

    @Id
    @Column(name="ID")
    private String id;
    @Column(name="NAME")//table과 value와 이름이 다르기 때문에 생략하면 안됨
    private String username;
    @Column(name="age")
    private Integer age; //Integer에는 int와 다르게 null값을 넣을 수 있음

    public void setId(String id){this.id = id;}
    public void setUsername(String name){username = name;}
    public void setAge(Integer age){this.age = age;}

    public String getId(){return id;}
    public String getUsername(){return username;}
    public Integer getAge(){return age;}

}
