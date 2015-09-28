package sport


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MatchController {
    def scaffold = Match
}
