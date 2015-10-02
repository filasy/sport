
<%@ page import="sport.Game" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'game.label', default: 'Game')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-game" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="list" action="showResults"><g:message code="default.common_table.label"/></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-game" class="content scaffold-list" role="main">
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
					<th><g:message code="game.round.label" default="Тур" /></th>

					<g:sortableColumn property="startDate" title="${message(code: 'game.startDate.label', default: 'Дата')}" />

					<th><g:message code="game.label" default="Матч" /></th>

					<th><g:message code="game.score.label" default="Факт" /></th>

					<th><g:message code="game.forecast" default="Прогноз" /></th>

					<th><g:message code="game.ball" default="Балл" />
					<g:if test="${round}">
						(${round?.getBallForUser(user)})
					</g:if>
					<g:else>
						(${user?.getBall()})
					</g:else>
					</th>
				</tr>
				</thead>
				<tbody>
				<g:each in="${gameInstanceList}" status="i" var="gameInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td>${fieldValue(bean: gameInstance, field: "round")}</td>

						<td><g:formatDate formatName="default.date.format" date="${gameInstance?.startDate}"/>

						<td><g:link action="show" id="${gameInstance.id}"> ${fieldValue(bean: gameInstance, field: "firstTeam")} - ${fieldValue(bean: gameInstance, field: "secondTeam")} </g:link></td>

						<td>${fieldValue(bean: gameInstance, field: "score")}</td>
						<td>
							<g:set var="forecast" value="${gameInstance.forecasts.find {it.user == user}}"/>
							<g:if test="${gameInstance?.round?.locked}">
								${forecast}
							</g:if>
							<g:elseif test="${forecast}">
								%{--<p>--}%
									%{--Случайное число:--}%
									%{--<input type="text" name="rnd" id="out" value="" readonly="true" />--}%
									%{--<g:remoteLink action="random"--}%
												  %{--params="[max:100]"--}%
												  %{--onSuccess="\$('#out').val(data.rnd);"--}%
									%{-->Генерировать!</g:remoteLink>--}%
								%{--</p>--}%
								<g:link controller="forecast" action="edit" id="${forecast.id}" params="[gameID: gameInstance.id]"> ${forecast}</g:link>
							</g:elseif>
							<g:else>
								<g:link controller="forecast" action="create" params="[gameID: gameInstance.id]">Сделать</g:link>
							</g:else>
						</td>
						<td>
							<g:if test="${forecast}">
								${forecast?.getBall()}
							</g:if>
							<g:else>
								0
							</g:else>
						</td>
					</tr>
				</g:each>
				</tbody>
			</table>

			<div class="pagination">
				<g:paginate total="${gameInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
