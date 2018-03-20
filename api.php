<h6>API, Storing and Retrieving Simple Data</h6>
       
       <p>Fill the left box, save, and see the results in the right</p>
<br>
       <style>
           #leftbox{
               float:left;
               padding:20px;
               border: 3px solid pink;
           }
           #rightbox{
               float: left;
               width: 250px;
               margin-left: 20px; 
               padding: 20px;
               border: 3px solid pink;
            }
            img {
                content: "";
                clear: both;
                display: table;
                float: none;
                padding-top: 20px;
            }

       </style>
       
       <script>
           function doFirst(){
               var button = document.getElementById("button");
               button.addEventListener("click", saveData, false);
               
           }
           function saveData(){
               var one = document.getElementById("one").value;
               var two = document.getElementById("two").value;
               sessionStorage.setItem(one, two);
               
               display(one);
           }
           function display(one){
               var rightbox = document.getElementById("rightbox");
               var two = sessionStorage.getItem(one);
               rightbox.innerHTML = "Hey " + one + "<br />You Love " + two + "!";
           }
           window.addEventListener("load", doFirst, false);
       </script>
       
       <section id="leftbox">
           <form>
           <p>Your Name: <input type="text" id="one"></p>
           <p>You Love: <textarea id="two"></textarea></p>
           <p><input type="button" id="button" value="Save" style="color:pink"></p>
           </form>
       </section>
       
       <section id="rightbox">
           Nothing Yet. Please, tell me something you love.
       </section>
       
      <img src="../mobileSoftware/images/loveStored.jpg" width="40%">
<br>   

     </section> 
   </main> 
