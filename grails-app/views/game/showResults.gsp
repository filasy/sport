<%@ page import="sport.Game" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'game.label', default: 'Game')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-game" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
    </ul>
</div>

<div id="list-game" class="content scaffold-list" role="main">
    <g:form action="index" class="message">
        <g:select name="roundID" from="${sport.Round.list()}" optionKey="id" noSelection="['':'-Все туры-']" value="${round?.id}"/>
        <g:select name="userIDs" from="${sport.secure.User.findAllByActivityChamp(true)}" optionKey="id" noSelection="['':'-Все участники-']" value="${users?.id}"/>
        <g:submitButton name="search" value="Применить"/>
    </g:form>
    <table>
        <thead>
            <tr>
                <th><g:message code="game.label" default="Матч"/></th>
                <th><g:message code="game.score.label" default="Факт"/></th>
                <g:set var="users" value="${sport.secure.User.findAllByEnabledAndActivityChamp(true,true)}"/>
                <g:each in="${users}" status="i" var="user">
                    <th>${user.name} (${user.getBall()})</th>
                </g:each>
            </tr>
        </thead>
        <tbody>
            <g:each in="${gameInstanceList}" status="i" var="gameInstance">
                <g:set var="forecasts" value="${gameInstance.forecasts}"/>
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td>${gameInstance}</td>
                    <td>${gameInstance?.score}</td>
                    <g:each in="${users}" status="j" var="user">
                        <td>${forecasts.find {it.user.id == user.id}}</td>
                    </g:each>
                </tr>
            </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${gameInstanceCount ?: 0}"/>
    </div>
</div>

</body>
</html>