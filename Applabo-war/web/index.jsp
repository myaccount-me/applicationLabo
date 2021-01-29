<%-- 
    Document   : index
    Created on : 18 janv. 2021, 19:56:52
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:if test="${sessionScope.id==null}">
     <c:redirect url="/loginadmin.jsp" ></c:redirect>
    </c:if>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Laboratoire</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/fullcalendar.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<link rel="stylesheet" href="css/matrix-media.css" />
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" href="css/jquery.gritter.css" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>
       <!--Header-part-->
<div id="header">
  <h1><a href="index.jsp">Matrix Admin</a></h1>
</div>
<!--close-Header-part--> 

<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav">
    <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i>  <span class="text">Welcome User</span><b class="caret"></b></a>
      <ul class="dropdown-menu">
        <li><a href="#"><i class="icon-user"></i> My Profile</a></li>
      </ul>
    </li>
    <li class=""><a title="" href="/Applabo-war/connexionlabo"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
  </ul>
</div>

<!--start-top-serch-->
<div id="search">
  <input type="text" placeholder="Search here..."/>
  <button type="submit" class="tip-bottom" title="Search"><i class="icon-search icon-white"></i></button>
</div>
<!--close-top-serch--> 
<!--sidebar-menu-->
<div id="sidebar"> <a href="#" class="visible-phone"><i class="icon icon-list"></i></a>
  <ul>
     <li><a href="index.jsp"><i class="icon icon-home"></i> <span>Accueil</span></a> </li>
    <li> <a href="ajoutpat.jsp"><i class="icon icon-signal"></i> <span>Ajouter Patient</span></a> </li>
    <li class="submenu"> <a href="consultelistepatient.jsp"><i class="icon icon-list"></i><span>Consulter liste Patient</span></a>
    <ul>
        <li ><a href="consultelistepatient.jsp">Modifier Patient</a></li>
        <li><a href="consultelistepatient.jsp">Supprimer Patient</a></li>
        <li><a href="consultelistepatient.jsp">Ajouter Résultat</a></li>
        <li class="active"><a href="consultelistepatient.jsp">Consulter Résultat</a></li>
      </ul></li>
    
  </ul>
</div>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
  </div>
    <div class="container-fluid">
    <hr>
    <div class="row-fluid">
        
    </div>
    </div>
    <!--Footer-part-->
<div class="row-fluid">
  <div id="footer" class="span12"> 2021 &copy; Labo. Brought to you by  </div>
</div>
<!--end-Footer-part-->
<script src="js/jquery.min.js"></script> 
<script src="js/jquery.ui.custom.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/jquery.uniform.js"></script> 
<script src="js/select2.min.js"></script> 
<script src="js/jquery.dataTables.min.js"></script> 
<script src="js/matrix.js"></script> 
<script src="js/matrix.tables.js"></script>
</body>
</html>
