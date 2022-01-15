
<%
HttpSession httpSession = request.getSession();
httpSession.invalidate();
RequestDispatcher dispatcher = request.getRequestDispatcher("/authentification.jsp");
dispatcher.include(request, response);
%>