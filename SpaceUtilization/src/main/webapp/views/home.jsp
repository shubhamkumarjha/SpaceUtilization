<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Space Utilization System</title>
<script src="../js/prototype.js"></script>
<script src="../js/jquery.js"></script>
<link rel="stylesheet" href="../css/home.css">
</head>
<body>

	<script type="text/javascript">
		function popupDiv(data) {
			switch (data) {
			case 1:
				break;

			case 2:
				break;

			case 3:
				try {
					debugger;
					document.getElementById("pageinnercontent").style.visibility = "visible";
					document.getElementById("populateMenu").style.visibility = "visible";
					var url = "../addDetailsServlet?navAction=getEmployee";
					var str="";
					var myAjax = new Ajax.Request(url, {
						method : 'post',
						onSuccess : function (response) {
							//alert(response.responseText);
							var res=response.responseText;
							var str=res.split(",");
							for(var i=0;i<str.length;i++){
								var temp=str[i];
								var s=temp.split(":");
								myHash[s[0]]=s[1];
							}
							console.log(myHash);
							myHashAppend();
						}
					});  
				} catch (e) {
					alert(e.message);
				}
				break;

			case 4:
				break;
			}

		}
		function myHashAppend(){
			debugger;
			for (var i in myHash) {
	            $('#myDropdown').append(myHash[i]);
	            console.log(myHash[i]);
			}  
		}
		function myFunction() {
			debugger;
		    document.getElementById("myDropdown").classList.toggle("show");
		}
		
		var myHash = {};
	</script>
		<div class="pageheader">
			<h3>Space Utilization System</h3>
		</div>
		<div class="pagecontainer">
			<nav class="navmenu">
				<ul>
					<li><a href="#EnterTheDetails" onclick="popupDiv(1)">Enter
							the Details</a></li>
					<li><a href="#checkVacantSpace" onclick="popupDiv(2)">Check
							Vacant Space</a></li>
					<li><a href="#allocateSpace" onclick="popupDiv(3)">Allocate
							Space</a></li>
					<li><a href="#meetingRoom" onclick="popupDiv(4)">Meeting
							Room</a></li>
				</ul>
			</nav>
			
    	

			<div id="pageinnercontent" class="hidden">
			<div class="dropdown">
				<button id="populateMenu" onclick="myFunction()" class="dropbtn">Dropdown</button>
				<div id="myDropdown" class="dropdown-content">
				</div>
			</div>
		</div> 
		<div class="pagefooter">Copyright &copy SUS 2018</div>
	</div>
</body>
</html>