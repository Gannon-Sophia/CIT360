<%-- 
    Document   : welcomeView
    Created on : Apr 6, 2018, 12:28:46 PM
    Author     : Sophie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello</title>
    </head>
    <body>
        <h1>${welcomeMessage}</h1>
        <h3>This is a MVC project</h3>
        <p>Model - The model represents data and the rules that govern access to and updates of this data.<br>
            In enterprise software, a model often serves as a software approximation of a real-world process.</p>
        <p>View - The view renders the contents of a model. It specifies exactly how the model data should be presented.<br>
            If the model data changes, the view must update its presentation as needed. This can be achieved by using a push model,<br>
            in which the view registers itself with the model for change notifications, or a pull model, in which the view is responsible<br>
            for calling the model when it needs to retrieve the most current data.</p>
        <p>Controller - The controller translates the user's interactions with the view into actions that the model will perform. <br>
            In a stand-alone GUI client, user interactions could be button clicks or menu selections, <br>
            whereas in an enterprise web application, they appear as GET and POST HTTP requests.<br>
            Depending on the context, a controller may also select a new view -- for example, a web page of results -- to present back to the user.</p>
        
    </body>
</html>
