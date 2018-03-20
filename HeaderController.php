<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>ScintillatingSummer Home Page</title>
     
     <!-- LOAD THE LATEST JQUERY-->
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
	 
	 <!-- LINK TO THE CSS -->
<link href="/css/screen.css" rel="stylesheet">
 <link href="/css/tabletscreen.css" rel="stylesheet">
 <link href="/css/mobilemenu.css" rel="stylesheet">
 
<link rel="stylesheet" href="/css/style.css">
	<style>
	@import url('https://fonts.googleapis.com/css?family=Sorts+Mill+Goudy')	
	@import url('https://fonts.googleapis.com/css?family=Tangerine');	
	@import url('https://fonts.googleapis.com/css?family=Satisfy');
	</style>
     
     
<style type="text/css">
a:link    {
  /* Applies to all unvisited links on page */
  text-decoration:  none;
  font-weight:      bold;
  color: #8d4682;
  } 
a:visited {
  /* Applies to all visited links  on page*/
  text-decoration:  none;
  font-weight:      bold;
  color: #b951a9;
  } 
a:hover   {
  /* Applies to links under the pointer on page */
  text-decoration:  underline;
  font-weight:      bold;
  color: #acacac;
  } 
a:active  {
  /* Applies to activated links on page*/
  text-decoration:  underline;
  font-weight:      bold;
  color: #868686;
  } 
</style>
	 	 
	 <!-- SCRIPT TO MAKE THE MOBILE NAV EXPAND DOWN -->
<script>
	$(document).ready(function(){
		$(".nav-button").click(function () {
		$(".nav-button,.primary-nav").toggleClass("open");
		});    
	});
</script>
     
  <meta name="author" content="Sophia Gannon">
     
  <!-- TELLS PHONES NOT TO LIE ABOUT THEIR WIDTH -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

 </head>
 
 <body>

<header>
	
  <h1> ScintillatingSummer </h1>
  <h2> Let’s relish life as we live it. Every day is a journey!</h2>
  
    
</header>    

<!-- Start of navigation -->
 <!-- the 'if statment' keeps the menu tab highlighted when active  -->   
<nav >
    <ul class="primary-nav">
		
        <li<?php if($activePage=='home') {?> class="active"<?php } //endif ?>><a href="/index.php">Home</a></li>
        
        <li<?php if($activePage=='journey') {?> class="active"<?php } //endif ?>><a href="/journey/journey.php">Journey</a></li> 
        
        <li<?php if($activePage=='beliefs') {?> class="active"<?php } //endif ?>><a href="/beliefs/beliefs.php">Beliefs</a></li> 
        
        <li<?php if($activePage=='recipes') {?> class="active"<?php } //endif ?>><a href="/recipes/recipes.php">Recipes</a></li>  
        
        <li<?php if($activePage=='sysadmin') {?> class="active"<?php } //endif ?>><a href="/sysadmin/sysadmin.php">sysadmin</a></li> 
        
        <li<?php if($activePage=='projects') {?> class="active"<?php } //endif ?> class="parents"><a href="/projects/projects.php">Projects</a>
            <ul>
                <li><a href="/projects/CIT261Project/cit261Project.php">CIT261 Project</a></li>
                <li><a href="/projects/CIT360Project/cit360Project.php">CIT360 Project</a></li>
                <li><a href="/projects/classProject/classProject.php">Class Projects</a></li>
                <li><a href="/projects/test/test2b.php">Testing Page</a></li>
            </ul>
        </li>  
        
        <li<?php if($activePage=='mobileSoftware') {?> class="active"<?php } //endif ?> class="parents" ><a href="/mobileSoftware/mobileSoftware.php">MobileSoft</a>
            <ul>
                <li><a href="/mobileSoftware/javaScript.php">JavaScript</a></li>
                <li><a href="/mobileSoftware/javaScriptObject.php">javaScript Object</a></li>
                <li><a href="/mobileSoftware/ajax.php">Ajax</a></li>
                <li><a href="/mobileSoftware/localstorage.php">Local Storage</a></li>
                <li><a href="/mobileSoftware/dom.php">DOM & Json</a></li>
                <li><a href="/mobileSoftware/CSSClassProperties.php">CSS Class</a></li>
                <li><a href="/mobileSoftware/CSSTransitionsAnimations.php">CSS Tran/Anim</a></li>
                <li><a href="/mobileSoftware/javaScriptEvents.php">javaScript Events</a></li>
                <li><a href="/mobileSoftware/HTML5Tags.php">HTML5 Tags</a></li>
                <li><a href="/mobileSoftware/CSSTransitions.php">CSS Transitions</a></li>
                <li><a href="/mobileSoftware/CSSTransforms.php">CSS Transforms</a></li>
                <li><a href="/mobileSoftware/CSSAnimations.php">CSS Animations</a></li>
            </ul>
        </li>
    
        <li<?php if($activePage=='ooprogramming') {?> class="active"<?php } //endif ?> class="parents" ><a href="/ooprogramming/ooprogramming.php">SoftDevelop</a>
            <ul>
                <li><a href="/ooprogramming/mvc.php">MVC, DOM, and Json</a></li>
                <li><a href="/ooprogramming/servlets.php">Servlets</a></li>
                <li><a href="/ooprogramming/useCaseDiagrams.php">UseCase Diagrams</a></li>
                <li><a href="/ooprogramming/UseCaseDocuments.php">UseCase Document</a></li>
                <li><a href="/ooprogramming/StateDiagrams.php">State Diagrams</a></li>
                <li><a href="/ooprogramming/sequenceDiagrams.php">Sequence Diagrams</a></li>
            </ul>
        </li>
        
		<li<?php if($activePage=='about') {?> class="active"<?php } //endif ?>><a href="/about/about.php">About</a>
            <ul>
                <li<?php if($activePage=='coverLetter') {?> class="active"<?php } //endif ?>><a href="/about/coverLetter.php">Cover Letter</a></li>
                <li<?php if($activePage=='resume') {?> class="active"<?php } //endif ?>><a href="/about/resume.php">Resume</a></li>
            </ul>
        </li>
        
		<li<?php if($activePage=='contact') {?> class="active"<?php } //endif ?>><a href="/contact.php">Contact</a></li>
        
    </ul>
	<!-- PHONE HAMBURGER BUTTON -->
<button class="nav-button">Toggle Navigation</button>

<div class="keepOpen"></div> 
	
</nav>
	 
	 
	 
	 
	 
	 
