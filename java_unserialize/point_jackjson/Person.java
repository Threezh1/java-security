package point_jackjson;

public class Person {
    private String name;
    private Integer age;
    private Object cls;

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Object getCls() {
        return cls;
    }

    public void setCls(Object cls) {
        this.cls = cls;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public void setName(String name) {
        this.name = name;
    }
}
