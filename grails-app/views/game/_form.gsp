<%@ page import="sport.Game" %>



<div class="fieldcontain ${hasErrors(bean: gameInstance, field: 'startDate', 'error')} required">
	<label for="startDate">
		<g:message code="game.startDate.label" default="Start Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="startDate" precision="minute"  value="${gameInstance?.startDate}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: gameInstance, field: 'round', 'error')} required">
	<label for="round">
		<g:message code="game.round.label" default="Round" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="round" name="round.id" from="${sport.Round.list()}" optionKey="id" required="" value="${gameInstance?.round?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: gameInstance, field: 'firstTeam', 'error')} required">
	<label for="firstTeam">
		<g:message code="game.firstTeam.label" default="First Team" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="firstTeam" name="firstTeam.id" from="${sport.Team.list()}" optionKey="id" required="" value="${gameInstance?.firstTeam?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: gameInstance, field: 'secondTeam', 'error')} required">
	<label for="secondTeam">
		<g:message code="game.secondTeam.label" default="Second Team" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="secondTeam" name="secondTeam.id" from="${sport.Team.list()}" optionKey="id" required="" value="${gameInstance?.secondTeam?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: gameInstance, field: 'score', 'error')} ">
	<label for="score">
		<g:message code="game.score.label" default="Score" />
		
	</label>
	<g:select id="score" name="score.id" from="${sport.Score.list()}" optionKey="id" value="${gameInstance?.score?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

