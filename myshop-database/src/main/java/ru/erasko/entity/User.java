package ru.erasko.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Это поле обязательное для заполнения")
    @Column(length = 32, nullable = false)
    private String name;

    @Min(value = 16, message = "Минимальное значение поля 16 лет")
    @Max(value = 110, message = "Максимальное значение поля 110 лет")
    @Column(nullable = false)
    private Integer age;

    @NotBlank(message = "Email введен не верно")
    @Column(length = 64, nullable = false)
    private String email;

    @NotBlank(message = "Это поле обязательное для заполнения")
    @Column(length = 128, nullable = false)
    private String password;

    @Transient
    private String repeatPassword;

    @OneToMany(mappedBy = "user")
    private List<Product> productList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public User() {
        System.out.println("Конструктор по умолчанию у Юзера");
    }

    public User(Long id, String name, Integer age, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.password = password;
        System.out.println("Конструктор у Юзера: " + id + "- id, " + name + " - name");
    }

    public Long getId() {
        System.out.println("getId()  у Юзера " + id);
        return id;
    }

    public void setId(Long id) {
        System.out.println("setId  у Юзера" + id);
        this.id = id;
    }

    public String getName() {
        System.out.println("getName()  у Юзера" + name);
        return name;
    }

    public void setName(String name) {
        System.out.println("setName  у Юзера" + name);
        this.name = name;
    }

    public Integer getAge() {
        System.out.println("getAge()  у Юзера" + age);
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("setAge у Юзера" + age);
        this.age = age;
    }

    public String getPassword() {
        System.out.println("getPassword() у Юзера");
        return password;
    }

    public void setPassword(String password) {
        System.out.println("setPassword  у Юзера");
        this.password = password;
    }

    public String getRepeatPassword() {
        System.out.println(" getRepeatPassword()   у Юзера");
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        System.out.println("setRepeatPassword  у Юзера");
        this.repeatPassword = repeatPassword;
    }

    public String getEmail() {
        System.out.println("getEmail()  у Юзера");
        return email;
    }

    public void setEmail(String email) {
        System.out.println("setEmail  у Юзера");
        this.email = email;
    }

    public List<Product> getProductList() {
        System.out.println("getProductList() - user" );
        return productList;
    }

    public void setProductList(List<Product> productList) {
        System.out.println("setProductList - user" );
        this.productList = productList;
    }

    public List<Role> getRoles() {
        System.out.println("getRoles() - user" + roles);
        return roles;
    }

    public void setRoles(List<Role> roles) {
        System.out.println("setRoles - user" + roles);
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

