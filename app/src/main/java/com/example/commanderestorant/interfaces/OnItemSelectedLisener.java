package com.example.commanderestorant.interfaces;

public interface OnItemSelectedLisener {
    void onSelectedItem(int supId,String day,int position,Type type);
    enum  Type{
        main,snack,salad
    }
}
