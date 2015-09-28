package sport

import grails.transaction.Transactional

@Transactional(readOnly = true)
class ForecastController {
    def scaffold = Forecast
}
