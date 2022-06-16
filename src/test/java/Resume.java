package hh;
public class Resume {
    private String gender;
    private String city;
    private int age;
    boolean ready_to_relocate;
    boolean logo;
    private String email;
    private String metro;

    //далее создаем конструктор alt+insert -> Constructor и выбираем все переменные
    public Resume(String gender, String city, int age, boolean ready_to_relocate, boolean logo, String email, String metro) {
        this.gender = gender;
        this.city = city;
        this.age = age;
        this.ready_to_relocate = ready_to_relocate;
        this.logo = logo;
        this.email = email;
        this.metro = metro;
    }
 // создаем гетеры (alt+insert -> getter
    public String getEmail() {return email;}

    public String getMetro() {return metro;}

    public String getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public boolean isReady_to_relocate() {
        return ready_to_relocate;
    }

    public boolean isLogo() {
        return logo;
    }

}
