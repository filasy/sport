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
        def team = new Team(name: "Амкар").save()
        team = new Team(name: "Анжи").save()
        team = new Team(name: "Арсенал").save()
        team = new Team(name: "Динамо").save()
        team = new Team(name: "Зенит").save()
        team = new Team(name: "Краснодар").save()
        team = new Team(name: "Кубань").save()
        team = new Team(name: "Локомотив").save()
        team = new Team(name: "Мордовия").save()
        team = new Team(name: "Ростов").save()
        team = new Team(name: "Рубин").save()
        team = new Team(name: "Спартак").save()
        team = new Team(name: "Терек").save()
        team = new Team(name: "Крылья Советов").save()
        team = new Team(name: "Урал").save()
        team = new Team(name: "Уфа").save()
        team = new Team(name: "ЦСКА").save()

        assert Team.count() == 17
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
        def score = new Score(firstTeam: 0, secondTeam: 0).save()
        score = new Score(firstTeam: 0, secondTeam: 1).save()
        score = new Score(firstTeam: 0, secondTeam: 2).save()
        score = new Score(firstTeam: 1, secondTeam: 0).save()
        score = new Score(firstTeam: 1, secondTeam: 1).save()
        score = new Score(firstTeam: 1, secondTeam: 2).save()
        score = new Score(firstTeam: 2, secondTeam: 0).save()
        score = new Score(firstTeam: 2, secondTeam: 1).save()
        score = new Score(firstTeam: 2, secondTeam: 2).save()
        score = new Score(firstTeam: 3, secondTeam: 0).save()
        score = new Score(firstTeam: 3, secondTeam: 1).save()
        score = new Score(firstTeam: 3, secondTeam: 2).save()
        score = new Score(firstTeam: 3, secondTeam: 3).save()

        assert Score.count() == 13
    }

    void createMatch(){
        //Тур1
        def match = new Match(startDate: new Date(2015,7,17,19,0), round:  Round.findByRoundNumber(1),
                firstTeam:  Team.findByName("Спартак"), secondTeam:  Team.findByName("Уфа"),
                score: Score.findByFirstTeamAndSecondTeam(2,2)).save()
        match = new Match(startDate: new Date(2015,7,18,18,30), round:  Round.findByRoundNumber(1),
                firstTeam:  Team.findByName("ЦСКА"), secondTeam:  Team.findByName("Рубин"),
                score: Score.findByFirstTeamAndSecondTeam(1,0)).save()
        match = new Match(startDate: new Date(2015,7,18,21,0), round:  Round.findByRoundNumber(1),
                firstTeam:  Team.findByName("Ростов"), secondTeam:  Team.findByName("Терек"),
                score: Score.findByFirstTeamAndSecondTeam(1,1)).save()
        match = new Match(startDate: new Date(2015,7,19,13,30), round:  Round.findByRoundNumber(1),
                firstTeam:  Team.findByName("Зенит"), secondTeam:  Team.findByName("Динамо"),
                score: Score.findByFirstTeamAndSecondTeam(2,1)).save()
        match = new Match(startDate: new Date(2015,7,19,18,0), round:  Round.findByRoundNumber(1),
                firstTeam:  Team.findByName("Мордовия"), secondTeam:  Team.findByName("Локомотив"),
                score: Score.findByFirstTeamAndSecondTeam(0,1)).save()
        match = new Match(startDate: new Date(2015,7,19,21,0), round:  Round.findByRoundNumber(1),
                firstTeam:  Team.findByName("Анжи"), secondTeam:  Team.findByName("Крылья Советов"),
                score: Score.findByFirstTeamAndSecondTeam(0,1)).save()
        match = new Match(startDate: new Date(2015,7,20,17,0), round:  Round.findByRoundNumber(1),
                firstTeam:  Team.findByName("Амкар"), secondTeam:  Team.findByName("Краснодар"),
                score: Score.findByFirstTeamAndSecondTeam(0,1)).save()
        match = new Match(startDate: new Date(2015,7,20,20,0), round:  Round.findByRoundNumber(1),
                firstTeam:  Team.findByName("Кубань"), secondTeam:  Team.findByName("Урал"),
                score: Score.findByFirstTeamAndSecondTeam(0,2)).save()

        //Тур2
        match = new Match(startDate: new Date(2015,7,24,19,0), round:  Round.findByRoundNumber(2),
                firstTeam:  Team.findByName("Крылья Советов"), secondTeam:  Team.findByName("ЦСКА"),
                score: Score.findByFirstTeamAndSecondTeam(0,2)).save()
        //Тур3
        match = new Match(startDate: new Date(2015,7,31,20,0), round:  Round.findByRoundNumber(3),
                firstTeam:  Team.findByName("Кубань"), secondTeam:  Team.findByName("Уфа"),
                score: Score.findByFirstTeamAndSecondTeam(1,1)).save()
        //Тур4
        match = new Match(startDate: new Date(2015,8,7,18,0), round:  Round.findByRoundNumber(4),
                firstTeam:  Team.findByName("Терек"), secondTeam:  Team.findByName("Мордовия"),
                score: Score.findByFirstTeamAndSecondTeam(0,0)).save()
        //Тур5
        match = new Match(startDate: new Date(2015,8,14,17,0), round:  Round.findByRoundNumber(5),
                firstTeam:  Team.findByName("Амкар"), secondTeam:  Team.findByName("Анжи"),
                score: Score.findByFirstTeamAndSecondTeam(1,1)).save()
        //Тур6
        match = new Match(startDate: new Date(2015,8,21,20,0), round:  Round.findByRoundNumber(6),
                firstTeam:  Team.findByName("Терек"), secondTeam:  Team.findByName("Динамо"),
                score: Score.findByFirstTeamAndSecondTeam(1,1)).save()
        //Тур7
        match = new Match(startDate: new Date(2015,8,28,17,0), round:  Round.findByRoundNumber(7),
                firstTeam:  Team.findByName("Урал"), secondTeam:  Team.findByName("Терек"),
                score: Score.findByFirstTeamAndSecondTeam(3,3)).save()
        //Тур8
        match = new Match(startDate: new Date(2015,9,12,17,0), round:  Round.findByRoundNumber(8),
                firstTeam:  Team.findByName("Амкар"), secondTeam:  Team.findByName("Кубань"),
                score: Score.findByFirstTeamAndSecondTeam(1,1)).save()
        //Тур9
        match = new Match(startDate: new Date(2015,9,18,19,0), round:  Round.findByRoundNumber(9),
                firstTeam:  Team.findByName("Ростов"), secondTeam:  Team.findByName("Анжи"),
                score: Score.findByFirstTeamAndSecondTeam(1,0)).save()
        //Ту10
        match = new Match(startDate: new Date(2015,9,26,19,0), round:  Round.findByRoundNumber(10),
                firstTeam:  Team.findByName("ЦСКА"), secondTeam:  Team.findByName("Локомотив"),
                score: Score.findByFirstTeamAndSecondTeam(1,1)).save()

        assert Match.count() == 17
    }


}