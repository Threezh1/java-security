package SimpleRMI_DiyStubAndSkeleton;

public class PersonServer implements Person{
    private int age;
    private String name;
    public PersonServer (String name, int age) {
        this.age = age;
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public String getName(){
        return name;
    }

    public static void main(String args []) {
        PersonServer person = new PersonServer("Richard", 34);
        Person_Skeleton skel = new Person_Skeleton(person);
        skel.run();
    }
}
