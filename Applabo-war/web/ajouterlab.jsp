<%-- 
    Document   : ajouterlab
    Created on : 16 janv. 2021, 22:08:34
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <c:if test="${sessionScope.idA==null}">
     <c:redirect url="/loginadmin.jsp" ></c:redirect>
    </c:if>
<head>
<title>Labo</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/colorpicker.css" />
<link rel="stylesheet" href="css/datepicker.css" />
<link rel="stylesheet" href="css/uniform.css" />
<link rel="stylesheet" href="css/select2.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<link rel="stylesheet" href="css/matrix-media.css" />
<link rel="stylesheet" href="css/bootstrap-wysihtml5.css" />
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body >

<!--Header-part-->
<div id="header">
  <h1><a href="index.jsp">Labo</a></h1>
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
    <li class=""><a title="" href="/Applabo-war/connexionAdmin"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
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
    <li class="submenu active"> <a href="#"><i class="icon icon-list"></i> <span>Laboratoire</span></a>
      <ul>
        <li><a href="ajouterlab.jsp">Ajouter labo</a></li>
        <li><a href="consulterlab.jsp">Consulter liste des labos</a></li>
      </ul>
    </li>
  </ul>
</div>

<!--close-left-menu-stats-sidebar-->

<div id="content">
<div id="content-header">
  <div id="breadcrumb"> <a href="ajouterlab.jsp" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="/Applabo-war/ajouterlab.jsp" class="tip-bottom">Ajouter Labo</a>  </div>
  <h1>Ajouter laboratoire</h1>
</div>

<div class="container-fluid">
  <div class="row-fluid">
    <div class="span12">
      <div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>Labo information</h5>
        </div>
        <div class="widget-content nopadding">
         <form action="addlabo" method="post" class="form-horizontal">
            <div class="control-group">
              <label class="control-label">Nom :</label>
              <div class="controls">
                <input name="nom" type="text" class="span11" placeholder="Nom" required/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">E-mail</label>
              <div class="controls">
                <input name="email" type="text"  class="span11" placeholder="E-mail" required />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">Login:</label>
              <div class="controls">
                <input name="login"  type="text" class="span11" placeholder="Login" required/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">Mot de passe :</label>
              <div class="controls">
                <input name="mdp" type="password" class="span11" placeholder="Mot de passe" required/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">Region :</label>
              <div class="controls">
            <jsp:include page="/addlabo" />
              <select name="region">
              <c:forEach items="${regions}" var="region">
               <option value="<c:out value="${region.idRegion}"/>"><c:out value="${region.nomRegion}"/></option>
              </c:forEach>
                </select>
                  
              </div>
            </div>
            <div style="margin-left: 200px;">
            <div class="form-actions">
              <button type="submit" class="btn btn-success">Save</button>
            </div>
            </div>
          </form>
        </div>
      </div>

    </div>

  </div>

</div></div>
<!--Footer-part-->
<div class="row-fluid">
  <div id="footer" class="span12"> 2021 &copy; labo. Brought to you by </div>
</div>
<!--end-Footer-part--> 
<script src="js/jquery.min.js"></script> 
<script src="js/jquery.ui.custom.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/bootstrap-colorpicker.js"></script> 
<script src="js/bootstrap-datepicker.js"></script> 
<script src="js/jquery.toggle.buttons.js"></script> 
<script src="js/masked.js"></script> 
<script src="js/jquery.uniform.js"></script> 
<script src="js/select2.min.js"></script> 
<script src="js/matrix.js"></script> 
<script src="js/matrix.form_common.js"></script> 
<script src="js/wysihtml5-0.3.0.js"></script> 
<script src="js/jquery.peity.min.js"></script> 
<script src="js/bootstrap-wysihtml5.js"></script> 
<script>
	$('.textarea_editor').wysihtml5();
</script>
</body>
</html>
