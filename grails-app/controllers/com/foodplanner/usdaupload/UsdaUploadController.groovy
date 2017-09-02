package com.foodplanner.usdaupload

import grails.plugin.springsecurity.annotation.Secured

// https://www.ars.usda.gov/northeast-area/beltsville-md/beltsville-human-nutrition-research-center/nutrient-data-laboratory/
class UsdaUploadController {

    @Secured(value=["hasRole('ROLE_ADMIN')"])
    def index() {
        log.error "Upload index"
        render view: "/usdaUploadController/index.gsp"
    }

    @Secured(value=["hasRole('ROLE_ADMIN')"])
    def save() {
        log.error "Doing upload save"
        redirect controller: "usdaUpload", action: "index"
    }
}
