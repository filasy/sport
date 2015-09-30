<%@ page import="sport.Match" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'match.label', default: 'Match')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-match" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
    </ul>
</div>

<div id="list-match" class="content scaffold-list" role="main">
    <table>
        <thead>
            <tr>
                <th><g:message code="match.label" default="Матч"/></th>
                <th><g:message code="match.score.label" default="Факт"/></th>
                <g:each in="${sport.secure.User.findAllByEnabledAndActivityChamp(true,true)}" status="i" var="userInstance">
                    <th>${userInstance.name} (${userInstance.getBall()})</th>
                </g:each>
            </tr>
        </thead>
        <tbody>
            <g:each in="${matchInstanceList}" status="i" var="matchInstance">
                <g:set var="forecast" value="${matchInstance.forecasts}"></g:set>
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td>${matchInstance}</td>
                    <td>${matchInstance?.score}</td>
                </tr>
            </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${matchInstanceCount ?: 0}"/>
    </div>
</div>

</body>
</html>