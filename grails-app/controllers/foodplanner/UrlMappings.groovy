package foodplanner

class UrlMappings {

    static mappings = {
        "/admin/usdaupload" (controller: "usdaUpload", action: "index")
        "/admin/usdaupload/save" (controller: "usdaUpload", action: "save")
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
