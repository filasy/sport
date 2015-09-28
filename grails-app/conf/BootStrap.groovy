import jdk.nashorn.internal.runtime.Scope
import sport.Match
import sport.Rank
import sport.Round
import sport.Score
import sport.Team
import sport.secure.*

class BootStrap {

    def init = { servletContext ->
        createUserRole()
        createTeam()
        createRankAndRound()
        createScore()
        createMatch()
    }
    def destroy = {
    }

    void createUserRole(){
        def adminRole = new Role('ROLE_ADMIN').save()
        def userRole = new Role('ROLE_USER').save()
        def testUser1 = new User('admin', 'admin').save()
        UserRole.create(testUser1, adminRole, true)
        def testUser2 = new User('pirogov', 'pirogov').save()
        UserRole.create(testUser2, userRole, true)
        assert User.count() == 2
        assert Role.count() == 2
        assert UserRole.count() == 2
    }

    void createTeam(){
        def team1 = new Team(name: "Амкар").save()
        def team2 = new Team(name: "Арсенал").save()
        def team3 = new Team(name: "Динамо").save()
        def team4 = new Team(name: "Зенит").save()
        def team5 = new Team(name: "Краснодар").save()
        def team6 = new Team(name: "Кубань").save()
        def team7 = new Team(name: "Локомотив").save()
        def team8 = new Team(name: "Мордовия").save()
        def team9 = new Team(name: "Ростов").save()
        def team10 = new Team(name: "Рубин").save()
        def team11 = new Team(name: "Спартак").save()
        def team12 = new Team(name: "Терек").save()
        def team13 = new Team(name: "Крылья Советов").save()
        def team14 = new Team(name: "Урал").save()
        def team15 = new Team(name: "Уфа").save()
        def team16 = new Team(name: "ЦСКА").save()

        assert Team.count() == 16
    }

    void createRankAndRound(){
        def rank = new Rank(name: "РФПЛ 2015-2016").save()
        def round1 = new Round(rank: rank, roundNumber:1).save();
        def round2 = new Round(rank: rank, roundNumber:2).save();
        def round3 = new Round(rank: rank, roundNumber:3).save();
        def round4 = new Round(rank: rank, roundNumber:4).save();
        def round5 = new Round(rank: rank, roundNumber:5).save();
        def round6 = new Round(rank: rank, roundNumber:6).save();
        def round7 = new Round(rank: rank, roundNumber:7).save();
        def round8 = new Round(rank: rank, roundNumber:8).save();
        def round9 = new Round(rank: rank, roundNumber:9).save();
        def round10 = new Round(rank: rank, roundNumber:10).save();
        assert Rank.count() == 1
        assert Round.count() == 10
    }

    void createScore(){
        def score1 = new Score(firstTeam: 2, secondTeam: 2).save()
        def score2 = new Score(firstTeam: 1, secondTeam: 0).save()
    }

    void createMatch(){
        def match = new Match(startDate: new Date(2015,07,17,19,0), round:  Round.findByRoundNumber(1),
                firstTeam:  Team.findByName("Спартак"), secondTeam:  Team.findByName("Уфа"),
                score: Score.findByFirstTeamAndSecondTeam(2,2)).save()
        match = new Match(startDate: new Date(2015,07,18,18,30), round:  Round.findByRoundNumber(1),
                firstTeam:  Team.findByName("ЦСКА"), secondTeam:  Team.findByName("Рубин"),
                score: Score.findByFirstTeamAndSecondTeam(1,0)).save()
    }


}
