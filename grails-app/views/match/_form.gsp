<%@ page import="sport.Match" %>



<div class="fieldcontain ${hasErrors(bean: matchInstance, field: 'startDate', 'error')} required">
	<label for="startDate">
		<g:message code="match.startDate.label" default="Start Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="startDate" precision="day"  value="${matchInstance?.startDate}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: matchInstance, field: 'round', 'error')} required">
	<label for="round">
		<g:message code="match.round.label" default="Round" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="round" name="round.id" from="${sport.Round.list()}" optionKey="id" required="" value="${matchInstance?.round?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: matchInstance, field: 'firstTeam', 'error')} required">
	<label for="firstTeam">
		<g:message code="match.firstTeam.label" default="First Team" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="firstTeam" name="firstTeam.id" from="${sport.Team.list()}" optionKey="id" required="" value="${matchInstance?.firstTeam?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: matchInstance, field: 'secondTeam', 'error')} required">
	<label for="secondTeam">
		<g:message code="match.secondTeam.label" default="Second Team" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="secondTeam" name="secondTeam.id" from="${sport.Team.list()}" optionKey="id" required="" value="${matchInstance?.secondTeam?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: matchInstance, field: 'score', 'error')} ">
	<label for="score">
		<g:message code="match.score.label" default="Score" />
		
	</label>
	<g:select id="score" name="score.id" from="${sport.Score.list()}" optionKey="id" value="${matchInstance?.score?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

