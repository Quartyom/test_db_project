package com.quartyom;

class Doctor extends Human {
    public int experience_in_years = 2;

    public Doctor(){}
    public Doctor(String name, int is_alive, int is_male, int age, int experience_in_years){
        super(name, is_alive, is_male, age);
        this.experience_in_years = experience_in_years;
    }

    public int get_experience_in_years(){return experience_in_years;}
    public void set_experience_in_years(int experience_in_years){this.experience_in_years = experience_in_years;}

    public String get_full_info(){
        String output = super.get_full_info();
        output += "Experience in years : " + experience_in_years + '\n';
        return output;
    }
}