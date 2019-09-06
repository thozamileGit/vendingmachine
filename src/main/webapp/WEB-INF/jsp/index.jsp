<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <title> Vending Machine</title>
        <!-- Bootstrap core CSS -->
        <link type="text/css" href="css/bootstrap.css" rel="stylesheet">        
    </head>
    <body>        
        <div class="container">
            <h1 class="text-center" style="margin-top: 30px">Vending Machine</h1>
            <hr style="margin-bottom: 30px">
            <!-- SNACKS -->
            <div id="snackColumn" class="col-sm-9">
                <c:forEach var="snack" items="${snacks}">                    
                    <div class="col-sm-4">
                        <div class="panel panel-default">
                            <a style="text-decoration:none" href="${contextPath}/makeSelection/${snack.id}">
                            <div class="panel-body">
                                    <p class="text-left">${snack.id}</p>
                                    <p class="text-center">${snack.name}</p>
                                    <p class="text-center">R${snack.price}</p>
                                    <br><p class="text-center">Quantity Left: ${snack.quantity}</p>
                                    <br><img alt="logo" src="images/${snack.id}.jpg" style="width:200px;height:200px;">
                            </div>
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </div>
            
            <!-- FORMS -->
            <div class="col-sm-3">
                <div class="row">
                    <h3 class="text-center">Total R In</h3>
                    <form>
                        <div class="form-group">
                            <input class="form-control" id="balance" type="text" value="${balance}" disabled>
                        </div>
                    </form>
                    <div class="text-center">
                        <a href="${contextPath}/addMoney/oneRand" class="btn btn-default">Add One Rand</a>
                        <a href="${contextPath}/addMoney/twoRand" class="btn btn-default">Add Two Rand</a>
                    </div>
                    <div class="text-center">
                        <a href="${contextPath}/addMoney/fiveRand" class="btn btn-default">Add Five Rand</a>
                        <a href="${contextPath}/addMoney/tenRand" class="btn btn-default">Add Tend Rand</a>
                    </div>
                    <hr>
                </div>
                <div class="row">
                    <h3 class="text-center">Messages</h3>
                    <form>
                        <div class="form-group">
                            <input value="${message}" class="form-control" disabled></input>
                        </div>
                        <div class="form-group">
                            <h3 style="display:inline">Item: </h3>
                            <input id="itemNum" class="form-control" type="text" value="<c:if test="${selection != 0}">${selection}</c:if>" style="width:75%;display:inline" disabled>
                        </div>
                    </form>
                    <a href="makePurchase" class="btn btn-default btn-block">Make Purchase</a>
                    <hr>
                </div>
                <div class="row" style="margin-bottom: 30px">
                    <h3 class="text-center">Change</h3>
                    <form>
                        <div class="form-group">
                            <textarea id="changeMsg" class="form-control" row="2" disabled><c:if test="${myChange != null}">${myChange}</c:if></textarea>
                        </div>
                    </form>
                    <a class="btn btn-default btn-block" href="changeReturn">Change Return</a>
                </div>
            </div>
        </div>      
        
        <!-- Placed at the end of the document so the pages load faster -->
        <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/home.js"></script>
        
    </body>
</html>

