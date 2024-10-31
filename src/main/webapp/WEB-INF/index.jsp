<%@ page import="org.chousik.weblab2.bean.PointDao" %>
<%@ page import="org.chousik.weblab2.models.Point" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../styles/style.css">
  <title>Лабораторная работа №1</title>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="../scripts/validator.js"></script>
  <script src="../scripts/canvas.js"></script>
  <script src="../scripts/script.js"></script>
</head>
<body>
<div class="head">
  <header class="element">
    <h1>Silaev Zahar P3210 409555 V-44443</h1>
  </header>
</div>
<div class="all">
  <div class="main-container">
    <div class="input-container">
      <div class="input_XYR element">
        <label for="X_table" class="input_text">Choose X:</label>
        <div class="radio_container" id = "X_table">
          <div class="form_radio">
            <label>
              <input id = "radio_-3" type="radio" name="X" value="-3">
              <label for="radio_-3">-3</label>
            </label>
          </div>
          <div class="form_radio">
            <label>
              <input id = "radio_-2" type="radio" name="X" value="-2">
              <label for="radio_-2">-2</label>
            </label>
          </div>
          <div class="form_radio">
            <label>
              <input id = "radio_-1" type="radio" name="X" value="-1">
              <label for="radio_-1">-1</label>
            </label>
          </div>
          <div class="form_radio">
            <label>
              <input id = "radio_0" type="radio" name="X" value="0" >
              <label for="radio_0">0</label>
            </label>
          </div>
          <div class="form_radio">
            <label>
              <input id = "radio_1" type="radio" name="X" value="1">
              <label for="radio_1">1</label>
            </label>
          </div>
          <div class="form_radio">
            <label>
              <input id = "radio_2" type="radio" name="X" value="2">
              <label for="radio_2">2</label>
            </label>
          </div>
          <div class="form_radio">
            <label>
              <input id = "radio_3" type="radio" name="X" value="3">
              <label for="radio_3">3</label>
            </label>
          </div>
          <div class="form_radio">
            <label>
              <input id = "radio_4" type="radio" name="X" value="4">
              <label for="radio_4">4</label>
            </label>
          </div>
          <div class="form_radio">
            <label>
              <input id = "radio_5" type="radio" name="X" value="5">
              <label for="radio_5">5</label>
            </label>
          </div>
        </div>
      </div>
      <div class="input_XYR element">
        <label for="Y_input" class="input_text">Input Y:</label>
        <label>
          <input required name="Y-input" id = "Y_input" type="text" placeholder="-3..3" class="input">
        </label>
      </div>
      <div class="input_XYR element">
        <label for="R_table" class="input_text">Choose R:</label>
        <div class="radio_container" id = "R_table">
          <div class="form_radio">
            <label>
              <input id = "R_1" type="radio" name="R" value="1" checked>
              <label for="R_1">1.0</label>
            </label>
          </div>
          <div class="form_radio">
            <label>
              <input id = "R_1.5" type="radio" name="R" value="1.5">
              <label for="R_1.5">1.5</label>
            </label>
          </div>
          <div class="form_radio">
            <label>
              <input id = "R_2" type="radio" name="R" value="2">
              <label for="R_2">2.0</label>
            </label>
          </div>
          <div class="form_radio">
            <label>
              <input id = "R_2.5" type="radio" name="R" value="2.5">
              <label for="R_2.5">2.5</label>
            </label>
          </div>
          <div class="form_radio">
            <label>
              <input id = "R_3" type="radio" name="R" value="3">
              <label for="R_3">3.0</label>
            </label>
          </div>
        </div>
      </div>
      <div class="canvas-container element" id="canvas-container">
        <canvas id = "canvas" class="canvas">Your browser is not supported</canvas>
      </div>
    </div>
    <div class="button-container">
      <button type="button" class="buttons" id="check_button">Check</button>
    </div>
  </div>
  <div class="result-table">
    <table id="result_table" class="table">
      <tr id="head-table">
        <td>x</td>
        <td>y</td>
        <td>r</td>
        <td>status</td>
        <td>current time</td>
        <td>script runtime</td>
      </tr>
      <%
        PointDao bean = (PointDao) request.getSession().getAttribute("bean");
        if (bean == null){
          bean = new PointDao();
        }
      %>
      <% for(Point point: bean.getPoints()){ %>
        <tr>
          <td><%=point.x()%></td>
          <td><%=point.y()%></td>
          <td><%=point.r()%></td>
          <td><%=point.inFlag()%></td>
          <td><%=point.time()%></td>
          <td><%=point.executionTime()%></td>
        </tr>
      <%}%>
    </table>
  </div>
</div>
</body>
</html>