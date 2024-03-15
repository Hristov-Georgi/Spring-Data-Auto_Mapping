package JSONProcessing.productsShopExercise.entities.user;

import jakarta.persistence.*;
import JSONProcessing.productsShopExercise.entities.product.Product;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    private int age;

    @OneToMany(targetEntity = Product.class, mappedBy = "seller")
    private List<Product> soldProducts;

    @OneToMany(targetEntity = Product.class, mappedBy = "buyer")
    private List<Product> boughtProducts;

    @ManyToMany
    private Set<User> friends;

    public User(){}

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Product> getSoldProducts() {
        return Collections.unmodifiableList(soldProducts);
    }

    public void setSoldProducts(List<Product> soldProducts) {
        this.soldProducts = soldProducts;
    }

    public List<Product> getBoughtProducts() {
        return Collections.unmodifiableList(boughtProducts);
    }

    public void setBoughtProducts(Product boughtProducts) {
        this.boughtProducts.add(boughtProducts);
    }

    public Set<User> getFriends() {
        return Collections.unmodifiableSet(friends);
    }

    public void setFriends(User friend) {
        this.friends.add(friend);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
