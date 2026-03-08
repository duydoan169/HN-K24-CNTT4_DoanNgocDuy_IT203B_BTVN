package bai06;

class User {
    private String name;
    private int age;

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Tuoi khong the am");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
