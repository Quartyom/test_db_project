package com.quartyom;

class Human extends Being {
    public int is_male = 1;
    public int age = 18;

    public Human(){}
    public Human(String name, int is_alive, int is_male, int age){
        super(name, is_alive);
        this.age = age;
        this.is_male = is_male;
    }

    public int get_is_male(){ return is_male; }
    public void set_is_male(int is_male){ this.is_male = is_male;}

    public int get_age(){return age;}
    public void set_age(){this.age = age;}

    public String get_full_info(){
        String output = super.get_full_info();
        output += "Is male : " + is_male + '\n';
        output += "Age : " + age + '\n';
        return output;
    }
}