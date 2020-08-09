<!DOCTYPE html>
<jsp:useBean id="erroSTR" type="java.lang.String" scope="request"/>
<html>
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
				<h4 class="text-center" id="h4error">ERRO: ${erroSTR}</h4>
			</div>
		</div>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>