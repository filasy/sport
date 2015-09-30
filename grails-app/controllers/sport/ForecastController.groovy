package sport

import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

class ForecastController {

    def springSecurityService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Forecast.list(params), model:[forecastInstanceCount: Forecast.count()]
    }

    def create() {
        def forecast = new Forecast(params)
        forecast.user = springSecurityService.currentUser
        forecast.match = Match.get(params.matchID)
        respond forecast
    }

//    def create() {
//        respond new Forecast(params)
//    }

    def show(Forecast forecastInstance) {
        //forecastInstance.user = springSecurityService.currentUser
        respond forecastInstance
    }

    @Transactional
    def save(Forecast forecastInstance) {
        if (forecastInstance == null) {
            notFound()
            return
        }

        if (forecastInstance.hasErrors()) {
            respond forecastInstance.errors, view:'create'
            return
        }

        forecastInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'forecast.label', default: 'Forecast'), forecastInstance, forecastInstance.match])
                redirect forecastInstance
            }
            '*' { respond forecastInstance, [status: CREATED] }
        }
    }

    def edit(Forecast forecastInstance) {
        respond forecastInstance
    }

    @Transactional
    def update(Forecast forecastInstance) {
        if (forecastInstance == null) {
            notFound()
            return
        }

        if (forecastInstance.hasErrors()) {
            respond forecastInstance.errors, view:'edit'
            return
        }

        forecastInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'forecast.label', default: 'Forecast'), forecastInstance, forecastInstance.match])
                redirect forecastInstance
            }
            '*'{ respond forecastInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Forecast forecastInstance) {

        if (forecastInstance == null) {
            notFound()
            notFound()
            return
        }

        forecastInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'forecast.label', default: 'Forecast'), forecastInstance, forecastInstance.match])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'forecast.label', default: 'Forecast'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
