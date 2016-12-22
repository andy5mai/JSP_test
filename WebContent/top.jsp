<%@ page import="com.andy.system.util.SessionObj,com.andy.system.modelObj.IRole" %>

<nav class="navbar navbar-fixed-top navbar-inverse" role=navigation>
	<div class=container>
		<div class=navbar-header>
			<button type=button class="navbar-toggle collapsed"
				data-toggle=collapse data-target=#navbar aria-expanded=false
				aria-controls=navbar>
				<span class=sr-only>Toggle navigation</span> <span class=icon-bar></span>
				<span class=icon-bar></span> <span class=icon-bar></span>
			</button>
			<a class=navbar-brand href=#>Project name</a>
		</div>

		<div id=navbar class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href=#>Home</a>
				<li><a href=#about>About</a>
				<li><a href=#contact>Contact</a>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="logout"><%= SessionObj.getRole(request.getSession()).getName() %> Log out</a>
			</ul>
		</div>
	</div>
</nav>