package models;

public class Person {

    protected int id;
    protected String name;
    protected int age;
    protected String gender;

    public Person(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

     public void setId(int id) {
        this.id = id;
     }
     public int getId() {
        return id;
     }


     public void setName(String name) {
         this.name = name;
     }
    public String getName() {
         return name;
     }


     public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }

  public void displayInfo() {
    System.out.println("ID: " + id);
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Gender: " + gender);

    }

}
