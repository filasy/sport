
<%@ page import="sport.Match" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'match.label', default: 'Match')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-match" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<sec:ifAllGranted roles="ROLE_ADMIN">
					<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				</sec:ifAllGranted>
			</ul>
		</div>
		<div id="list-match" class="content scaffold-list" role="main">
			<g:form action="index" class="message">
				<g:select name="roundID"
						  from="${sport.Round.list()}"
						  optionKey="id"
						  noSelection="['':'-Все туры-']"
						  value="${round?.id}"
				/>
				<g:submitButton name="search" value="Применить"/>
			</g:form>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>

			<table>
				<thead>
				<tr>
					<th><g:message code="match.round.label" default="Тур" /></th>

					<g:sortableColumn property="startDate" title="${message(code: 'match.startDate.label', default: 'Дата')}" />

					<th><g:message code="match.label" default="Матч" /></th>

					<th><g:message code="match.score.label" default="Факт" /></th>

					<th><g:message code="match.score.create" default="Прогноз" /></th>
				</tr>
				</thead>
				<tbody>
				<g:each in="${matchInstanceList}" status="i" var="matchInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td>${fieldValue(bean: matchInstance, field: "round")}</td>

						<td>${fieldValue(bean: matchInstance, field: "startDate")}</td>

						<td><g:link action="show" id="${matchInstance.id}"> ${fieldValue(bean: matchInstance, field: "firstTeam")} - ${fieldValue(bean: matchInstance, field: "secondTeam")} </g:link></td>

						<td>${fieldValue(bean: matchInstance, field: "score")}</td>
						<td>
							<g:set var="forecast" value="${matchInstance.forecasts.find {it.user == user}}"/>
							<g:if test="${matchInstance?.round?.locked}">
								${forecast}
							</g:if>
							<g:elseif test="${forecast}">
								<g:link controller="forecast" action="edit" id="${forecast.id}" params="[matchID: matchInstance.id]"> ${forecast}</g:link>
							</g:elseif>
							<g:else>
								<g:link controller="forecast" action="create" params="[matchID: matchInstance.id]">Сделать</g:link>
							</g:else>
						</td>
					</tr>
				</g:each>
				</tbody>
			</table>

			<div class="pagination">
				<g:paginate total="${matchInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
