
<%@ page import="sport.Match" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'match.label', default: 'Match')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-match" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-match" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list match">
			
				<g:if test="${matchInstance?.startDate}">
				<li class="fieldcontain">
					<span id="startDate-label" class="property-label"><g:message code="match.startDate.label" default="Start Date" /></span>
					
						<span class="property-value" aria-labelledby="startDate-label"><g:formatDate date="${matchInstance?.startDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${matchInstance?.round}">
				<li class="fieldcontain">
					<span id="round-label" class="property-label"><g:message code="match.round.label" default="Round" /></span>
					
						<span class="property-value" aria-labelledby="round-label"><g:link controller="round" action="show" id="${matchInstance?.round?.id}">${matchInstance?.round?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${matchInstance?.firstTeam}">
				<li class="fieldcontain">
					<span id="firstTeam-label" class="property-label"><g:message code="match.firstTeam.label" default="First Team" /></span>
					
						<span class="property-value" aria-labelledby="firstTeam-label"><g:link controller="team" action="show" id="${matchInstance?.firstTeam?.id}">${matchInstance?.firstTeam?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${matchInstance?.secondTeam}">
				<li class="fieldcontain">
					<span id="secondTeam-label" class="property-label"><g:message code="match.secondTeam.label" default="Second Team" /></span>
					
						<span class="property-value" aria-labelledby="secondTeam-label"><g:link controller="team" action="show" id="${matchInstance?.secondTeam?.id}">${matchInstance?.secondTeam?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${matchInstance?.score}">
				<li class="fieldcontain">
					<span id="score-label" class="property-label"><g:message code="match.score.label" default="Score" /></span>
					
						<span class="property-value" aria-labelledby="score-label"><g:link controller="score" action="show" id="${matchInstance?.score?.id}">${matchInstance?.score?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:matchInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${matchInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
