<jsp:useBean id="User"
	type="br.com.professorisidro.temspotify.model.User" scope="session" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>TemSpotfy by TemAula!</title>

<meta name="description"
	content="Source code generated using layoutit.com">
<meta name="author" content="LayoutIt!">

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<p id="cretidos" align="right">Developed by professor Isidro
					Students</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<img src="images/logo.png" class="rounded mx-auto d-block"
					width="10%">
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<h3 class="text-center">Tem Spotfy - Sua Playlist na Web!</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<h4 class="text-center">Bem Vindo!!! ${User.username}</h4>
			</div>
		</div>
		<div class="row" id="conteudo">
			<div class="col-md-2">&nbsp;</div>
			<div class="col-md-2 btnlink botao">
				<span class="text-center"> <a href="novamusica" name="/myaccount.jsp">Upload Musica</a> </span>
			</div>
			<div class="col-md-2 btnlink botao">
				<span class="text-center"> <a href="playlists">Minhas Playlists</a> </span>
			</div>
			<div class="col-md-2 btnlink botao">
				<span class="text-center"> <a href="novaplaylist">Nova Playlist</a> </span>
			</div>
			<div class="col-md-2 btnlink botao">
				<span class="text-center"> <a href="logout">Logout</a> </span>
			</div>
			<!--<div class="col-md-8">
				<ul class="nav">
					<li class="nav-item ml-md-auto"><a class="nav-link active" href="#">New PlayList</a>
					</li>
					<li class="nav-item ml-md-auto"><a class="nav-link" href="./myPlaylists">My PlayLists</a>
					</li>
					<li class="nav-item ml-md-auto"><a class="nav-link" href="#">Upload Music</a>
					</li>
				</ul>
			</div>-->
			<div class="col-md-2">&nbsp;</div>
			
		</div>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>