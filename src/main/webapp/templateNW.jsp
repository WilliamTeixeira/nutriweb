
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
﻿<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="utf-8">
        <title>NutriWeb - Nutrição Profissional</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">      
        <meta name="author" content="Html5TemplatesDreamweaver.com">
        <META NAME="ROBOTS" CONTENT="NOINDEX, NOFOLLOW"> <!-- Remove this Robots Meta Tag, to allow indexing of site -->

        <!--<link rel="stylesheet" href="styles/jquery.modal.css" type="text/css" media="screen" />-->

        <link href="scripts/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="scripts/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">


        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

        <!-- Icons -->
        <link href="scripts/icons/general/stylesheets/general_foundicons.css" media="screen" rel="stylesheet" type="text/css" />  
        <link href="scripts/icons/social/stylesheets/social_foundicons.css" media="screen" rel="stylesheet" type="text/css" />
        <!--[if lt IE 8]>
            <link href="scripts/icons/general/stylesheets/general_foundicons_ie7.css" media="screen" rel="stylesheet" type="text/css" />
            <link href="scripts/icons/social/stylesheets/social_foundicons_ie7.css" media="screen" rel="stylesheet" type="text/css" />
        <![endif]-->
        <link rel="stylesheet" href="scripts/fontawesome/css/font-awesome.min.css">
        <!--[if IE 7]>
            <link rel="stylesheet" href="scripts/fontawesome/css/font-awesome-ie7.min.css">
        <![endif]-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css">

        <link href="scripts/carousel/style.css" rel="stylesheet" type="text/css" />
        <link href="scripts/camera/css/camera.css" rel="stylesheet" type="text/css" />  
        
        <!--//dataPicker-->
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

        <link href="http://fonts.googleapis.com/css?family=Allura" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Aldrich" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Palatino+Linotype" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Calligraffitti" rel="stylesheet" type="text/css">

        <link href="styles/custom.css" rel="stylesheet" type="text/css" />


        <script src="scripts/jquery.min.js" type="text/javascript"></script> 
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script src="scripts/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="scripts/jquery.modal.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="scripts/default.js" type="text/javascript"></script> 
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

    </head>
    <body id="pageBody">

        <div id="decorative2">
            <div class="container">

                <div class="divPanel topArea notop nobottom">
                    <div class="row-fluid">
                        <div class="span12">

                            <div id="divLogo" class="pull-left">
                                <a href="nw" id="divSiteTitle">NutriWeb</a><br />
                                <a href="nw" id="divTagLine">nutrição profissional</a>
                            </div>

                            <div id="divMenuRight" class="pull-right">
                                <div class="navbar">
                                    <button type="button" class="btn btn-navbar-highlight btn-large btn-primary" data-toggle="collapse" data-target=".nav-collapse">
                                        NAVIGATION <span class="icon-chevron-down icon-white"></span>
                                    </button>
                                    <div class="nav-collapse collapse">
                                        <ul class="nav nav-pills ddmenu">
                                            <li class="dropdown ${requestScope.page==null?'active':''}"><a href="nw">Home ${requestScope.ac}</a></li>
                                                <c:if test="${logado==null}">
                                                <li class="dropdown ${requestScope.page=='cadastro'?'active':''}"><a href="nw?ac=cadastro">Cadastro</a></li>
                                                </c:if>
                                            <li class="dropdown ${requestScope.page=='ajuda'?'active':''}"><a href="nw?ac=about">Ajuda</a></li>
                                                <c:if test="${logado=='1'}">
                                                <li class="dropdown ${requestScope.page=='logout'?'active':''}"><a href="nw?ac=logout">Sair</a></li>
                                                </c:if>

                                        </ul>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

            </div>
        </div>

        <c:if test="${erroMessage!= null && erroMessage.size()>0}" >  
            <div class="sidebox" style="margin: 5px 80px 5px 80px">
                <blockquote>
                    <c:forEach items="${erroMessage}" var="st" >
                        <h3 class="text-success"><small>${st}</small></h3>
                            </c:forEach>
                </blockquote>

            </div>
        </c:if> 


        <%
            String pg = (request.getAttribute("page") != null) ? (String) request.getAttribute("page") : ((request.getParameter("page") != null) ? request.getParameter("page") : "");

            if (pg.equals("")) {
                pg = "home";
            }

            String logado = (String) session.getAttribute("logado");
            if (logado == null) {
                File f = new File(getServletContext().getRealPath("/") + "/assert/free/" + pg + ".jsp");
                pg = "/assert/free/" + pg + ".jsp";
                if (f.exists()) {
        %><jsp:include page="<%=pg%>" /><%
            } else {
                out.print("<h1>Página não encontrada!!!</h1>");
            }
        } else {
            File f = new File(getServletContext().getRealPath("/") + "/assert/sec/" + pg + ".jsp");
            pg = "/assert/sec/" + pg + ".jsp";
            if (f.exists()) {
        %><jsp:include page="<%=pg%>" /><%
                } else {
                    out.print("<h1>Página não encontrada!!!</h1>");
                }
            }


        %>



        <div id="footerOuterSeparator"></div>

        <div id="divFooter" class="footerArea">

            <div class="container">

                <div class="divPanel">

                    <div class="row-fluid">
                        <div class="span3" id="footerArea1">

                            <h3>Empresa</h3>

                            <p>NutriWeb 15 anos trabalhando com nutrição professional.</p>

                            <p> 
                                <a href="#" class="lnk" title="Terms of Use">Termos de Use</a><br />
                                <a href="#" class="lnk" title="Privacy Policy">Politica de Privacidade</a><br />
                                <a href="#" class="lnk" title="FAQ">FAQ</a><br />
                                <a href="#" class="lnk" title="Sitemap">Mapa do Site</a>
                            </p>

                        </div>
                        <div class="span3" id="footerArea2">

                            <p class="copyright">
                                Copyright © 2013 Your Company. All Rights Reserved.
                            </p>

                        </div>
                        <div class="span3" id="footerArea3">
                            <p class="social_bookmarks">
                                <a href="#" class="lnk"><i class="social foundicon-facebook"></i> Facebook</a>
                                <a href="#" class="lnk"><i class="social foundicon-twitter"></i> Twitter</a>
                                <a href="#" class="lnk"><i class="social foundicon-pinterest"></i> Pinterest</a>
                                <a href="#" class="lnk"><i class="social foundicon-rss"></i> Rss</a>
                            </p>

                        </div>
                        <div class="span3" id="footerArea4">

                            <h3>Informações</h3>  

                            <ul id="contact-info">
                                <li>                                    
                                    <i class="general foundicon-phone icon"></i>
                                    <span class="field">Telefone:</span>
                                    <br />
                                    (32) 1234 7070 / 4321 7070                                                                      
                                </li>
                                <li>
                                    <i class="general foundicon-mail icon"></i>
                                    <span class="field">Email:</span>
                                    <br />
                                    <a href="" class="lnk" title="Email">info@nutriweb.com</a>
                                </li>
                                <li>
                                    <i class="general foundicon-home icon" style="margin-bottom:50px"></i>
                                    <span class="field">Endereço:</span>
                                    <br />
                                    Rua xpto, 70<br />
                                    12345 Juiz de Fora, MG<br />
                                    Brasil
                                </li>
                            </ul>

                        </div>
                    </div>
                </div>

            </div>

        </div>

        <script src="scripts/carousel/jquery.carouFredSel-6.2.0-packed.js" type="text/javascript"></script><script type="text/javascript">$('#list_photos').carouFredSel({responsive: true, width: '100%', scroll: 2, items: {width: 320, visible: {min: 2, max: 6}}});</script><script src="scripts/camera/scripts/camera.min.js" type="text/javascript"></script>
        <script src="scripts/easing/jquery.easing.1.3.js" type="text/javascript"></script>
        <script type="text/javascript">function startCamera() {
                $('#camera_wrap').camera({fx: 'scrollLeft', time: 2000, loader: 'none', playPause: false, navigation: true, height: '65%', pagination: true});
            }
            $(function () {
                startCamera()
            });</script>


    </body>
</html>
