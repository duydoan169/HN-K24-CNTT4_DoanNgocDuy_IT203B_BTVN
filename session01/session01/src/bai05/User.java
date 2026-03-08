package bai05;

class User {
    private int age;

    public void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Tuoi khong the am");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
