<!DOCTYPE HTML>  
<html xmlns:th="http://www.thymeleaf.org">

<head>
      <title>ActiveSocial</title>
      <meta charset="utf-8" />
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" /> 
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> 
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/"><img src="http://sgolifiles.images.s3.amazonaws.com/1520206707523-SocialMedia-300x212.png" width="25px" align="center">ActiveSocial.com</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="/profilePage">Profile</a></li>
      <li><a href="#">Page 2</a></li>
      <li><a href="#">Page 3</a></li>
    </ul>
  </div>
</nav>
<script type="text/javascript">  
    function validateForm(formObj) {  
          
        if (formObj.file.value=='') {  
            alert('Please Upload File');  
            return false;  
        }  
  
        formObj.submitButton.disabled = true;  
        formObj.submitButton.value = 'Please Wait...';  
        return true;  
  
    }  
</script> 
	<div align="center">
	<form method="POST" action="/uploadFile" enctype="multipart/form-data" onsubmit="return validateForm(this);">
    <input type="file" name="file" accept="image/*"/><br/><br/>
    <input type="submit" value="Submit" name="submitButton"/>
</form>
</div>	

</body>
</html>