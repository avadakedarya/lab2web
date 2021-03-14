<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.2/css/all.css" integrity="sha384-vSIIfh2YWi9wW0r9iZe7RJPrKwp6bG+s9QZMoITbCckVJqGCCRhc+ccxNcdpHuYu" crossorigin="anonymous">
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #99CCFF;
        }
        .calculator_form {
            width: 340px;
            height: 350px;
            padding: 32px;
            border-radius: 10px;
            box-shadow: 0 4px 16px #ccc;
            font-family: sans-serif;
            letter-spacing: 1px;
            background-color: #0099FF;
        }
        .header {
            color: white;
            text-align: center;
            margin: 0 0 5px 0;
            font-weight: normal;
        }
        .form_button {
            padding: 10px 10px;
            margin: 0 0 0 0px;
            border: none;
            border-radius: 5px;
            font-family: sans-serif;
            letter-spacing: 1px;
            font-size: 16px;
            color :#fff ;
            background-color: #2980b9;
            outline: none;
            cursor: pointer;
            transition: 0.3s;
        }
        .form_group {
            position: relative;
            margin-bottom: 32px;
        }
        .form_input {
            width: 100%;
            padding: 0 0 2px 0;
            border: none;
            border-bottom: 1px solid #e0e0e0;
            background-color: transparent;
            outline: none;
            transition: 0.3s;
        }
        .form_label {
            top: -1px;
            color: white;
            transition: 0.3s;
        }
        .form_button:focus,
        .form_button:hover {
            background-color: rgba(0, 113, 240, 0.7);
        }
        .custom-dropdown {
            position: relative;
            display: inline-block;
            vertical-align: middle;
            margin: 0 30px 0 0;
        }
        .custom-dropdown select {
            width: 190px;
            cursor:pointer;
            background-color: #2980b9;
            color: #fff;
            font-size: inherit;
            padding: .5em 2.5em .5em .5em;
            border: 0;
            margin: 0;
            border-radius: 3px;
            text-indent: 0px;
            text-overflow: '';
            -webkit-appearance: button;
        }
        .custom-dropdown::before,
        .custom-dropdown::after {
            content: "";
            position: absolute;
            pointer-events: none;
        }
        .custom-dropdown::after {
            content: "\25BC";
            height: 1em;
            font-size: .625em;
            line-height: 1;
            right: 1.2em;
            top: 50%;
            margin-top: -.5em;
        }
        .custom-dropdown::before {
            width: 2em;
            right: 0;
            top: 0;
            bottom: 0;
        }
        .custom-dropdown:hover {
            border-radius: 0 3px 3px 0;
        }
        .custom-dropdown select[disabled] {
            color: rgba(0,0,0,.3);
        }
        .custom-dropdown select[disabled]::after {
            color: rgba(0,0,0,.1);
        }
        .custom-dropdown::before {
            background-color: rgba(0,0,0,.15);
        }
        .custom-dropdown::after {
            color: rgba(0,0,0,.4);
        }
        .cloud {
            width: 350px; height: 120px;

            /*background: #FFF;*/
            /*background: linear-gradient(top, #FFF 100%);*/
            /*background: -webkit-linear-gradient(top, #FFF 100%);*/
            /*background: -moz-linear-gradient(top, #FFF 100%);*/
            /*background: -ms-linear-gradient(top, #FFF 100%);*/
            /*background: -o-linear-gradient(top, #FFF 100%);*/

            border-radius: 100px;
            -webkit-border-radius: 100px;
            -moz-border-radius: 100px;

            position: absolute;
            margin: 120px auto 20px;
            z-index:-1;
            transition: ease 1s;
        }

        .cloud:after, .cloud:before {
            content: '';
            position: absolute;
            background: #FFF;
            z-index: -1
        }

        .cloud:after {
            width: 100px; height: 100px;
            top: -50px; left: 50px;

            border-radius: 100px;
            -webkit-border-radius: 100px;
            -moz-border-radius: 100px;
        }

        .cloud:before {
            width: 180px; height: 180px;
            top: -90px; right: 50px;

            border-radius: 200px;
            -webkit-border-radius: 200px;
            -moz-border-radius: 200px;
        }

        .x1 {
            top:-50px;
            left:100px;
            -webkit-transform: scale(0.3);
            -moz-transform: scale(0.3);
            transform: scale(0.3);
            opacity: 0.9;
            -webkit-animation: moveclouds 15s linear infinite;
            -moz-animation: moveclouds 15s linear infinite;
            -o-animation: moveclouds 15s linear infinite;
        }

        .x1_5{
            top:-80px;
            left:250px;
            -webkit-transform: scale(0.3);
            -moz-transform: scale(0.3);
            transform: scale(0.3);
            -webkit-animation: moveclouds 17s linear infinite;
            -moz-animation: moveclouds 17s linear infinite;
            -o-animation: moveclouds 17s linear infinite;
        }

        .x2 {
            left: 250px;
            top:30px;
            -webkit-transform: scale(0.6);
            -moz-transform: scale(0.6);
            transform: scale(0.6);
            opacity: 0.6;
            -webkit-animation: moveclouds 25s linear infinite;
            -moz-animation: moveclouds 25s linear infinite;
            -o-animation: moveclouds 25s linear infinite;
        }

        .x3 {
            left: 250px; bottom: -70px;

            -webkit-transform: scale(0.6);
            -moz-transform: scale(0.6);
            transform: scale(0.6);
            opacity: 0.8;

            -webkit-animation: moveclouds 25s linear infinite;
            -moz-animation: moveclouds 25s linear infinite;
            -o-animation: moveclouds 25s linear infinite;
        }

        .x4 {
            left: 470px; botttom: 20px;

            -webkit-transform: scale(0.75);
            -moz-transform: scale(0.75);
            transform: scale(0.75);
            opacity: 0.75;

            -webkit-animation: moveclouds 18s linear infinite;
            -moz-animation: moveclouds 18s linear infinite;
            -o-animation: moveclouds 18s linear infinite;
        }

        .x5 {
            left: 200px; top: 300px;

            -webkit-transform: scale(0.5);
            -moz-transform: scale(0.5);
            transform: scale(0.5);
            opacity: 0.8;

            -webkit-animation: moveclouds 20s linear infinite;
            -moz-animation: moveclouds 20s linear infinite;
            -o-animation: moveclouds 20s linear infinite;
        }

        @-webkit-keyframes moveclouds {
            0% {margin-left: 1000px;}
            100% {margin-left: -1000px;}
        }
        @-moz-keyframes moveclouds {
            0% {margin-left: 1000px;}
            100% {margin-left: -1000px;}
        }
        @-o-keyframes moveclouds {
            0% {margin-left: 1000px;}
            100% {margin-left: -1000px;}
        }
    </style>
