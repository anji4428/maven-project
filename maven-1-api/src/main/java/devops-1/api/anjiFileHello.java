package devops-1.api;

/**
 * Sample API used by anji Component whose method signatures are read from File.
 */
public class anjiFileHello {

    public String sayHi() {
        return "Hello!";
    }

    public String greetMe(String name) {
        return "Hello " + name;
    }

    public String greetUs(String name1, String name2) {
            return "Hello " + name1 + ", " + name2;
    }
}
