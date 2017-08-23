package com.foodplanner

class RecipeIngredient implements Serializable{

    private static final long serialVersionUID = 1

    Ingredient ingredient
    Recipe recipe

    // TODO: Should have some better concept of amount here
    String amount

    static constraints = {
        amount maxSize: 63
        ingredient nullable: false
        recipe nullable: false
    }

    static mapping = {
        id composite: ['ingredient', 'recipe']
    }
}