</head>
<body>
<div id="clouds">
    <div class="cloud x1"></div>
    <div class="cloud x1_5"></div>
    <div class="cloud x2"></div>
    <div class="cloud x3"></div>
    <div class="cloud x4"></div>
    <div class="cloud x5"></div>
</div>
<form action="simple-calculator" class="calculator_form">
    <h1 class="header"><i class="fas fa-calculator"></i>  Calculator</h1>
    <div class="form_group">
        <label class="form_label">a
            <input class="form_input" type="text" name="a"/>
        </label>
    </div>
    <div class="form_group">
        <label class="form_label">b
            <input class="form_input" type="text" name="b"/>
        </label>
    </div>
    <div class="form_group">
        <label class="form_label">c
            <input class="form_input" type="text" name="c"/>
        </label>
    </div>
    <div class="form_group">
        <label class="form_label">d
            <input class="form_input" type="text" name="d"/>
        </label>
    </div>
    <label>
        <span class="custom-dropdown">
            <select name="equations">
                <option value="Choose equation" label="Choose equation">Choose equation</option>
                <option value="First equation" label="">First equation</option>
                <option value="Second equation">Second equation</option>
                <option value="Third equation">Third equation</option>
            </select>
        </span>
    </label>
    <label>
        <input class="form_button" type="submit" value="Calculate"/>
    </label>
</form>
</body>
</html>