package sport
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TeamController {
    def scaffold = Team
}
