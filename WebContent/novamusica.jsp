<!DOCTYPE html>
<jsp:useBean id="User"
	type="br.com.professorisidro.temspotify.model.User" scope="session" />
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
				<h4 class="text-center">Crie sua playlist ${User.username}</h4>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-8">
						<form role="form" action="uploadmusica" method="POST" enctype="multipart/form-data"><!-- 18:16 -->
							<div class="form-group">
								<label for="artista"> Artista </label> <input type="text"
									class="form-control" id="artista" name="txtArtista">
							</div>
							<div class="form-group">
								<label for="nomeMusica"> Nome da M&uacute;sica; </label> <input
									type="text" class="form-control" id="nomeMusica"
									name="txtNomeMusica">
							</div>
							<div class="form-group">
								<label for="album"> &Aacute;lbum </label> <input type="text"
									class="form-control" id="album" name="txtAlbum">
							</div>
							<div class="form-group">
								<label for="estilo"> Estilo </label> <select id="estilo"
									name="txtEstilo">
									<option value="1">Rock</option>
									<option value="2">Sertanejo/Moda de Viola</option>
									<option value="3">Pagode/Samba</option>
									<option value="4">Eletronico Fritando</option>
									<option value="5">Musicas da Jovem Pan</option>
									<option value="6">Outros</option>
								</select>
							</div>
							<div class="form-group">

								<label for="fileMP3"> Arquivo MP3 para Upload </label> 
								<input type="file" class="form-control-file" id="fileMP3" name="fileMP3" />
							</div>
							<button type="submit" class="btn btn-primary">Upload de
								M&uacute;sica</button>

						</form>
					</div>
					<div class="col-md-2"></div>
				</div>
			</div>
		</div>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>