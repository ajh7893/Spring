<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<input class='fileInput' type='file' name='uploadFile' multiple >

<button id="uploadBtn">UPLOAD</button>
<style>
.uploadResult {
   width:100vw;
   height: 20vh;
   display: flex;
   background-color: blue;
}

.item {
   width: 150px;
   background-color: white;
}

</style>

<div class="uploadResult">


</div>

<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>


<script>
$(document).ready(function(){
	
	var fileInput = $(".fileInput");
	
	var fileInputCopy = fileInput.clone();
	
	var uploadResult = $(".uploadResult");
	
	uploadResult.on("click", ".delBtn", function() {
		//console.log(this);
		var obj = $(this);
		var targetDiv = obj.closest("div");
		console.log(obj.attr("data-file"));
		targetDiv.remove();
		
	});
	
	  
	  $("#uploadBtn").on("click", function(e){
	 
	    var formData = new FormData();
	    
	    var inputFile = $("input[name='uploadFile']");
	    
	    var files = inputFile[0].files;
	    
	    console.log(files);
	    
	   	for(var i = 0; i < files.length; i++){
		
		 formData.append("uploadFile", files[i]);
		
		}
	   	
	   	$.ajax({
	        url: '/upload/uploadAjaxAction',
	          processData: false,
	          contentType: false,
	          data: formData,
	          type: 'POST',
	          success: function(arr){
	              alert("Uploaded");
	              console.log(arr);
	              
	              var str = "";
	              for(var i= 0; i < arr.length; i++){
	            	  str += "<div class='item'><img src='/upload/display?fname="+arr[i]+"'><button class='delBtn' data-file='"+arr[i]+"'>DEL</button></div>"
	              }
	              uploadResult.append(str);
	              
	              fileInput.remove();
	              
	              $("body").append(fileInputCopy);
	              
	          }
	      }); //$.ajax

	    
	  });  
	});

</script>  
</body>
</html>