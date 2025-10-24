public class PersonTest {
    private void displayPerson(Person person) {
        System.out.println("Name: " + person.getName());
        System.out.println("Gender: " + person.getGender());
        System.out.println("Age: " + person.getAge());
    }
    public static void main(String[] args) {
        Person person1 = new Person("Lộc", "Male", 21);
        PersonTest personTest = new PersonTest();
        personTest.displayPerson(person1);

        person1.updateAge(10);
        System.out.println("Thông tin đã cập nhật: ");
        personTest.displayPerson(person1);
    }
}
