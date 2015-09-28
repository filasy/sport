package sport

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)

@Secured('ROLE_USER')
class ForecastController {
    def scaffold = Forecast
}
