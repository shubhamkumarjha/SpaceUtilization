<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Space Utilization System</title>
<script src="../js/prototype.js"></script>
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
					var div = document.querySelector("#inner");
					frag = document.createDocumentFragment();
					select = document.createElement("select");
					var url = "../addDetailsServlet?navAction=getEmployee";
					var myAjax = new Ajax.Request(url, {
						method : 'post',
						onSuccess : function updateCols() {
							alert("It's Completed")
						}
					});
					frag.appendChild(select);
					div.appendChild(frag);
				} catch (e) {
					alert(e.message);
				}
				break;

			case 4:
				break;
			}

		}
	</script>
	<div class="container">
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
			<div id="pageinnercontent"></div>	
		</div>
		
		<div class="pagefooter">Copyright &copy SUS 2018</div>
	</div>
</body>
</html>