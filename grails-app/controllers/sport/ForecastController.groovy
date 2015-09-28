package sport

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)

@Secured(['ROLE_USER', 'ROLE_ADMIN'])
class ForecastController {
    def scaffold = Forecast
}
