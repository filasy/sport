
<%@ page import="sport.Game" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'game.label', default: 'Game')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-game" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
					<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<sec id="show-game" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list game">

				<g:if test="${gameInstance?.round}">
					<li class="fieldcontain">
						<span id="round-label" class="property-label"><g:message code="game.round.label" default="Round" /></span>

						<span class="property-value" aria-labelledby="round-label"><g:link controller="round" action="show" id="${gameInstance?.round?.id}">${gameInstance?.round?.encodeAsHTML()}</g:link></span>

					</li>
				</g:if>

				<g:if test="${gameInstance?.startDate}">
				<li class="fieldcontain">
					<span id="startDate-label" class="property-label"><g:message code="game.startDate.label" default="Start Date" /></span>
					
						<span class="property-value" aria-labelledby="startDate-label"><g:formatDate formatName="default.date.format" date="${gameInstance?.startDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${gameInstance?.firstTeam}">
				<li class="fieldcontain">
					<span id="firstTeam-label" class="property-label"><g:message code="game.firstTeam.label" default="First Team" /></span>
					
						<span class="property-value" aria-labelledby="firstTeam-label"><g:link controller="team" action="show" id="${gameInstance?.firstTeam?.id}">${gameInstance?.firstTeam?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${gameInstance?.secondTeam}">
				<li class="fieldcontain">
					<span id="secondTeam-label" class="property-label"><g:message code="game.secondTeam.label" default="Second Team" /></span>
					
						<span class="property-value" aria-labelledby="secondTeam-label"><g:link controller="team" action="show" id="${gameInstance?.secondTeam?.id}">${gameInstance?.secondTeam?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${gameInstance?.score}">
				<li class="fieldcontain">
					<span id="score-label" class="property-label"><g:message code="game.score.label" default="Score" /></span>
					
						<span class="property-value" aria-labelledby="score-label"><g:link controller="score" action="show" id="${gameInstance?.score?.id}">${gameInstance?.score?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
				<g:form url="[resource:gameInstance, action:'delete']" method="DELETE">
					<fieldset class="buttons">
						<g:link class="edit" action="edit" resource="${gameInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
						<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					</fieldset>
				</g:form>
		</div>
	</body>
</html>
