databaseChangeLog = {

    changeSet(author: "mleiseca (generated)", id: "1503513115982-1") {
        createSequence(sequenceName: "Ingredient_SEQ")
    }

    changeSet(author: "mleiseca (generated)", id: "1503513115982-2") {
        createSequence(sequenceName: "Recipe_SEQ")
    }

    changeSet(author: "mleiseca (generated)", id: "1503513115982-3") {
        createTable(tableName: "ingredient") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "ingredientPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(63)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "mleiseca (generated)", id: "1503513115982-4") {
        createTable(tableName: "recipe") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "recipePK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "title", type: "VARCHAR(127)") {
                constraints(nullable: "false")
            }

            column(name: "description", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "mleiseca (generated)", id: "1503513115982-5") {
        createTable(tableName: "recipe_ingredient") {
            column(name: "ingredient_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "recipe_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "amount", type: "VARCHAR(63)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "mleiseca (generated)", id: "1503513115982-6") {
        addPrimaryKey(columnNames: "ingredient_id, recipe_id", constraintName: "recipe_ingredientPK", tableName: "recipe_ingredient")
    }

    changeSet(author: "mleiseca (generated)", id: "1503513115982-7") {
        addForeignKeyConstraint(baseColumnNames: "ingredient_id", baseTableName: "recipe_ingredient", constraintName: "FK9b3oxoskt0chwqxge0cnlkc29", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "ingredient")
    }

    changeSet(author: "mleiseca (generated)", id: "1503513115982-8") {
        addForeignKeyConstraint(baseColumnNames: "recipe_id", baseTableName: "recipe_ingredient", constraintName: "FKgu1oxq7mbcgkx5dah6o8geirh", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "recipe")
    }
}
