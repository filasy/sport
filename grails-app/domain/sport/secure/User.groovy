package sport.secure

import sport.Forecast
import sport.Game
import sport.Round

class User implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService

	String username
	String password
	String name
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
	boolean activityChamp = true

	User(String username, String password, String name) {
		this()
		this.username = username
		this.password = password
		this.name = name
	}

	@Override
	int hashCode() {
		username?.hashCode() ?: 0
	}

	@Override
	boolean equals(other) {
		is(other) || (other instanceof User && other.username == username)
	}

	@Override
	String toString() {
		name
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this)*.role
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true
		password blank: false
	}

	static mapping = {
		password column: '`password`'
		sort "name"
	}

	int getBall(){
		def result = 0
		Forecast.findAllByUser(this).each {
			result += it.getBall()?: 0
		}
		return result
	}

	int getBall(Round round){
		return round.getBallForUser(this)
	}
}
