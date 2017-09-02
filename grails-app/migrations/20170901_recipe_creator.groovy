databaseChangeLog = {

    changeSet(author: "mleiseca (generated)", id: "1504321681858-1") {
        addColumn(tableName: "recipe") {
            column(name: "creator_id", type: "int8") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "mleiseca (generated)", id: "1504321681858-2") {
        addForeignKeyConstraint(baseColumnNames: "creator_id", baseTableName: "recipe", constraintName: "FKdjl8vi14rc9cim9m616l380gr", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "users")
    }
}
