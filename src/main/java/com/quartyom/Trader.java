package com.quartyom;

class Trader extends Human {
    public float goods_uniqueness = 0.5f; // 0 -> 1 more unique

    public Trader(){}
    public Trader(String name, int is_alive, int is_male, int age, float goods_uniqueness){
        super(name, is_alive, is_male, age);
        set_goods_uniqueness(goods_uniqueness);
    }

    public float get_goods_uniqueness(){return goods_uniqueness;}
    public void set_goods_uniqueness(float goods_uniqueness){
        if (goods_uniqueness >= 0 && goods_uniqueness <= 1) {
            this.goods_uniqueness = goods_uniqueness;
        }
    }
    public String get_full_info(){
        String output = super.get_full_info();
        output += "Goods uniqueness : " + goods_uniqueness + '\n';
        return output;
    }
}
