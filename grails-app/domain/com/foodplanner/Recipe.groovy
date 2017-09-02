package com.foodplanner

class Recipe {

    String title
    String description

    static belongsTo = [creator: User]

    static constraints = {
        title maxSize: 127

    }
}
