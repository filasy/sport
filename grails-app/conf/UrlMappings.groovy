class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

//        "/"(view:"/index")
        "/"(controller: "Match")
//        "/showResults"(controller: "Match", action: "showResults")
        "500"(view:'/error')
	}
}
