package com.example.commanderestorant.interfaces;

public interface OnItemClicked<T> {
    void onClick(T data, boolean isAdd);
}
