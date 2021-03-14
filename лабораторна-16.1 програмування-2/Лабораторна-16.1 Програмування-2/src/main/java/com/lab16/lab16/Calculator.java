package com.lab16.lab16;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import equations.Choice;
import cookies.*;

@WebServlet(name = "simpleCalculator", value = "/simple-calculator")
public class Calculator extends HttpServlet {

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        String fileName = "C:\\Users\\User\\Desktop\\ira ko,p logica\\лабораторна-16.1 програмування-2\\Лабораторна-16.1 Програмування-2\\src\\main\\webapp\\Cookies.txt";

        double result = 0;

        try {
            result = Choice.choice(request.getParameter("a"), request.getParameter("b"), request.getParameter("c"), request.getParameter("d"), request.getParameter("equations"));
        } catch (NumberFormatException exception) {
            response.sendRedirect("error.jsp");
        }

        Cookie cookieA = new Cookie("a", request.getParameter("a")), cookieB = new Cookie("b", request.getParameter("b")),
                cookieC = new Cookie("c", request.getParameter("c")), cookieD = new Cookie("d", request.getParameter("d")),
                cookieResult = new Cookie("result", Double.toString(result));

        response.addCookie(cookieA); response.addCookie(cookieB); response.addCookie(cookieC);
        response.addCookie(cookieD); response.addCookie(cookieResult);

        Cookie[] cookies = request.getCookies();

        DateChecker.dateCheck(fileName);

        FileFiller.fillFile(cookies, fileName);

