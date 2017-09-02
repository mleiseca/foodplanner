package com.foodplanner

import static org.springframework.http.HttpStatus.*
import grails.gorm.transactions.Transactional

@Transactional(readOnly = true)
class RecipeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Recipe.list(params), model:[recipeCount: Recipe.count()]
    }

    def show(Recipe recipe) {
        respond recipe
    }

    def create() {
        respond new Recipe(params)
    }

    @Transactional
    def save(Recipe recipe) {
        if (recipe == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (recipe.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond recipe.errors, view:'create'
            return
        }

        recipe.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'recipe.label', default: 'Recipe'), recipe.id])
                redirect recipe
            }
            '*' { respond recipe, [status: CREATED] }
        }
    }

    def edit(Recipe recipe) {
        respond recipe
    }

    @Transactional
    def update(Recipe recipe) {
        if (recipe == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (recipe.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond recipe.errors, view:'edit'
            return
        }

        recipe.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'recipe.label', default: 'Recipe'), recipe.id])
                redirect recipe
            }
            '*'{ respond recipe, [status: OK] }
        }
    }

    @Transactional
    def delete(Recipe recipe) {

        if (recipe == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        recipe.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'recipe.label', default: 'Recipe'), recipe.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'recipe.label', default: 'Recipe'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
