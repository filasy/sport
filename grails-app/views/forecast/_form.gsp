<%@ page import="sport.Forecast" %>



<div class="fieldcontain ${hasErrors(bean: forecastInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="forecast.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${sport.secure.User.list()}" optionKey="id" required="" value="${forecastInstance?.user?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: forecastInstance, field: 'match', 'error')} required">
	<label for="match">
		<g:message code="forecast.match.label" default="Match" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="match" name="match.id" from="${sport.Match.list()}" optionKey="id" required="" value="${forecastInstance?.match?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: forecastInstance, field: 'score', 'error')} required">
	<label for="score">
		<g:message code="forecast.score.label" default="Score" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="score" name="score.id" from="${sport.Score.list()}" optionKey="id" required="" value="${forecastInstance?.score?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: forecastInstance, field: 'locked', 'error')} ">
	<label for="locked">
		<g:message code="forecast.locked.label" default="Locked" />

	</label>
	<g:checkBox readonly="true" name="locked" value="${forecastInstance?.locked}" />

</div>

