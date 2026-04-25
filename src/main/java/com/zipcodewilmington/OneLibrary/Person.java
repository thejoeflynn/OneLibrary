package com.zipcodewilmington.OneLibrary;

public abstract class Person {
    
        private String name;
        private int age;
        private String email;
        private String phoneNumber;

        public Person(String name, int age, String email, String phoneNumber) {
            this.name = name;
            this.age = age;
            this.email = email;
            this.phoneNumber = phoneNumber;
        }
    
    //Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }

    // Setters if needed
    public void setName(String name) {
        this.name = name;
        if (name != null && !name.isEmpty()){
            this.name = name;
        } else {
            System.out.println("Invalid name");}
        }
    public void setAge(int age) { 
        this.age = age;
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age");}
        }
    public void setEmail(String email) { this.email = email;
        this.email = email;
        if (email != null && !email.isEmpty()){
            this.email = email;
        } else {
            System.out.println("Invalid email");}
        }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber;
        this.phoneNumber = phoneNumber;
        if (phoneNumber != null && !phoneNumber.isEmpty()){
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Invalid phone number");}
        }

    @Override
    public String toString() {
    return name + ", age " + age + ", " + email + ", " + phoneNumber;
}

}
