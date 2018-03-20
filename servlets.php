<main id="servlets">
	  
   <section class="container">
	   
	  <h2 style="color:silver">Servlets</h2>     
	
	<h5 style="color:pink"> Using XML HTTP Request and API, Storing and Retrieving Data </h5>
<br>
    <h6>The Articles of Faith</h6>
       <p>The Articles of Faith outline 13 basic points of belief of The Church of Jesus Christ of Latter-day Saints.</p>
       
       <img src="../mobileSoftware/images/faithVase.jpg" width="60%"><br><br>
       <p>Click the button to see the 13 basic belief of the LDS Church</p>
       
      <style>
        table,th,td {
          border : 1px solid black;
          border-collapse: collapse;
        }
        th,td {
          padding: 5px;
        }
        </style>
        <body>

        <button type="button" onclick="loadXMLDoc()" style="color:pink">Get Articles of Faith</button>
        <br><br>
        <table id="ldsFaith"></table>

        <script>
        function loadXMLDoc() {
          var xmlhttp = new XMLHttpRequest();
          xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
              myFunction(this);
            }
          };
          xmlhttp.open("GET", "fileArticleFaith.xml", true);
          xmlhttp.send();
        }
        function myFunction(xml) {
          var i;
          var xmlDoc = xml.responseXML;
          var table="<tr><th>Articles</th><th>Faith</th></tr>";
          var x = xmlDoc.getElementsByTagName("FAITHART");
          for (i = 0; i <x.length; i++) { 
            table += "<tr><td>" +
            x[i].getElementsByTagName("ARTICLES")[0].childNodes[0].nodeValue +
            "</td><td>" +
            x[i].getElementsByTagName("FAITH")[0].childNodes[0].nodeValue +
            "</td></tr>";
          }
          document.getElementById("ldsFaith").innerHTML = table;
        }
        </script>
       
       </body>
