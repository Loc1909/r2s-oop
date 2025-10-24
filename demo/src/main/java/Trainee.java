public class Trainee {
    private String id;
    private String name;
    private String gender;
    private byte age;

    public Trainee(String id, String name, String gender, byte age) {
        setId(id);
        setName(name);
        setGender(gender);
        setAge(age);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public byte getAge() {
        return age;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty())
            throw new IllegalArgumentException("id cannot be null or empty");
        this.id = id.trim();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("name cannot be null or empty");
        this.name = name.trim();
    }

    public void setGender(String gender) {
        if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female"))
            throw new IllegalArgumentException("gender must be either male, female");
        this.gender = gender.toLowerCase();
    }

    public void setAge(byte age) {
        if (age < 6)
            throw new IllegalArgumentException("age cannot be less than 6");
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Gender: %s | Age: %d", id, name, gender, age);
    }
}