package com.quartyom;

import java.util.Random;

class Being {
    public int is_alive = 1;
    public String name = "Unnamed";

    public Being(){}
    public Being(String name, int is_alive){
        this.name = name;
        this.is_alive = is_alive;
    }

    public int get_is_alive(){ return is_alive; }
    public void set_is_alive(int is_alive){ this.is_alive = is_alive;}

    public String get_name(){return name;}
    public void set_name(){this.name = name;}

    public String get_full_info(){
        String output = "";
        output += "Name : " + name + '\n';
        output += "Is alive : " + is_alive + '\n';
        return output;
    }
}