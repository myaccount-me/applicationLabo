<%-- 
    Document   : consulterslt
    Created on : 18 janv. 2021, 00:14:54
    Author     : asus
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <c:if test="${sessionScope.id==null}">
     <c:redirect url="/login.jsp" ></c:redirect>
    </c:if>
<head>
<title>Laboratoire</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/uniform.css" />
<link rel="stylesheet" href="css/select2.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<link rel="stylesheet" href="css/matrix-media.css" />
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>

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
        <li><a href="consultelistepatient.jsp">Ajouter Résultat</a></li>
        <li class="active"><a href="consultelistepatient.jsp">Consulter Résultat</a></li>
        <li ><a href="consultelistepatient.jsp">Modifier Patient</a></li>
        <li><a href="consultelistepatient.jsp">Supprimer Patient</a></li>

      </ul></li>
    
  </ul>
</div>

<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Liste résultats</a> </div>
    <h1>Liste des Résultats du Client </h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
         
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>Liste des Résultats</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Etat</th>
                  <th>Date</th>
                  <th>Actions</th>
                  
                </tr>
              </thead>
              <tbody>
                  <%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
                  <sql:setDataSource var="connexionBdDIssatIntranet"
                    driver="com.mysql.jdbc.Driver"
                    url="jdbc:mysql://localhost:3306/gestionlabo"
                    user="root" password="root"/>
                 <sql:query dataSource="${connexionBdDIssatIntranet}" var="result"> SELECT * from resultat where id_patient = <%=request.getParameter("id")%>;
                </sql:query>
                <c:forEach items="${result.rows}" var="rslt">
                <tr class="gradeX">
                   <td class="center"><c:out value="${rslt.id_resultat}" /></td>
                  <td class="center"><c:out value="${rslt.etat}" /></td>
                   <td class="center"><c:out value="${rslt.date}" /></td>
                   <td class="taskOptions"> 
                    <button class="sTrash" onclick="supprimer('${rslt.id_resultat}','${rslt.id_patient}')" data-target="#myAlert" data-toggle="modal" title="Supprimer"><i class="icon-trash"></i></button></td>
                </tr>
              <div id="myAlert" class="modal hide">
                 <form method="post" action="consulterslt" >
              <div class="modal-header">
                <button data-dismiss="modal" class="close" type="button">×</button>
                <h3>Confirmation de Suppression</h3>
              </div>
              <div class="modal-body">
                <p>Voulez vous supprimer ce resultat?</p>
                <input type="hidden" name="id" id="id" />
                <input type="hidden" name="idpat" id="idpat" />
              </div>
              <div class="modal-footer"> <input  class="btn btn-primary"value="Supprimer" type="submit"> <a data-dismiss="modal" class="btn" href="#">Annuler</a> </div>
                  </form>
              </div>
            </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!--Footer-part-->
<div class="row-fluid">
  <div id="footer" class="span12"> 2021 &copy; Labo. Brought to you by  </div>
</div>
<!--end-Footer-part-->
<script type="text/javascript">
   function supprimer(id , idpat){
       document.getElementById("id").value=id;
       document.getElementById("idpat").value=idpat;
       
   }
   </script>
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
