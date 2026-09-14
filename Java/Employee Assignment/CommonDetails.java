class CommonDetails {
    String name, address, gender;
    int age;
    float basicSalary;

    public CommonDetails() {
        System.out.println("Enter Details: ");
        this.name = ConsoleInput.getString();
        this.address = ConsoleInput.getString();
        this.age = ConsoleInput.getInteger();
        this.gender = ConsoleInput.getString();
        this.basicSalary = ConsoleInput.getFloat();
    }
    
}