        try(PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Table</title>\n" +
                    "    <style>\n" +
                    "        body {\n" +
                    "            display: flex;\n" +
                    "            justify-content: center;\n" +
                    "            height: 100vh;\n" +
                    "            background-color: #99CCFF;\n" +
                    "        }\n" +
                    "        .complex {\n" +
                    "            width: 800px;\n" +
                    "            height: 6px;\n" +
                    "            padding: 32px;\n" +
                    "            border-radius: 10px;\n" +
                    "            font-family: sans-serif;\n" +
                    "            letter-spacing: 1px;\n" +
                    "            background-color: #0099FF;\n" +
                    "            margin-top: 32px;\n" +
                    "        }\n" +
                    "        .header {\n" +
                    "            color: white;\n" +
                    "            text-align: center;\n" +
                    "            justify-content: center;\n" +
                    "            font-weight: normal;\n" +
                    "            margin-top: -20px;\n" +
                    "            margin-bottom: 40px;\n" +
                    "        }\n" +
                    "        table {\n" +
                    "            font-family: \"Lucida Sans Unicode\", \"Lucida Grande\", Sans-Serif;\n" +
                    "            font-size: 14px;\n" +
                    "            border-collapse: collapse;\n" +
                    "            text-align: center;\n" +
                    "        }\n" +
                    "        th, td:first-child {\n" +
                    "            background: #0099FF;\n" +
                    "            color: white;\n" +
                    "            padding: 10px 20px;\n" +
                    "        }\n" +
                    "        th, td {\n" +
                    "            border-style: solid;\n" +
                    "            border-width: 0 1px 1px 0;\n" +
                    "            border-color: #99CCFF;\n" +
                    "        }\n" +
                    "        td {\n" +
                    "            background: #0099FF;\n" +
                    "        }\n" +
                    "        th:first-child, td:first-child {\n" +
                    "            text-align: left;\n" +
                    "        }\n" +
                    "        .cloud {\n" +
                    "            width: 350px; height: 120px;\n" +
                    "\n" +
                    "            background: #FFF;\n" +
                    "            background: linear-gradient(top, #FFF 100%);\n" +
                    "            background: -webkit-linear-gradient(top, #FFF 100%);\n" +
                    "            background: -moz-linear-gradient(top, #FFF 100%);\n" +
                    "            background: -ms-linear-gradient(top, #FFF 100%);\n" +
                    "            background: -o-linear-gradient(top, #FFF 100%);\n" +
                    "\n" +
                    "            border-radius: 100px;\n" +
                    "            -webkit-border-radius: 100px;\n" +
                    "            -moz-border-radius: 100px;\n" +
                    "\n" +
                    "            position: absolute;\n" +
                    "            margin: 120px auto 20px;\n" +
                    "            z-index:-1;\n" +
                    "            transition: ease 1s;\n" +
                    "        }\n" +
                    "\n" +
                    "        .cloud:after, .cloud:before {\n" +
                    "            content: '';\n" +
                    "            position: absolute;\n" +
                    "            background: #FFF;\n" +
                    "            z-index: -1\n" +
                    "        }\n" +
                    "\n" +
                    "        .cloud:after {\n" +
                    "            width: 100px; height: 100px;\n" +
                    "            top: -50px; left: 50px;\n" +
                    "\n" +
                    "            border-radius: 100px;\n" +
                    "            -webkit-border-radius: 100px;\n" +
                    "            -moz-border-radius: 100px;\n" +
                    "        }\n" +
                    "\n" +
                    "        .cloud:before {\n" +
                    "            width: 180px; height: 180px;\n" +
                    "            top: -90px; right: 50px;\n" +
                    "\n" +
                    "            border-radius: 200px;\n" +
                    "            -webkit-border-radius: 200px;\n" +
                    "            -moz-border-radius: 200px;\n" +
                    "        }\n" +
                    "\n" +
                    "        .x1 {\n" +
                    "            top:-50px;\n" +
                    "            left:100px;\n" +
                    "            -webkit-transform: scale(0.3);\n" +
                    "            -moz-transform: scale(0.3);\n" +
                    "            transform: scale(0.3);\n" +
                    "            opacity: 0.9;\n" +
                    "            -webkit-animation: moveclouds 15s linear infinite;\n" +
                    "            -moz-animation: moveclouds 15s linear infinite;\n" +
                    "            -o-animation: moveclouds 15s linear infinite;\n" +
                    "        }\n" +
                    "\n" +
                    "        .x1_5{\n" +
                    "            top:-80px;\n" +
                    "            left:250px;\n" +
                    "            -webkit-transform: scale(0.3);\n" +
                    "            -moz-transform: scale(0.3);\n" +
                    "            transform: scale(0.3);\n" +
                    "            -webkit-animation: moveclouds 17s linear infinite;\n" +
                    "            -moz-animation: moveclouds 17s linear infinite;\n" +
                    "            -o-animation: moveclouds 17s linear infinite;\n" +
                    "        }\n" +
                    "\n" +
                    "        .x2 {\n" +
                    "            left: 250px;\n" +
                    "            top:30px;\n" +
                    "            -webkit-transform: scale(0.6);\n" +
                    "            -moz-transform: scale(0.6);\n" +
                    "            transform: scale(0.6);\n" +
                    "            opacity: 0.6;\n" +
                    "            -webkit-animation: moveclouds 25s linear infinite;\n" +
                    "            -moz-animation: moveclouds 25s linear infinite;\n" +
                    "            -o-animation: moveclouds 25s linear infinite;\n" +
                    "        }\n" +
                    "\n" +
                    "        .x3 {\n" +
                    "            left: 250px; bottom: -70px;\n" +
                    "\n" +
                    "            -webkit-transform: scale(0.6);\n" +
                    "            -moz-transform: scale(0.6);\n" +
                    "            transform: scale(0.6);\n" +
                    "            opacity: 0.8;\n" +
                    "\n" +
                    "            -webkit-animation: moveclouds 25s linear infinite;\n" +
                    "            -moz-animation: moveclouds 25s linear infinite;\n" +
                    "            -o-animation: moveclouds 25s linear infinite;\n" +
                    "        }\n" +
                    "\n" +
                    "        .x4 {\n" +
                    "            left: 470px; botttom: 20px;\n" +
                    "\n" +
                    "            -webkit-transform: scale(0.75);\n" +
                    "            -moz-transform: scale(0.75);\n" +
                    "            transform: scale(0.75);\n" +
                    "            opacity: 0.75;\n" +
                    "\n" +
                    "            -webkit-animation: moveclouds 18s linear infinite;\n" +
                    "            -moz-animation: moveclouds 18s linear infinite;\n" +
                    "            -o-animation: moveclouds 18s linear infinite;\n" +
                    "        }\n" +
                    "\n" +
                    "        .x5 {\n" +
                    "            left: 200px; top: 300px;\n" +
                    "\n" +
                    "            -webkit-transform: scale(0.5);\n" +
                    "            -moz-transform: scale(0.5);\n" +
                    "            transform: scale(0.5);\n" +
                    "            opacity: 0.8;\n" +
                    "\n" +
                    "            -webkit-animation: moveclouds 20s linear infinite;\n" +
                    "            -moz-animation: moveclouds 20s linear infinite;\n" +
                    "            -o-animation: moveclouds 20s linear infinite;\n" +
                    "        }\n" +
                    "\n" +
                    "        @-webkit-keyframes moveclouds {\n" +
                    "            0% {margin-left: 1000px;}\n" +
                    "            100% {margin-left: -1000px;}\n" +
                    "        }\n" +
                    "        @-moz-keyframes moveclouds {\n" +
                    "            0% {margin-left: 1000px;}\n" +
                    "            100% {margin-left: -1000px;}\n" +
                    "        }\n" +
                    "        @-o-keyframes moveclouds {\n" +
                    "            0% {margin-left: 1000px;}\n" +
                    "            100% {margin-left: -1000px;}\n" +
                    "        }" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>");
            out.println("<div id=\"clouds\">\n" +
                    "    <div class=\"cloud x1\"></div>\n" +
                    "    <div class=\"cloud x1_5\"></div>\n" +
                    "    <div class=\"cloud x2\"></div>\n" +
                    "    <div class=\"cloud x3\"></div>\n" +
                    "    <div class=\"cloud x4\"></div>\n" +
                    "    <div class=\"cloud x5\"></div>\n" +
                    "</div>");
            out.println("<div class=\"complex\">\n");
            if (result == 0) {
                response.sendRedirect("error.jsp");
            } else {
                out.println("<h1 class=\"header\"><font face=\"Verdana\">Result:" + cookieResult.getValue() + "</font></h1>");
            }
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
                String inputLines;
                out.println("<table>\n");
                out.println("<th>Cookies for the last two days</th>");
                while ((inputLines = bufferedReader.readLine()) != null) {
                    out.println("   <tr>\n");
                    out.println("    <td>" + inputLines + "</td>\n");
                    out.println("  </tr>\n");
                }
            }
            out.println(" </table>");
            out.println("</div>\n");
            out.println("</body></html>");
        }
    }

    public void destroy() {}
}