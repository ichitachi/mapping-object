package com.teikaiz.example;

import com.teikaiz.mapping.DataMapping;

public class Runner {

    public static void main(String [] args)  {
        Cat cat = new Cat();
        cat.setName("snoop");
        cat.setColor("black");
        cat.setBell("Meow Meow");
        CatDTO catDT = new CatDTO();
        DataMapping.mapping(cat, catDT);
        System.out.println(cat.toString());
        System.out.println(catDT.toString());
    }
}
