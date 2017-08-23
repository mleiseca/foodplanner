package com.foodplanner

class Recipe {

    String title
    String description

    static constraints = {
        title maxSize: 127

    }
}
