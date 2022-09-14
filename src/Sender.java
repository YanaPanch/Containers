public class Sender {
    private String name;
    private String surname;
    private String personalIdNumber;


    public Sender(String name, String surname, String personalIdNumber) {
        this.name = name;
        this.surname = surname;
        this.personalIdNumber = personalIdNumber;
    }

    public String getPersonalIdNumber() {
        return personalIdNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Surname: " + surname + ", Personal Id number: " + personalIdNumber;
    }
}
