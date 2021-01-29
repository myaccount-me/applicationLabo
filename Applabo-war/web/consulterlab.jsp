<%-- 
    Document   : ajouterlab
    Created on : 16 janv. 2021, 22:08:34
    Author     : hp
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="jpa.Region"%>
<%@page import="jpa.RegionFacade"%>

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
  <h1><a href="index.jsp">Labo covid-19</a></h1>
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
  <div id="breadcrumb"> <a href="ajouterlab.jsp" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="/Applabo-war/consulterlab.jsp" class="tip-bottom">Consulter liste des Labos</a>  </div>
  <h1>Consulter labo</h1>
</div>
<div class="container-fluid">
  <div class="row-fluid">
    <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>Laboratoires</h5>
          </div>
          <div class="widget-content nopadding">
              <jsp:include page="/listelabo" />
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th>Id</th>
                  <th>Nom</th>
                  <th>E-mail</th>
                  <th>Adresse</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${labos}" var="labo">
                <tr>
                  <td><c:out value="${labo.idLabo}"/></td>
                  <td><c:out value="${labo.nom}"/></td>
                  <td><c:out value="${labo.email}"/></td>
                  <td><c:forEach items="${region}" var="rg">
                      <c:if test="${labo.idRegion==rg.idRegion}" >
                      <c:out value="${rg.nomRegion}"/>
                      </c:if>
                      </c:forEach>
                  </td>
                   <td>
                    <button class="btn btn-info btn-mini" data-toggle="modal" data-target="#edit" onclick="edit(<c:out value="${labo.idLabo}"/>,'<c:out value="${labo.nom}"/>','<c:out value="${labo.login}"/>','<c:out value="${labo.mdp}"/>','<c:out value="${labo.email}"/>','<c:out value="${labo.idRegion}"/>')">
                        <i class="icon-edit"></i></button>
                    <button class="btn btn-danger btn-mini" data-toggle="modal" data-target="#confirm" onclick="change(<c:out value="${labo.idLabo}"/>)"><i class="icon-remove"></i></button>
                  </td>
                </tr>
                </c:forEach>
              </tbody>
            </table>
            
   <!--------------------------------------- begin Modal supp--------------------------------------------------------->         
<div class="modal fade" id="confirm" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-body">
       <form action="removelabo" method="post">
        Voulez-vous vraiement supprmier le labo ?
        <input style="visibility: hidden;" name="id" id="id"  type="number">
      </div>
      <div class="modal-footer">
    <button type="submit" class="btn btn-primary">Supprimer</button>
    <button type="button" data-dismiss="modal" class="btn">Annuler</button>
    </form>
      </div>
    </div>
  </div>
</div>
<!---------------------------------------fin modal sup--------------------------------------------------------->         
<!---------------------------------------begin Modal edit--------------------------------------------------------->
  <div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Modifier Labo</h5>
      </div>
        <div style="margin-left:5px;">
     <form action="editlabo" method="post">
      <div class="modal-body">
         <div class="control-group">
            <label class="control-label">Id :</label>
            <div class="controls">
                <input type="number" name="id" id="id1"  class="span11" readonly="readonly" />
            </div>
         </div>
        
        <div class="control-group">
              <label class="control-label">Nom :</label>
              <div class="controls">
                <input name="nom" id="nom" type="text" class="span11" required/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">E-mail</label>
              <div class="controls">
                <input name="email" id="email" type="text"  class="span11"  required/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">Login:</label>
              <div class="controls">
                <input name="login" id="login" type="text" class="span11"  required/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">Mot de passe :</label>
              <div class="controls">
                <input name="mdp"  id="mdp" type="text" class="span11"  required/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">Mot de passe :</label>
              <div class="controls">
                <select>
               <option value="1">lol</option>
              <option value="2">lol2</option>
                </select>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">Region :</label>
              <div class="controls">
                  <input name="region" id="region" type="text" class="span11" required  />
              </div>
            </div>
           </div>
    <div class="modal-footer">
     <button type="submit" class="btn btn-primary">Modifier</button>
    <button type="button" data-dismiss="modal" class="btn">Annuler</button>
    </div>
              
    </form>
        </div>
      </div>

    </div>
  </div>
<!---------------------------------------fin Modal edit--------------------------------------------------------->
</div> 
 </div>
  </div>
    </div>

  </div>

</div>
<!--Footer-part-->
<div class="row-fluid">
  <div id="footer" class="span12"> 2021 &copy; Labo. Brought to you by </div>
</div>
<!--end-Footer-part--> 
<script>
    function change(id){
        document.getElementById("id").value=id;
    }
    function edit(id,nom,login,mdp,email,region){
        document.getElementById("id1").value=id;
        document.getElementById("nom").value=nom;
        document.getElementById("login").value=login;
        document.getElementById("mdp").value=mdp;
        document.getElementById("email").value=email;
        document.getElementById("region").value=region;


    }
</script>
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
