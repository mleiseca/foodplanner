package com.foodplanner

class Ingredient {

    String name

    static constraints = {
        name maxSize: 63
    }
}
