class UrlMappings {

	static mappings = {
//        "/logout/$action?"(controller: "logout")
//        "/login/$action?"(controller: "login")
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

//        "/"(view:"/index")
        "/"(controller: "Match")
        "500"(view:'/error')
	}
}
