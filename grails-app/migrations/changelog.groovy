databaseChangeLog = {

    include file: '20170821_setup.groovy'

    include file: '20170823_adding_recipes.groovy'

//    Adding creator to recipe
    include file: '20170901_recipe_creator.groovy'
}
