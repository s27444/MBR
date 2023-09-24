public class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        if (age < 0){
            throw new InvalidAgeExceptation("Wiek nie może być mniejszy niż 0");
        }
        if(age > 100){
            throw new InvalidAgeExceptation("Wiek n ie może być większy niż 100");
        }
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
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
        if (age < 0){
            throw new InvalidAgeExceptation("Wiek nie może być mniejszy niż 0");
        }
        if(age > 100){
            throw new InvalidAgeExceptation("Wiek n ie może być większy niż 100");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
