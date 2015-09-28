import sport.secure.*

class BootStrap {

    def init = { servletContext ->
        createUserRole()
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
}
